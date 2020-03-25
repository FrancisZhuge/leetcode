package com.francis.leetcode.p416_canPartition;

import com.francis.leetcode.utils.Utils;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;
        sum /= 2;
        int n = nums.length;
        boolean[][] record = new boolean[n][sum + 1];

        for (int i = 0; i < sum + 1; i++)
            if (i == nums[0]) record[0][i] = true;
        for (int i = 0; i < n; i++)
            record[i][0] = true;
        for (int i = 1; i < n; i++)
            for (int j = 0; j < sum + 1; j++)
                if (j - nums[i] >= 0)
                    record[i][j] = record[i - 1][j] || record[i - 1][j - nums[i]];
                else record[i][j] = record[i - 1][j];
        return record[n - 1][sum];
    }

    @Test
    public void test() {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(canPartition(new int[]{1, 2, 5}));
    }
}
