package com.francis.leetcode.algorithms.ch_3_sorting_advance;

import com.francis.leetcode.algorithms.utils.Sort;
import com.francis.leetcode.algorithms.utils.Utils;
import org.junit.Test;

import java.util.Arrays;

/**
 * 归并排序
 * <p>
 * 采用分治法:
 * <p>
 * 分割：递归地把当前序列平均分割成两半。
 * 集成：在保持元素顺序的同时将上一步得到的子序列集成到一起（归并）。
 *
 * @author hzzhugequn@corp.netease.com
 */
public class MergeSort {

    @Sort
    public void sort(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private void sort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
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
        int n = 10000;
        int[] array = Utils.generateRandomArray(n, 0, n);
        Utils.testSort(MergeSort.class, array);
    }
}
