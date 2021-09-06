package org.apache.commons.math4.legacy.core.provider;

import org.apache.commons.math4.legacy.exception.MathArithmeticException;

/**
 * @author <a href="mailto:erik.svensson@nasdaq.com">Erik Svensson</a>
 * Date: 2021-08-19
 * Time: 11:21
 */
public interface MathAPI {
    double sqrt(double a);

    double cosh(double x);

    double sinh(double x);

    double tanh(double x);

    double acosh(double a);

    double asinh(double a);

    double atanh(double a);

    double signum(double a);

    float signum(float a);

    double nextUp(double a);

    float nextUp(float a);

    double nextDown(double a);

    float nextDown(float a);

    double random();

    double exp(double x);

    double expm1(double x);

    double log(double x);

    double log1p(double x);

    double log10(double x);

    double log(double base, double x);

    double pow(double x, double y);

    double pow(double d, int e);

    double pow(double d, long e);

    double sin(double x);

    double cos(double x);

    double tan(double x);

    double atan(double x);

    double atan2(double y, double x);

    double asin(double x);

    double acos(double x);

    double cbrt(double x);

    double toRadians(double x);

    double toDegrees(double x);

    int abs(int x);

    long abs(long x);

    float abs(float x);

    double abs(double x);

    double ulp(double x);

    float ulp(float x);

    double scalb(double d, int n);

    float scalb(float f, int n);

    double nextAfter(double d, double direction);

    float nextAfter(float f, double direction);

    double floor(double x);

    double ceil(double x);

    double rint(double x);

    long round(double x);

    int round(float x);

    int min(int a, int b);

    long min(long a, long b);

    float min(float a, float b);

    double min(double a, double b);

    int max(int a, int b);

    long max(long a, long b);

    float max(float a, float b);

    double max(double a, double b);

    double hypot(double x, double y);

    double IEEEremainder(double dividend, double divisor);

    int toIntExact(long n) throws MathArithmeticException;

    int incrementExact(int n) throws MathArithmeticException;

    long incrementExact(long n) throws MathArithmeticException;

    int decrementExact(int n) throws MathArithmeticException;

    long decrementExact(long n) throws MathArithmeticException;

    int addExact(int a, int b) throws MathArithmeticException;

    long addExact(long a, long b) throws MathArithmeticException;

    int subtractExact(int a, int b);

    long subtractExact(long a, long b);

    int multiplyExact(int a, int b);

    long multiplyExact(long a, long b);

    int floorDiv(int a, int b) throws MathArithmeticException;

    long floorDiv(long a, long b) throws MathArithmeticException;

    int floorMod(int a, int b) throws MathArithmeticException;

    long floorMod(long a, long b);

    double copySign(double magnitude, double sign);

    float copySign(float magnitude, float sign);

    int getExponent(double d);

    int getExponent(float f);
}
