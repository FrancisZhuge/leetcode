package com.francis.leetcode.p16_threeSumClosest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int temp = nums[i] + nums[l] + nums[r];
                if (Math.abs(temp - target) < Math.abs(sum - target))
                    sum = temp;
                if (temp == target) return temp;
                else if (temp < target) l++;
                else r--;
            }
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
