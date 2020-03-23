package com.francis.leetcode.p401_readBinaryWatch;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        dfs(num, 0, 0, 0, 0, ans);
        return ans;
    }


    private void dfs(int num, int index, int hour, int min, int count, List<String> ans) {
        if (count == num) {
            ans.add(hour + ":" + String.format("%02d", min));
            return;
        }
        for (int i = index; i < 10; i++) {
            if (i < 6) {
                min |= (1 << i);
                if (min <= 59)
                    dfs(num, i + 1, hour, min, count + 1, ans);
                min &= ~(1 << i);
            } else {
                hour |= (1 << (i - 6));
                if (hour <= 11)
                    dfs(num, i + 1, hour, min, count + 1, ans);
                hour &= ~(1 << (i - 6));
            }
        }
    }


    @Test
    public void test() {
        System.out.println(readBinaryWatch(2));
    }
}
