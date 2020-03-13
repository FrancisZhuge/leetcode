package com.francis.leetcode.algorithms.ch_2_sorting_basic;

import com.francis.leetcode.algorithms.utils.Sort;
import com.francis.leetcode.algorithms.utils.Utils;
import org.junit.Test;

/**
 * 插入排序
 * <p>
 * 它的工作原理是通过构建有序序列，对于未排序数据，
 * 在已排序序列中从后向前扫描，找到相应位置并插入
 *
 * @author hzzhugequn@corp.netease.com
 */
public class InsertionSort {

    @Sort
    public void sort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int e = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1] > e; j--)
                arr[j] = arr[j - 1];
            arr[j] = e;
        }
    }

    @Test
    public void test() {
        int n = 100000;
        int[] arr1 = Utils.generateRandomArray(n, 0, 3);
        int[] arr2 = Utils.copyArray(arr1);
        Utils.testSort(InsertionSort.class, arr1);
        Utils.testSort(SelectionSort.class, arr2);


        int[] array1 = Utils.generateNearlyOrderedArray(n, 0);
        int[] array2 = Utils.copyArray(array1);
        Utils.testSort(InsertionSort.class, array1);
        Utils.testSort(SelectionSort.class, array2);
    }
}
