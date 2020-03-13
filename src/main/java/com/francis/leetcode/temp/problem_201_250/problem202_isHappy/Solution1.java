package com.francis.leetcode.problem_201_250.problem202_isHappy;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 * <p>
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * 2ms
 * 37.1MB
 *
 * @author zhugequn
 */
public class Solution1 {

    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1) {
            n = op(n);
            if (record.contains(n))
                return false;
            else
                record.add(n);
        }
        return true;
    }

    private int op(int n) {
        int ans = 0;
        while (n > 0) {
            int v = n % 10;
            ans += v * v;
            n = n / 10;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(isHappy(19));
    }
}
