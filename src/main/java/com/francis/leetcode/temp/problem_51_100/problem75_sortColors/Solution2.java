package com.francis.leetcode.problem_51_100.problem75_sortColors;

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
 * 38.5 MB
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Solution2 {

    public void sortColors(int[] nums) {
        if (nums == null) return;
        int n = nums.length;
        if (n == 0) return;
        int[] count = new int[3];
        for (int i = 0; i < n; i++)
            count[nums[i]]++;
        int k = 0;
        for (int i = 0; i < count[0]; i++)
            nums[k++] = 0;
        for (int i = 0; i < count[1]; i++)
            nums[k++] = 1;
        for (int i = 0; i < count[2]; i++)
            nums[k++] = 2;
    }


    @Test
    public void test() {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
