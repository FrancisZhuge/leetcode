package com.francis.leetcode.algorithms.ch_2_sorting_basic;

import com.francis.leetcode.algorithms.utils.Sort;
import com.francis.leetcode.algorithms.utils.Utils;
import org.junit.Test;

/**
 * shell排序
 * <p>
 * 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率
 * 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位
 *
 * @author hzzhugequn@corp.netease.com
 */
public class ShellSort {

    @Sort
    public void sort(int[] arr) {
        int len = arr.length;
        int h = 1;
        while (h < len / 3) h = h * 3 + 1;

        while (h >= 1) {
            for (int i = h; i < len; i++) {
                int e = arr[i];
                int j = i;
                for (; j >= h && arr[j - h] > e; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = e;
            }
            h = h / 3;
        }
    }

    @Test
    public void test() {
        int[] array = Utils.generateRandomArray(1000, 0, 1000);
        Utils.testSort(ShellSort.class, array);
    }
}
