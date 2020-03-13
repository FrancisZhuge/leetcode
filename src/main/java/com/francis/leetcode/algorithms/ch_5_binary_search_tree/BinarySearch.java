package com.francis.leetcode.algorithms.ch_5_binary_search_tree;

import org.junit.Test;

/**
 * 二分查找
 * <p>
 * 二分查找算法（英语：binary search algorithm）
 * 也称折半搜索算法（英语：half-interval search algorithm）
 * 对数搜索算法（英语：logarithmic search algorithm）
 * <p>
 * 搜索过程从数组的中间元素开始，如果中间元素正好是要查找的元素，则搜索过程结束；
 * 如果某一特定元素大于或者小于中间元素，则在数组大于或小于中间元素的那一半中查找，而且跟开始一样从中间元素开始比较。
 * 如果在某一步骤数组为空，则代表找不到。这种搜索算法每一次比较都使搜索范围缩小一半。
 *
 * @author hzzhugequn@corp.netease.com
 */
public class BinarySearch {

    public int find(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    /**
     * 二分查找法, 在有序数组arr中, 查找target
     * 如果找到target, 返回第一个target相应的索引index
     * 如果没有找到target, 返回比target小的最大值相应的索引, 如果这个最大值有多个, 返回最大索引
     * 如果这个target比整个数组的最小元素值还要小, 则不存在这个target的floor值, 返回-1
     */
    public int floor(int[] arr, int target) {
        int l = -1;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (arr[mid] >= target)
                r = mid - 1;
            else
                l = mid;
        }
        assert l == r;
        if (l + 1 < arr.length && arr[l + 1] == target)
            return l + 1;
        return l;

    }

    /**
     * 二分查找法, 在有序数组arr中, 查找target
     * 如果找到target, 返回最后一个target相应的索引index
     * 如果没有找到target, 返回比target大的最小值相应的索引, 如果这个最小值有多个, 返回最小的索引
     * 如果这个target比整个数组的最大元素值还要大, 则不存在这个target的ceil值, 返回整个数组元素个数n
     */
    public int ceil(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }
        assert l == r;
        if (r - 1 >= 0 && arr[r - 1] == target)
            return r - 1;
        return r;
    }

    @Test
    public void test() {
        int[] arr = {1, 1, 1, 2, 2, 2, 2, 2, 4, 4, 5, 5, 5, 6, 6, 6};
        System.out.println(find(arr, 4));
        System.out.println(floor(arr, 4));
        System.out.println(ceil(arr, 4));
    }
}










































