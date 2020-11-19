package com.ewan.thought.dc;

/**
 * Desc：题目50
 * <p>
 * 计算x的N次方
 *
 * @author ewan
 */
public class PowerX {

    public double quickMul(double x, long n) {

        if (n == 0) {
            return 1.0;
        }

        double y = quickMul(x, n / 2);

        return n % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);

    }


    public static void main(String[] args) {
        System.out.println(new PowerX().myPow(2,10));
    }
}
