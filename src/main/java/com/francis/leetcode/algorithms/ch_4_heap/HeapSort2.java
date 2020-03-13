package com.francis.leetcode.algorithms.ch_4_heap;

import com.francis.leetcode.algorithms.utils.Sort;
import com.francis.leetcode.algorithms.utils.Utils;
import org.junit.Test;

/**
 * 堆排序
 *
 * @author hzzhugequn@corp.netease.com
 */
public class HeapSort2 {

    @Sort
    public void sort(int[] arr) {
        MaxHeap maxHeap = new MaxHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--)
            arr[i] = maxHeap.extractMax();
    }

    @Test
    public void test() {
        int n = 1000000;
        int[] array = Utils.generateRandomArray(n, 0, n / 100);
        int[] array1 = Utils.copyArray(array);
        int[] array2 = Utils.copyArray(array1);
        int[] array3 = Utils.copyArray(array2);
        Utils.testSort(HeapSort.class, array);
        Utils.testSort(HeapSort_2.class, array1);
        Utils.testSort(HeapSort2.class, array2);
        Utils.testSort(HeapSort2_2.class, array3);
    }
}
