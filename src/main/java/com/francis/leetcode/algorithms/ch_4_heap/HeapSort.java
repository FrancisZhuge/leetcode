package com.francis.leetcode.algorithms.ch_4_heap;

import com.francis.leetcode.algorithms.utils.Sort;
import com.francis.leetcode.algorithms.utils.Utils;
import org.junit.Test;

/**
 * 堆排序

 * @author hzzhugequn@corp.netease.com
 */
public class HeapSort {

    @Sort
    public void sort(int[] arr) {
        int len = arr.length;
        MaxHeap maxHeap = new MaxHeap(len);
        for (int i = 0; i < len; i++)
            maxHeap.insert(arr[i]);
        for (int i = len - 1; i >= 0; i--)
            arr[i] = maxHeap.extractMax();
    }

    @Test
    public void test() {
        int n = 100000;
        int[] array = Utils.generateRandomArray(n, 0, n / 100);
        Utils.testSort(HeapSort.class, array);
    }
}
