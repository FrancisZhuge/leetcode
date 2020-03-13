package com.francis.leetcode.problem_51_100.problem80_removeDuplicates;

import org.junit.Test;

/**
 * 删除排序数组中的重复项 II
 * <p>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 给定 nums = [1,1,1,2,2,3],
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * time:O(n)
 * space:O(1)
 * <p>
 * 1 ms
 * 41.6 MB
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Solution1 {

    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        int n = nums.length;
        if (n <= 2) return n;
        int k = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[k]) {
                if (count < 2) {
                    count++;
                    nums[++k] = nums[i];
                }
            } else {
                count = 1;
                nums[++k] = nums[i];
            }
        }
        return k + 1;
    }

    @Test
    public void test() {
        int[] arr = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(arr));
    }
}
