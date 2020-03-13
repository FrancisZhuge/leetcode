package com.francis.leetcode.algorithms.ch_3_sorting_advance;

import com.francis.leetcode.algorithms.utils.Sort;
import com.francis.leetcode.algorithms.utils.Utils;
import org.junit.Test;

import java.util.Arrays;

/**
 * 自底向上的归并排序
 *
 * @author hzzhugequn@corp.netease.com
 */
public class MergeSortBU {

    @Sort
    public void sort(int[] arr) {
        int len = arr.length;
        for (int sz = 1; sz < len; sz *= 2) {
            for (int i = 0; i < len - sz; i += 2 * sz) {
                merge(arr, i, i + sz - 1, Math.min(len - 1, i + 2 * sz - 1));
            }
        }
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(arr, l, r + 1);
        int i = l;
        int j = mid + 1;
        int k = l;
        while (i <= mid && j <= r) {
            if (aux[i - l] < aux[j - l])
                arr[k++] = aux[i++ - l];
            else
                arr[k++] = aux[j++ - l];
        }
        while (i <= mid)
            arr[k++] = aux[i++ - l];
        while (j <= r)
            arr[k++] = aux[j++ - l];
    }

    @Test
    public void test() {
        int n = 100000;
        int[] array1 = Utils.generateRandomArray(n, 0, n);
        int[] array2 = Utils.copyArray(array1);
        Utils.testSort(MergeSortBU.class, array1);
        Utils.testSort(MergeSort.class, array2);
    }
}
