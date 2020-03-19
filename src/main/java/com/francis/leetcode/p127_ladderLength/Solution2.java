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
public class Solution2 {

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

        Queue<Integer> beginQueue = new LinkedList<>();
        Queue<Integer> endQueue = new LinkedList<>();
        beginQueue.add(beginIndex);
        endQueue.add(endIndex);

        int[] beginStep = new int[n];
        int[] endStep = new int[n];
        beginStep[beginIndex] = 1;
        endStep[endIndex] = 1;

        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            Integer beginI = beginQueue.poll();
            for (int i = 0; i < n; i++)
                if (beginStep[i] == 0 && similar[i][beginI]) {
                    if (endStep[i] != 0) return beginStep[beginI] + endStep[i] ;
                    beginQueue.add(i);
                    beginStep[i] = beginStep[beginI] + 1;
                }
            Integer endI = endQueue.poll();
            for (int i = 0; i < n; i++)
                if (endStep[i] == 0 && similar[i][endI]) {
                    if (beginStep[i] != 0) return endStep[endI] + beginStep[i] ;
                    endQueue.add(i);
                    endStep[i] = endStep[endI] + 1;
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
