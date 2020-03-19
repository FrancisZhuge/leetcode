package com.francis.leetcode.p279_numSquares;

import javafx.util.Pair;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution3 {

    public int numSquares(int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(n, 0));
        visited[n] = true;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            Integer num = pair.getKey();
            Integer step = pair.getValue();
            for (int i = 1; ; i++) {
                int a = num - i * i;
                if (a < 0) break;
                if (a == 0) return step + 1;
                if (!visited[a]) {
                    queue.add(new Pair<>(a, step + 1));
                    visited[a] = true;
                }

            }
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(numSquares(7168));
    }
}
