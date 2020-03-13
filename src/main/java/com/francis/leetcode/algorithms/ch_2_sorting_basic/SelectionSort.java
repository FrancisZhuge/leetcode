package com.francis.leetcode.algorithms.ch_2_sorting_basic;

import com.francis.leetcode.algorithms.utils.Sort;
import com.francis.leetcode.algorithms.utils.Utils;
import org.junit.Test;

/**
 * 选择排序
 * <p>
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 *
 * @author hzzhugequn@corp.netease.com
 */
public class SelectionSort {

    @Sort
    public void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            Utils.swap(arr, minIndex, i);
        }
    }

    @Test
    public void test() {
        int n = 100000;
        int[] arr = Utils.generateRandomArray(n, 0, n);
        Utils.testSort(SelectionSort.class, arr);
    }
}
