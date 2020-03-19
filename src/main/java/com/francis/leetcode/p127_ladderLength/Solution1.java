package com.francis.leetcode.p127_ladderLength;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int endIndex = wordList.indexOf(endWord);
        if (endIndex == -1) return 0;

        if (!wordList.contains(beginWord)) wordList.add(beginWord);
        int beginIndex = wordList.indexOf(beginWord);

        int n = wordList.size();
        boolean[][] similar = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++)
                similar[i][j] = similar[j][i] = similar(wordList.get(i), wordList.get(j));

        Queue<Integer> queue = new LinkedList<>();
        queue.add(beginIndex);

        int[] step = new int[n];
        step[beginIndex] = 1;

        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            for (int i = 0; i < n; i++)
                if (step[i] == 0 && similar[i][index]) {
                    if (i == endIndex) return step[index] + 1;
                    queue.add(i);
                    step[i] = step[index] + 1;
                }
        }
        return 0;
    }


    private boolean similar(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) count++;
            if (count > 1) return false;
        }
        return true;
    }

    @Test
    public void test() {
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ladderLength("hit", "cog", wordList));

        wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println(ladderLength("hit", "cog", wordList));

    }
}
