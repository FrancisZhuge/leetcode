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
public class BinarySearch2 {

    public int find(int[] arr, int target) {
        return find(arr, 0, arr.length - 1, target);
    }

    private int find(int[] arr, int l, int r, int target) {
        if (l > r) return -1;
        int mid = (r - l) / 2 + l;
        if (target == arr[mid]) return mid;
        else if (target > arr[mid]) return find(arr, mid + 1, r, target);
        else return find(arr, l, mid - 1, target);
    }

    @Test
    public void test() {
        int n = 100000;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        for (int i = 0; i < 2 * n; i++) {
            int v = find(arr, i);
            if (i < n) assert v == i;
            else assert v == -1;
        }
    }
}
