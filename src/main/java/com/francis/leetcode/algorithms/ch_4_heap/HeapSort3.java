package com.francis.leetcode.algorithms.ch_4_heap;

import com.francis.leetcode.algorithms.utils.Sort;
import com.francis.leetcode.algorithms.utils.Utils;
import org.junit.Test;

/**
 * 原地堆排序，不实用额外的空间
 * <p>
 * parent(i)= (i-1)/2
 * left child(i) = 2*i+1
 * right child(2) = 2*i+2
 * <p>
 * 最后一个非叶子节点的索引 (count-1)/2
 *
 * @author hzzhugequn@corp.netease.com
 */
public class HeapSort3 {

    @Sort
    public void sort(int[] arr) {
        int len = arr.length;
        for (int i = (len - 1 - 1) / 2; i >= 0; i--)
            shiftDown2(arr, len, i);
        for (int i = len - 1; i > 0; i--) {
            Utils.swap(arr, i, 0);
            shiftDown(arr, i, 0);
        }
    }

    private void shiftDown(int[] arr, int n, int k) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1] > arr[j])
                j++;
            if (arr[k] >= arr[j]) break;
            Utils.swap(arr, k, j);
            k = j;
        }
    }

    private void shiftDown2(int[] arr, int n, int k) {
        int v = arr[k];
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1] > arr[j])
                j++;
            if (v >= arr[j]) break;
            arr[k] = arr[j];
            k = j;
        }
        arr[k] = v;
    }

    @Test
    public void test() {
        int n = 1000000;
        int[] array = Utils.generateRandomArray(n, 0, n);
        Utils.testSort(HeapSort3.class, array);
    }
}
