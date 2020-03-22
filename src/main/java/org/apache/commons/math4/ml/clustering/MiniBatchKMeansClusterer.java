/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.math4.ml.clustering;

import org.apache.commons.math4.exception.ConvergenceException;
import org.apache.commons.math4.exception.MathIllegalArgumentException;
import org.apache.commons.math4.exception.NumberIsTooSmallException;
import org.apache.commons.math4.ml.distance.DistanceMeasure;
import org.apache.commons.math4.util.MathUtils;
import org.apache.commons.math4.util.Pair;
import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.sampling.ListSampler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Clustering algorithm <a href="https://www.eecs.tufts.edu/~dsculley/papers/fastkmeans.pdf">
 * based on KMeans</a>.
 *
 * @param <T> Type of the points to cluster.
 */
public class MiniBatchKMeansClusterer<T extends Clusterable> extends KMeansPlusPlusClusterer<T> {
    /** Batch data size in iteration. */
    private final int batchSize;
    /** Iteration count of initialize the centers. */
    private final int initIterations;
    /** Data size of batch to initialize the centers. */
    private final int initBatchSize;
    /** Maximum number of iterations during which no improvement is occuring. */
    private final int maxNoImprovementTimes;


    /**
     * Build a clusterer.
     *
     * @param k Number of clusters to split the data into.
     * @param maxIterations Maximum number of iterations to run the algorithm for all the points,
     * The actual number of iterationswill be smaller than {@code maxIterations * size / batchSize},
     * where {@code size} is the number of points to cluster.
     * Disabled if negative.
     * @param batchSize Batch size for training iterations.
     * @param initIterations Number of iterations allowed in order to find out the best initial centers.
     * @param initBatchSize Batch size for initializing the clusters centers.
     * A value of {@code 3 * batchSize} should be suitable in most cases.
     * @param maxNoImprovementTimes Maximum number of iterations during which no improvement is occuring.
     * A value of 10 is suitable in most cases.
     * @param measure Distance measure.
     * @param random Random generator.
     * @param emptyStrategy Strategy for handling empty clusters that may appear during algorithm iterations.
     */
    public MiniBatchKMeansClusterer(final int k, final int maxIterations, final int batchSize, final int initIterations,
                                    final int initBatchSize, final int maxNoImprovementTimes,
                                    final DistanceMeasure measure, final UniformRandomProvider random,
                                    final EmptyClusterStrategy emptyStrategy) {
        super(k, maxIterations, measure, random, emptyStrategy);
        if (batchSize < 1) throw new NumberIsTooSmallException(batchSize, 1, true);
        else this.batchSize = batchSize;
        if (initIterations < 1) throw new NumberIsTooSmallException(initIterations, 1, true);
        else this.initIterations = initIterations;
        if (initBatchSize < 1) throw new NumberIsTooSmallException(initBatchSize, 1, true);
        else this.initBatchSize = initBatchSize;
        if (maxNoImprovementTimes < 1) throw new NumberIsTooSmallException(maxNoImprovementTimes, 1, true);
        else this.maxNoImprovementTimes = maxNoImprovementTimes;
    }

    /**
     * Runs the MiniBatch K-means clustering algorithm.
     *
     * @param points Points to cluster (cannot be {@code null}).
     * @return the clusters.
     * @throws MathIllegalArgumentException if number of points is
     * smaller than the number of clusters.
     */
    @Override
    public List<CentroidCluster<T>> cluster(final Collection<T> points) throws MathIllegalArgumentException, ConvergenceException {
        // sanity checks
        MathUtils.checkNotNull(points);

        // number of clusters has to be smaller or equal the number of data points
        if (points.size() < getK()) {
            throw new NumberIsTooSmallException(points.size(), getK(), false);
        }

        final int pointSize = points.size();
        final int batchCount = pointSize / batchSize + ((pointSize % batchSize > 0) ? 1 : 0);
        final int max = this.getMaxIterations() < 0 ? Integer.MAX_VALUE : (this.getMaxIterations() * batchCount);
        List<CentroidCluster<T>> clusters = initialCenters(points);
        // Loop execute the mini batch steps until reach the max loop times, or cannot improvement anymore.
        final MiniBatchImprovementEvaluator evaluator = new MiniBatchImprovementEvaluator();
        for (int i = 0; i < max; i++) {
            //Clear points in clusters
            clearClustersPoints(clusters);
            //Random sampling a mini batch of points.
            final List<T> batchPoints = randomMiniBatch(points, batchSize);
            // Processing the mini batch training step
            final Pair<Double, List<CentroidCluster<T>>> pair = step(batchPoints, clusters);
            final double squareDistance = pair.getFirst();
            clusters = pair.getSecond();
            // Evaluate the training can finished early.
            if (evaluator.convergence(squareDistance, pointSize)) break;
        }

        //Add every mini batch points to their nearest cluster.
        clearClustersPoints(clusters);
        for (final T point : points) {
            addToNearestCentroidCluster(point, clusters);
        }
        return clusters;
    }

    /**
     * Helper method.
     *
     * @param clusters Clusters to clear.
     */
    private void clearClustersPoints(final List<CentroidCluster<T>> clusters) {
        for (CentroidCluster<T> cluster : clusters) {
            cluster.getPoints().clear();
        }
    }

    /**
     * Mini batch iteration step.
     *
     * @param batchPoints Points selected for this batch.
     * @param clusters Centers of the clusters.
     * @return the squared distance of all the batch points to the nearest center.
     */
    private Pair<Double, List<CentroidCluster<T>>> step(
            final List<T> batchPoints,
            final List<CentroidCluster<T>> clusters) {
        // Add every mini batch points to their nearest cluster.
        for (final T point : batchPoints) {
            addToNearestCentroidCluster(point, clusters);
        }
        final List<CentroidCluster<T>> newClusters = adjustClustersCenters(clusters);
        // Add every mini batch points to their nearest cluster again.
        double squareDistance = 0.0;
        for (T point : batchPoints) {
            final double d = addToNearestCentroidCluster(point, newClusters);
            squareDistance += d * d;
        }
        return new Pair<>(squareDistance, newClusters);
    }

    /**
     * Extract a random subset of the given {@code points}.
     *
     * @param points All the points to cluster.
     * @param batchSize Mini batch size.
     * @return mini batch of all the points.
     */
    private List<T> randomMiniBatch(final Collection<T> points,
                                    final int batchSize) {
        final ArrayList<T> list = new ArrayList<>(points);
        ListSampler.shuffle(getRandomGenerator(), list);
        return list.subList(0, batchSize);
    }

    /**
     * Initializes the clusters centers.
     *
     * @param points Points used to initialize the centers.
     * @return clusters with their center initialized.
     */
    private List<CentroidCluster<T>> initialCenters(final Collection<T> points) {
        final List<T> validPoints = initBatchSize < points.size() ?
                randomMiniBatch(points, initBatchSize) : new ArrayList<>(points);
        double nearestSquareDistance = Double.POSITIVE_INFINITY;
        List<CentroidCluster<T>> bestCenters = null;
        for (int i = 0; i < initIterations; i++) {
            final List<T> initialPoints = (initBatchSize < points.size()) ?
                    randomMiniBatch(points, initBatchSize) : new ArrayList<>(points);
            final List<CentroidCluster<T>> clusters = getCentroidInitializer().selectCentroids(initialPoints, getK());
            final Pair<Double, List<CentroidCluster<T>>> pair = step(validPoints, clusters);
            final double squareDistance = pair.getFirst();
            final List<CentroidCluster<T>> newClusters = pair.getSecond();
            //Find out a best centers that has the nearest total square distance.
            if (squareDistance < nearestSquareDistance) {
                nearestSquareDistance = squareDistance;
                bestCenters = newClusters;
            }
        }
        return bestCenters;
    }

    /**
     * Adds a point to the cluster whose center is closest.
     *
     * @param point Point to add.
     * @param clusters Clusters.
     * @return the distance between point and the closest center.
     */
    private double addToNearestCentroidCluster(final T point, final List<CentroidCluster<T>> clusters) {
        double minDistance = Double.POSITIVE_INFINITY;
        CentroidCluster<T> closestCentroidCluster = null;
        // Iterate clusters and find out closest cluster to the point
        for (CentroidCluster<T> centroidCluster : clusters) {
            final double distance = distance(point, centroidCluster.getCenter());
            if (distance < minDistance) {
                minDistance = distance;
                closestCentroidCluster = centroidCluster;
            }
        }
        assert closestCentroidCluster != null;
        closestCentroidCluster.addPoint(point);
        return minDistance;
    }

    /**
     * Stopping criterion.
     * The evaluator checks whether improvement occurred during the
     * {@link #maxNoImprovementTimes allowed number of successive iterations}.
     */
    class MiniBatchImprovementEvaluator {
        /** Missing doc. */
        private Double ewaInertia = null;
        /** Missing doc. */
        private double ewaInertiaMin = Double.POSITIVE_INFINITY;
        /** Missing doc. */
        private int noImprovementTimes = 0;

        /**
         * Evaluate whether the iteration should finish where square has no improvement for appointed times
         *
         * @param squareDistance the total square distance of the mini batch points to their nearest center.
         * @param pointSize      size of the the data points.
         * @return true if no improvement for appointed times, otherwise false
         */
        public boolean convergence(final double squareDistance, final int pointSize) {
            final double batchInertia = squareDistance / batchSize;
            if (ewaInertia == null) {
                ewaInertia = batchInertia;
            } else {
                // Refer to sklearn, pointSize+1 maybe intent to avoid the div/0 error,
                // but java double does not have a div/0 error
                double alpha = batchSize * 2.0 / (pointSize + 1);
                alpha = Math.min(alpha, 1.0);
                ewaInertia = ewaInertia * (1 - alpha) + batchInertia * alpha;
            }

            // Improved
            if (ewaInertia < ewaInertiaMin) {
                noImprovementTimes = 0;
                ewaInertiaMin = ewaInertia;
            } else {
                // No improvement
                noImprovementTimes++;
            }
            // Has no improvement continuous for many times
            return noImprovementTimes >= maxNoImprovementTimes;
        }
    }
}
