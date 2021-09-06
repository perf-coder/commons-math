package org.apache.commons.math4.legacy.core.provider;

import org.apache.commons.math4.legacy.core.jdkmath.AccurateMathImpl;
import org.apache.commons.math4.legacy.exception.MathArithmeticException;

/**
 * @author <a href="mailto:erik.svensson@nasdaq.com">Erik Svensson</a>
 * Date: 2021-08-19
 * Time: 14:58
 */
public class AccurateMathImplWrapper implements MathAPI {

    @Override
    public double sqrt(final double a) {
        return AccurateMathImpl.sqrt(a);
    }

    @Override
    public double cosh(final double x) {
        return AccurateMathImpl.cosh(x);
    }

    @Override
    public double sinh(final double x) {
        return AccurateMathImpl.sinh(x);
    }

    @Override
    public double tanh(final double x) {
        return AccurateMathImpl.tanh(x);
    }

    @Override
    public double acosh(final double a) {
        return AccurateMathImpl.acosh(a);
    }

    @Override
    public double asinh(final double a) {
        return AccurateMathImpl.asinh(a);
    }

    @Override
    public double atanh(final double a) {
        return AccurateMathImpl.atanh(a);
    }

    @Override
    public double signum(final double a) {
        return AccurateMathImpl.signum(a);
    }

    @Override
    public float signum(final float a) {
        return AccurateMathImpl.signum(a);
    }

    @Override
    public double nextUp(final double a) {
        return AccurateMathImpl.nextUp(a);
    }

    @Override
    public float nextUp(final float a) {
        return AccurateMathImpl.nextUp(a);
    }

    @Override
    public double nextDown(final double a) {
        return AccurateMathImpl.nextDown(a);
    }

    @Override
    public float nextDown(final float a) {
        return AccurateMathImpl.nextDown(a);
    }

    @Override
    public double random() {
        return AccurateMathImpl.random();
    }

    @Override
    public double exp(final double x) {
        return AccurateMathImpl.exp(x);
    }

    @Override
    public double expm1(final double x) {
        return AccurateMathImpl.expm1(x);
    }

    @Override
    public double log(final double x) {
        return AccurateMathImpl.log(x);
    }

    @Override
    public double log1p(final double x) {
        return AccurateMathImpl.log1p(x);
    }

    @Override
    public double log10(final double x) {
        return AccurateMathImpl.log10(x);
    }

    @Override
    public double log(final double base, final double x) {
        return AccurateMathImpl.log(base, x);  //TODO: implement!
    }

    @Override
    public double pow(final double x, final double y) {
        return AccurateMathImpl.pow(x,y);  //TODO: implement!
    }

    @Override
    public double pow(final double d, final int e) {
        return AccurateMathImpl.pow(d,e);  //TODO: implement!
    }

    @Override
    public double pow(final double d, final long e) {
        return AccurateMathImpl.pow(d,e);  //TODO: implement!
    }

    @Override
    public double sin(final double x) {
        return AccurateMathImpl.sin(x);  //TODO: implement!
    }

    @Override
    public double cos(final double x) {
        return AccurateMathImpl.cos(x);  //TODO: implement!
    }

    @Override
    public double tan(final double x) {
        return AccurateMathImpl.tan(x);  //TODO: implement!
    }

    @Override
    public double atan(final double x) {
        return AccurateMathImpl.atan(x);  //TODO: implement!
    }

    @Override
    public double atan2(final double y, final double x) {
        return AccurateMathImpl.atan2(y,x);  //TODO: implement!
    }

    @Override
    public double asin(final double x) {
        return AccurateMathImpl.asin(x);  //TODO: implement!
    }

    @Override
    public double acos(final double x) {
        return AccurateMathImpl.acos(x);  //TODO: implement!
    }

    @Override
    public double cbrt(final double x) {
        return AccurateMathImpl.cbrt(x);  //TODO: implement!
    }

    @Override
    public double toRadians(final double x) {
        return AccurateMathImpl.toRadians(x);  //TODO: implement!
    }

    @Override
    public double toDegrees(final double x) {
        return AccurateMathImpl.toDegrees(x);  //TODO: implement!
    }

    @Override
    public int abs(final int x) {
        return AccurateMathImpl.abs(x);  //TODO: implement!
    }

    @Override
    public long abs(final long x) {
        return AccurateMathImpl.abs(x);
    }

    @Override
    public float abs(final float x) {
        return AccurateMathImpl.abs(x);
    }

    @Override
    public double abs(final double x) {
        return AccurateMathImpl.abs(x);
    }

    @Override
    public double ulp(final double x) {
        return AccurateMathImpl.ulp(x);  //TODO: implement!
    }

    @Override
    public float ulp(final float x) {
        return AccurateMathImpl.ulp(x);  //TODO: implement!
    }

    @Override
    public double scalb(final double d, final int n) {
        return AccurateMathImpl.scalb(d,n);  //TODO: implement!
    }

    @Override
    public float scalb(final float f, final int n) {
        return AccurateMathImpl.scalb(f,n);  //TODO: implement!
    }

    @Override
    public double nextAfter(final double d, final double direction) {
        return AccurateMathImpl.nextAfter(d, direction);  //TODO: implement!
    }

    @Override
    public float nextAfter(final float f, final double direction) {
        return AccurateMathImpl.nextAfter(f,direction);  //TODO: implement!
    }

    @Override
    public double floor(final double x) {
        return AccurateMathImpl.floor(x);  //TODO: implement!
    }

    @Override
    public double ceil(final double x) {
        return AccurateMathImpl.ceil(x);  //TODO: implement!
    }

    @Override
    public double rint(final double x) {
        return AccurateMathImpl.rint(x);  //TODO: implement!
    }

    @Override
    public long round(final double x) {
        return AccurateMathImpl.round(x);  //TODO: implement!
    }

    @Override
    public int round(final float x) {
        return AccurateMathImpl.round(x);  //TODO: implement!
    }

    @Override
    public int min(final int a, final int b) {
        return AccurateMathImpl.min(a,b);  //TODO: implement!
    }

    @Override
    public long min(final long a, final long b) {
        return AccurateMathImpl.min(a,b);  //TODO: implement!
    }

    @Override
    public float min(final float a, final float b) {
        return AccurateMathImpl.min(a,b);  //TODO: implement!
    }

    @Override
    public double min(final double a, final double b) {
        return AccurateMathImpl.min(a,b);  //TODO: implement!
    }

    @Override
    public int max(final int a, final int b) {
        return AccurateMathImpl.max(a,b);  //TODO: implement!
    }

    @Override
    public long max(final long a, final long b) {
        return AccurateMathImpl.max(a,b);  //TODO: implement!
    }

    @Override
    public float max(final float a, final float b) {
        return AccurateMathImpl.max(a,b);  //TODO: implement!
    }

    @Override
    public double max(final double a, final double b) {
        return AccurateMathImpl.max(a,b);  //TODO: implement!
    }

    @Override
    public double hypot(final double x, final double y) {
        return AccurateMathImpl.hypot(x,y);  //TODO: implement!
    }

    @Override
    public double IEEEremainder(final double dividend, final double divisor) {
        return AccurateMathImpl.IEEEremainder(dividend,divisor);  //TODO: implement!
    }

    @Override
    public int toIntExact(final long n) throws MathArithmeticException {
        return AccurateMathImpl.toIntExact(n);  //TODO: implement!
    }

    @Override
    public int incrementExact(final int n) throws MathArithmeticException {
        return AccurateMathImpl.incrementExact(n);  //TODO: implement!
    }

    @Override
    public long incrementExact(final long n) throws MathArithmeticException {
        return AccurateMathImpl.incrementExact(n);  //TODO: implement!
    }

    @Override
    public int decrementExact(final int n) throws MathArithmeticException {
        return AccurateMathImpl.decrementExact(n);  //TODO: implement!
    }

    @Override
    public long decrementExact(final long n) throws MathArithmeticException {
        return AccurateMathImpl.decrementExact(n);  //TODO: implement!
    }

    @Override
    public int addExact(final int a, final int b) throws MathArithmeticException {
        return AccurateMathImpl.addExact(a,b);  //TODO: implement!
    }

    @Override
    public long addExact(final long a, final long b) throws MathArithmeticException {
        return AccurateMathImpl.addExact(a,b);  //TODO: implement!
    }

    @Override
    public int subtractExact(final int a, final int b) {
        return AccurateMathImpl.subtractExact(a,b);  //TODO: implement!
    }

    @Override
    public long subtractExact(final long a, final long b) {
        return AccurateMathImpl.subtractExact(a,b);  //TODO: implement!
    }

    @Override
    public int multiplyExact(final int a, final int b) {
        return AccurateMathImpl.multiplyExact(a,b);  //TODO: implement!
    }

    @Override
    public long multiplyExact(final long a, final long b) {
        return AccurateMathImpl.multiplyExact(a,b);  //TODO: implement!
    }

    @Override
    public int floorDiv(final int a, final int b) throws MathArithmeticException {
        return AccurateMathImpl.floorDiv(a,b);  //TODO: implement!
    }

    @Override
    public long floorDiv(final long a, final long b) throws MathArithmeticException {
        return AccurateMathImpl.floorDiv(a,b);  //TODO: implement!
    }

    @Override
    public int floorMod(final int a, final int b) throws MathArithmeticException {
        return AccurateMathImpl.floorMod(a,b);  //TODO: implement!
    }

    @Override
    public long floorMod(final long a, final long b) {
        return AccurateMathImpl.floorMod(a,b);  //TODO: implement!
    }

    @Override
    public double copySign(final double magnitude, final double sign) {
        return AccurateMathImpl.copySign(magnitude, sign);  //TODO: implement!
    }

    @Override
    public float copySign(final float magnitude, final float sign) {
        return AccurateMathImpl.copySign(magnitude, sign);  //TODO: implement!
    }

    @Override
    public int getExponent(final double d) {
        return AccurateMathImpl.getExponent(d);  //TODO: implement!
    }

    @Override
    public int getExponent(final float f) {
        return AccurateMathImpl.getExponent(f);  //TODO: implement!
    }
}
