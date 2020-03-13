package com.francis.leetcode.algorithms.ch_2_sorting_basic;

import com.francis.leetcode.algorithms.utils.Sort;
import com.francis.leetcode.algorithms.utils.Utils;
import org.junit.Test;

/**
 * 冒泡排序
 * <p>
 * 它重复地走访过要排序的数列，一次比较两个元素，
 * 如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，
 * 也就是说该数列已经排序完成。
 *
 * @author hzzhugequn@corp.netease.com
 */
public class BubbleSort {

    @Sort
    public void sort(int[] arr) {
        int len = arr.length;
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 1; i < len; i++) {
                if (arr[i - 1] > arr[i]) {
                    Utils.swap(arr, i - 1, i);
                    swapped = true;
                }
            }
            // 优化, 每一趟Bubble Sort都将最大的元素放在了最后的位置
            // 所以下一次排序, 最后的元素可以不再考虑
            len--;
        } while (swapped);
    }

    @Test
    public void test() {
        int[] arr = Utils.generateRandomArray(1000, 0, 1000);
        Utils.testSort(BubbleSort.class, arr);
    }
}
