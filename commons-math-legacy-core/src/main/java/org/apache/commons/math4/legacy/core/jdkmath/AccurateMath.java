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
package org.apache.commons.math4.legacy.core.jdkmath;

import java.io.PrintStream;

import org.apache.commons.math4.legacy.core.MathProfile;
import org.apache.commons.math4.legacy.core.provider.MathAPI;
import org.apache.commons.numbers.core.Precision;
import org.apache.commons.math4.legacy.exception.MathArithmeticException;
import org.apache.commons.math4.legacy.exception.util.LocalizedFormats;

/**
 * Portable alternative to {@link Math} and {@link StrictMath}.
 * <p>
 * Caveat: At the time of implementation, the {@code AccurateMath} functions
 * were often faster and/or more accurate than their JDK equivalent.
 * Nowadays, it would not be surprising that they are always slower (due
 * to the various JVM optimizations that have appeared since Java 5).
 * However, any change to this class should ensure that the current
 * accuracy is not lost.
 * <p>
 * AccurateMath is a drop-in replacement for both Math and StrictMath. This
 * means that for any method in Math (say {@code Math.sin(x)} or
 * {@code Math.cbrt(y)}), user can directly change the class and use the
 * methods as is (using {@code AccurateMath.sin(x)} or {@code AccurateMath.cbrt(y)}
 * in the previous example).
 * </p>
 * <p>
 * AccurateMath speed is achieved by relying heavily on optimizing compilers
 * to native code present in many JVMs today and use of large tables.
 * The larger tables are lazily initialized on first use, so that the setup
 * time does not penalize methods that don't need them.
 * </p>
 * <p>
 * Note that AccurateMath is
 * extensively used inside Apache Commons Math, so by calling some algorithms,
 * the overhead when the tables need to be initialized will occur
 * regardless of the end-user calling AccurateMath methods directly or not.
 * Performance figures for a specific JVM and hardware can be evaluated by
 * running the AccurateMathTestPerformance tests in the test directory of the source
 * distribution.
 * </p>
 * <p>
 * AccurateMath accuracy should be mostly independent of the JVM as it relies only
 * on IEEE-754 basic operations and on embedded tables. Almost all operations
 * are accurate to about 0.5 ulp throughout the domain range. This statement,
 * of course is only a rough global observed behavior, it is <em>not</em> a
 * guarantee for <em>every</em> double numbers input (see William Kahan's <a
 * href="http://en.wikipedia.org/wiki/Rounding#The_table-maker.27s_dilemma">Table
 * Maker's Dilemma</a>).
 * </p>
 * <p>
 * AccurateMath additionally implements the following methods not found in Math/StrictMath:
 * <ul>
 * <li>{@link #asinh(double)}</li>
 * <li>{@link #acosh(double)}</li>
 * <li>{@link #atanh(double)}</li>
 * </ul>
 * The following methods are found in Math/StrictMath since 1.6 only, they are provided
 * by AccurateMath even in 1.5 Java virtual machines
 * <ul>
 * <li>{@link #copySign(double, double)}</li>
 * <li>{@link #getExponent(double)}</li>
 * <li>{@link #nextAfter(double,double)}</li>
 * <li>{@link #nextUp(double)}</li>
 * <li>{@link #scalb(double, int)}</li>
 * <li>{@link #copySign(float, float)}</li>
 * <li>{@link #getExponent(float)}</li>
 * <li>{@link #nextAfter(float,double)}</li>
 * <li>{@link #nextUp(float)}</li>
 * <li>{@link #scalb(float, int)}</li>
 * </ul>
 * @since 2.2
 */
public final class AccurateMath {

    private static final MathAPI api = MathProfile.getCurrentAPI();

    /** Archimede's constant PI, ratio of circle circumference to diameter. */
    public static final double PI = 105414357.0 / 33554432.0 + 1.984187159361080883e-9;

    /** Napier's constant e, base of the natural logarithm. */
    public static final double E = 2850325.0 / 1048576.0 + 8.254840070411028747e-8;


    public static double sqrt(final double a) {
        return api.sqrt(a);
    }


    public static double cosh(final double x) {
        return api.cosh(x);
    }


    public static double sinh(final double x) {
        return api.sinh(x);
    }


    public static double tanh(final double x) {
        return api.tanh(x);
    }


    public static double acosh(final double a) {
        return api.acosh(a);
    }


    public static double asinh(final double a) {
        return api.asinh(a);
    }


    public static double atanh(final double a) {
        return api.atanh(a);
    }


    public static double signum(final double a) {
        return api.signum(a);
    }


    public static float signum(final float a) {
        return api.signum(a);
    }


    public static double nextUp(final double a) {
        return api.nextUp(a);
    }


    public static float nextUp(final float a) {
        return api.nextUp(a);
    }


    public static double nextDown(final double a) {
        return api.nextDown(a);
    }


    public static float nextDown(final float a) {
        return api.nextDown(a);
    }


    public static double random() {
        return api.random();
    }


    public static double exp(final double x) {
        return api.exp(x);
    }


    public static double expm1(final double x) {
        return api.expm1(x);
    }


    public static double log(final double x) {
        return api.log(x);
    }


    public static double log1p(final double x) {
        return api.log1p(x);
    }


    public static double log10(final double x) {
        return api.log10(x);
    }


    public static double log(final double base, final double x) {
        return api.log(base, x);  //TODO: implement!
    }


    public static double pow(final double x, final double y) {
        return api.pow(x,y);  //TODO: implement!
    }


    public static double pow(final double d, final int e) {
        return api.pow(d,e);  //TODO: implement!
    }


    public static double pow(final double d, final long e) {
        return api.pow(d,e);  //TODO: implement!
    }


    public static double sin(final double x) {
        return api.sin(x);  //TODO: implement!
    }


    public static double cos(final double x) {
        return api.cos(x);  //TODO: implement!
    }


    public static double tan(final double x) {
        return api.tan(x);  //TODO: implement!
    }


    public static double atan(final double x) {
        return api.atan(x);  //TODO: implement!
    }


    public static double atan2(final double y, final double x) {
        return api.atan2(y,x);  //TODO: implement!
    }


    public static double asin(final double x) {
        return api.asin(x);  //TODO: implement!
    }


    public static double acos(final double x) {
        return api.acos(x);  //TODO: implement!
    }


    public static double cbrt(final double x) {
        return api.cbrt(x);  //TODO: implement!
    }


    public static double toRadians(final double x) {
        return api.toRadians(x);  //TODO: implement!
    }


    public static double toDegrees(final double x) {
        return api.toDegrees(x);  //TODO: implement!
    }


    public static int abs(final int x) {
        return api.abs(x);  //TODO: implement!
    }


    public static long abs(final long x) {
        return api.abs(x);
    }


    public static float abs(final float x) {
        return api.abs(x);
    }


    public static double abs(final double x) {
        return api.abs(x);
    }


    public static double ulp(final double x) {
        return api.ulp(x);  //TODO: implement!
    }


    public static float ulp(final float x) {
        return api.ulp(x);  //TODO: implement!
    }


    public static double scalb(final double d, final int n) {
        return api.scalb(d,n);  //TODO: implement!
    }


    public static float scalb(final float f, final int n) {
        return api.scalb(f,n);  //TODO: implement!
    }


    public static double nextAfter(final double d, final double direction) {
        return api.nextAfter(d, direction);  //TODO: implement!
    }


    public static float nextAfter(final float f, final double direction) {
        return api.nextAfter(f,direction);  //TODO: implement!
    }


    public static double floor(final double x) {
        return api.floor(x);  //TODO: implement!
    }


    public static double ceil(final double x) {
        return api.ceil(x);  //TODO: implement!
    }


    public static double rint(final double x) {
        return api.rint(x);  //TODO: implement!
    }


    public static long round(final double x) {
        return api.round(x);  //TODO: implement!
    }


    public static int round(final float x) {
        return api.round(x);  //TODO: implement!
    }


    public static int min(final int a, final int b) {
        return api.min(a,b);  //TODO: implement!
    }


    public static long min(final long a, final long b) {
        return api.min(a,b);  //TODO: implement!
    }


    public static float min(final float a, final float b) {
        return api.min(a,b);  //TODO: implement!
    }


    public static double min(final double a, final double b) {
        return api.min(a,b);  //TODO: implement!
    }


    public static int max(final int a, final int b) {
        return api.max(a,b);  //TODO: implement!
    }


    public static long max(final long a, final long b) {
        return api.max(a,b);  //TODO: implement!
    }


    public static float max(final float a, final float b) {
        return api.max(a,b);  //TODO: implement!
    }


    public static double max(final double a, final double b) {
        return api.max(a,b);  //TODO: implement!
    }


    public static double hypot(final double x, final double y) {
        return api.hypot(x,y);  //TODO: implement!
    }


    public static double IEEEremainder(final double dividend, final double divisor) {
        return api.IEEEremainder(dividend,divisor);  //TODO: implement!
    }


    public static int toIntExact(final long n) throws MathArithmeticException {
        return api.toIntExact(n);  //TODO: implement!
    }


    public static int incrementExact(final int n) throws MathArithmeticException {
        return api.incrementExact(n);  //TODO: implement!
    }


    public static long incrementExact(final long n) throws MathArithmeticException {
        return api.incrementExact(n);  //TODO: implement!
    }


    public static int decrementExact(final int n) throws MathArithmeticException {
        return api.decrementExact(n);  //TODO: implement!
    }


    public static long decrementExact(final long n) throws MathArithmeticException {
        return api.decrementExact(n);  //TODO: implement!
    }


    public static int addExact(final int a, final int b) throws MathArithmeticException {
        return api.addExact(a,b);  //TODO: implement!
    }


    public static long addExact(final long a, final long b) throws MathArithmeticException {
        return api.addExact(a,b);  //TODO: implement!
    }


    public static int subtractExact(final int a, final int b) {
        return api.subtractExact(a,b);  //TODO: implement!
    }


    public static long subtractExact(final long a, final long b) {
        return api.subtractExact(a,b);  //TODO: implement!
    }


    public static int multiplyExact(final int a, final int b) {
        return api.multiplyExact(a,b);  //TODO: implement!
    }


    public static long multiplyExact(final long a, final long b) {
        return api.multiplyExact(a,b);  //TODO: implement!
    }


    public static int floorDiv(final int a, final int b) throws MathArithmeticException {
        return api.floorDiv(a,b);  //TODO: implement!
    }


    public static long floorDiv(final long a, final long b) throws MathArithmeticException {
        return api.floorDiv(a,b);  //TODO: implement!
    }


    public static int floorMod(final int a, final int b) throws MathArithmeticException {
        return api.floorMod(a,b);  //TODO: implement!
    }


    public static long floorMod(final long a, final long b) {
        return api.floorMod(a,b);  //TODO: implement!
    }


    public static double copySign(final double magnitude, final double sign) {
        return api.copySign(magnitude, sign);  //TODO: implement!
    }


    public static float copySign(final float magnitude, final float sign) {
        return api.copySign(magnitude, sign);  //TODO: implement!
    }


    public static int getExponent(final double d) {
        return api.getExponent(d);  //TODO: implement!
    }


    public static int getExponent(final float f) {
        return api.getExponent(f);  //TODO: implement!
    }

}
