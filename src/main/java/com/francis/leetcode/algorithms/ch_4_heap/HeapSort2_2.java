package com.francis.leetcode.algorithms.ch_4_heap;

import com.francis.leetcode.algorithms.utils.Sort;
import com.francis.leetcode.algorithms.utils.Utils;
import org.junit.Test;

/**
 * 堆排序
 *
 * @author hzzhugequn@corp.netease.com
 */
public class HeapSort2_2 {

    @Sort
    public void sort(int[] arr) {
        MaxHeap2 maxHeap = new MaxHeap2(arr);
        for (int i = arr.length - 1; i >= 0; i--)
            arr[i] = maxHeap.extractMax();
    }

    @Test
    public void test() {
        int n = 100000;
        int[] array = Utils.generateRandomArray(n, 0, n / 100);
        int[] array1 = Utils.copyArray(array);
        Utils.testSort(HeapSort.class, array);
        Utils.testSort(HeapSort2_2.class, array1);
    }
}
