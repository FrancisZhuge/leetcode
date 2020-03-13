package com.francis.leetcode.p202_isHappy;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1) {
            n = cal(n);
            if (record.contains(n)) return false;
            record.add(n);
        }
        return true;
    }

    private int cal(int n) {
        int res = 0;
        while (n > 0) {
            int v = n % 10;
            res += v * v;
            n = n / 10;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(isHappy(19));
    }
}
