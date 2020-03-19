package com.francis.leetcode.p279_numSquares;

import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution2 {

    public int numSquares(int n) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(n, 0));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            Integer num = pair.getKey();
            Integer step = pair.getValue();
            if (num == 0) return step;
            for (int i = 1; num - i * i >= 0; i++)
                queue.add(new Pair<>(num - i * i, step + 1));
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(numSquares(7168));
    }
}
