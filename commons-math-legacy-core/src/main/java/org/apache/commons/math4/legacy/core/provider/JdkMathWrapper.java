package org.apache.commons.math4.legacy.core.provider;

import org.apache.commons.math4.legacy.core.jdkmath.AccurateMath;
import org.apache.commons.math4.legacy.core.jdkmath.AccurateMathImpl;
import org.apache.commons.math4.legacy.exception.MathArithmeticException;
import org.apache.commons.math4.legacy.exception.util.LocalizedFormats;

import java.lang.Math;
/**
 * @author <a href="mailto:erik.svensson@nasdaq.com">Erik Svensson</a>
 * Date: 2021-08-19
 * Time: 15:09
 */
public class JdkMathWrapper implements MathAPI{
    @Override
    public double sqrt(final double a) {
        return Math.sqrt(a);
    }

    @Override
    public double cosh(final double x) {
        return Math.cosh(x);
    }

    @Override
    public double sinh(final double x) {
        return Math.sinh(x);  //TODO: implement!
    }

    @Override
    public double tanh(final double x) {
        return Math.tanh(x);  //TODO: implement!
    }

    @Override
    public double acosh(final double a) {
        return AccurateMathImpl.acosh(a);  //TODO: implement!
    }

    @Override
    public double asinh(final double a) {
        return AccurateMathImpl.asinh(a);  //TODO: implement!
    }

    @Override
    public double atanh(final double a) {
        return AccurateMathImpl.atanh(a);  //TODO: implement!
    }

    @Override
    public double signum(final double a) {
        return Math.signum(a);  //TODO: implement!
    }

    @Override
    public float signum(final float a) {
        return Math.signum(a);  //TODO: implement!
    }

    @Override
    public double nextUp(final double a) {
        return Math.nextUp(a);  //TODO: implement!
    }

    @Override
    public float nextUp(final float a) {
        return Math.nextUp(a);
    }

    @Override
    public double nextDown(final double a) {
        return Math.nextDown(a);
    }

    @Override
    public float nextDown(final float a) {
        return Math.nextDown(a);
    }

    @Override
    public double random() {
        return Math.random();
    }

    @Override
    public double exp(final double x) {
        return Math.exp(x);  //TODO: implement!
    }

    @Override
    public double expm1(final double x) {
        return Math.expm1(x);
    }

    @Override
    public double log(final double x) {
        return Math.log(x);  //TODO: implement!
    }

    @Override
    public double log1p(final double x) {
        return Math.log1p(x);  //TODO: implement!
    }

    @Override
    public double log10(final double x) {
        return Math.log10(x);  //TODO: implement!
    }

    @Override
    public double log(final double base, final double x) {
        return AccurateMathImpl.log(base,x);
    }

    @Override
    public double pow(final double x, final double y) {
        return Math.pow(x,y);
    }

    /**
     * java.lang.Math does not have this operation, instead the exponent is cast to a double.
     * The performance penalty for that, as opposed to using AccurateMath.pow(double, int) should perhaps be investigated.
     * @param d double
     * @param e int
     * @return
     */
    @Override
    public double pow(final double d, final int e) {
        return Math.pow(d,e);  //TODO: implement!
    }

    /**
     * The performance comment from pow(double, int) applies here as well.
     * @param d double
     * @param e long
     * @return double
     */
    @Override
    public double pow(final double d, final long e) {
        return Math.pow(d,e);  //TODO: implement!
    }

    @Override
    public double sin(final double x) {
        return Math.sin(x);
    }

    @Override
    public double cos(final double x) {
        return Math.cos(x);
    }

    @Override
    public double tan(final double x) {
        return Math.tan(x);
    }

    @Override
    public double atan(final double x) {
        return Math.atan(x);
    }

    @Override
    public double atan2(final double y, final double x) {
        return Math.atan2(y,x);
    }

    @Override
    public double asin(final double x) {
        return Math.asin(x);
    }

    @Override
    public double acos(final double x) {
        return Math.acos(x);  //TODO: implement!
    }

    @Override
    public double cbrt(final double x) {
        return Math.cbrt(x);  //TODO: implement!
    }

    @Override
    public double toRadians(final double x) {
        return Math.toRadians(x);  //TODO: implement!
    }

    @Override
    public double toDegrees(final double x) {
        return Math.toDegrees(x);  //TODO: implement!
    }

    @Override
    public int abs(final int x) {
        return Math.abs(x);  //TODO: implement!
    }

    @Override
    public long abs(final long x) {
        return Math.abs(x);  //TODO: implement!
    }

    @Override
    public float abs(final float x) {
        return Math.abs(x);  //TODO: implement!
    }

    @Override
    public double abs(final double x) {
        return Math.abs(x);  //TODO: implement!
    }

    @Override
    public double ulp(final double x) {
        return Math.ulp(x);  //TODO: implement!
    }

    @Override
    public float ulp(final float x) {
        return Math.ulp(x);  //TODO: implement!
    }

    @Override
    public double scalb(final double d, final int n) {
        return Math.scalb(d,n);  //TODO: implement!
    }

    @Override
    public float scalb(final float f, final int n) {
        return Math.scalb(f,n);  //TODO: implement!
    }

    @Override
    public double nextAfter(final double d, final double direction) {
        return Math.nextAfter(d,direction);  //TODO: implement!
    }

    @Override
    public float nextAfter(final float f, final double direction) {
        return Math.nextAfter(f,direction);  //TODO: implement!
    }

    @Override
    public double floor(final double x) {
        return Math.floor(x);  //TODO: implement!
    }

    @Override
    public double ceil(final double x) {
        return Math.ceil(x);  //TODO: implement!
    }

    @Override
    public double rint(final double x) {
        return Math.rint(x);  //TODO: implement!
    }

    @Override
    public long round(final double x) {
        return Math.round(x);  //TODO: implement!
    }

    @Override
    public int round(final float x) {
        return Math.round(x);  //TODO: implement!
    }

    @Override
    public int min(final int a, final int b) {
        return Math.min(a,b);  //TODO: implement!
    }

    @Override
    public long min(final long a, final long b) {
        return Math.min(a,b);  //TODO: implement!
    }

    @Override
    public float min(final float a, final float b) {
        return Math.min(a, b);  //TODO: implement!
    }

    @Override
    public double min(final double a, final double b) {
        return Math.min(a,b);  //TODO: implement!
    }

    @Override
    public int max(final int a, final int b) {
        return Math.max(a,b);  //TODO: implement!
    }

    @Override
    public long max(final long a, final long b) {
        return Math.max(a,b);  //TODO: implement!
    }

    @Override
    public float max(final float a, final float b) {
        return Math.max(a,b);  //TODO: implement!
    }

    @Override
    public double max(final double a, final double b) {
        return Math.max(a,b);  //TODO: implement!
    }

    @Override
    public double hypot(final double x, final double y) {
        return Math.hypot(x,y);  //TODO: implement!
    }

    @Override
    public double IEEEremainder(final double dividend, final double divisor) {
        return Math.IEEEremainder(dividend,divisor);  //TODO: implement!
    }

    @Override
    public int toIntExact(final long n) throws MathArithmeticException {
        try {
            return Math.toIntExact(n);  //TODO: implement!
        } catch (ArithmeticException ae) {
            throw new MathArithmeticException(LocalizedFormats.OVERFLOW);
        }
    }

    @Override
    public int incrementExact(final int n) throws MathArithmeticException {
        try {
            return Math.incrementExact(n);  //TODO: implement!
        } catch (ArithmeticException ae) {
            throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_ADDITION, n, 1);
        }
    }

    @Override
    public long incrementExact(final long n) throws MathArithmeticException {
        try {
            return Math.incrementExact(n);  //TODO: implement!
        } catch (ArithmeticException ae) {
            throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_ADDITION, n, 1);
        }
    }

    @Override
    public int decrementExact(final int n) throws MathArithmeticException {
        try {
            return Math.decrementExact(n);  //TODO: implement!
        } catch (ArithmeticException ae) {
            throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_SUBTRACTION, n, 1);
        }
    }

    @Override
    public long decrementExact(final long n) throws MathArithmeticException {
        try {
            return Math.decrementExact(n);  //TODO: implement!
        } catch (ArithmeticException ae) {
            throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_SUBTRACTION, n, 1);
        }
    }

    @Override
    public int addExact(final int a, final int b) throws MathArithmeticException {
        try {
            return Math.addExact(a, b);  //TODO: implement!
        } catch (ArithmeticException ae) {
            throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_ADDITION, a, b);
        }
    }

    @Override
    public long addExact(final long a, final long b) throws MathArithmeticException {
        try {
            return Math.addExact(a, b);  //TODO: implement!
        } catch (ArithmeticException ae) {
            throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_ADDITION, a, b);
        }
    }

    @Override
    public int subtractExact(final int a, final int b) {
        try {
            return Math.subtractExact(a, b);  //TODO: implement!
        } catch (ArithmeticException ae) {
            throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_SUBTRACTION, a, b);
        }
    }

    @Override
    public long subtractExact(final long a, final long b) {
        try {
            return Math.subtractExact(a, b);  //TODO: implement!
        } catch (ArithmeticException ae) {
            throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_SUBTRACTION, a, b);
        }
    }

    @Override
    public int multiplyExact(final int a, final int b) {
        try {
            return Math.multiplyExact(a,b);  //TODO: implement!
        } catch (ArithmeticException ae) {
            throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_MULTIPLICATION, a, b);
        }
    }

    @Override
    public long multiplyExact(final long a, final long b) {
        try {
            return Math.multiplyExact(a,b);  //TODO: implement!
        } catch (ArithmeticException ae) {
            throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_MULTIPLICATION, a, b);
        }
    }

    @Override
    public int floorDiv(final int a, final int b) throws MathArithmeticException {
        try {
            return Math.floorDiv(a,b);  //TODO: implement!
        } catch (ArithmeticException ae) {
            throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR);
        }
    }

    @Override
    public long floorDiv(final long a, final long b) throws MathArithmeticException {
        try {
            return Math.floorDiv(a,b);  //TODO: implement!
        } catch (ArithmeticException ae) {
            throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR);
        }
    }

    @Override
    public int floorMod(final int a, final int b) throws MathArithmeticException {
        try {
            return Math.floorMod(a,b);  //TODO: implement!
        } catch (ArithmeticException ae) {
            throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR);
        }
    }

    @Override
    public long floorMod(final long a, final long b) {
        try {
            return Math.floorMod(a,b);  //TODO: implement!
        } catch (ArithmeticException ae) {
            throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR);
        }
    }

    @Override
    public double copySign(final double magnitude, final double sign) {
        return Math.copySign(magnitude, sign);  //TODO: implement!
    }

    @Override
    public float copySign(final float magnitude, final float sign) {
        return Math.copySign(magnitude, sign);  //TODO: implement!
    }

    @Override
    public int getExponent(final double d) {
        return Math.getExponent(d);  //TODO: implement!
    }

    @Override
    public int getExponent(final float f) {
        return Math.getExponent(f);  //TODO: implement!
    }
}
