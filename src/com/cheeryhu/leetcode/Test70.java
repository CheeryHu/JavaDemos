package com.cheeryhu.leetcode;

public class Test70 {

    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int p = 1, q = 2, sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = p + q;
            p = q;
            q = sum;
        }
        return sum;
    }
}
