package com.francis.leetcode.temp.problem_51_100.problem75_sortColors;

import org.junit.Test;

import java.util.Arrays;

/**
 * 颜色分类
 * <p>
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * <p>
 * time:O(n)
 * space:O(1)
 * <p>
 * 0 ms
 * 37.9 MB
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Solution1 {

    public void sortColors(int[] nums) {
        if (nums == null) return;
        int n = nums.length;
        if (n == 0) return;

        int l = -1;
        int r = n;
        int i = 0;
        while (i < r) {
            if (nums[i] == 0) {
                l++;
                swap(nums, i, l);
                i++;
            } else if (nums[i] == 2) {
                r--;
                swap(nums, i, r);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test() {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
