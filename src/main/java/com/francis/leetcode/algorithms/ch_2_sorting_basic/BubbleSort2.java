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
public class BubbleSort2 {

    @Sort
    public void sort(int[] arr) {
        int len = arr.length;
        int newLen = 0;
        do {
            newLen = 0;
            for (int i = 1; i < len; i++) {
                if (arr[i - 1] > arr[i]) {
                    Utils.swap(arr, i - 1, i);
                    // 记录最后一次的交换位置,在此之后的元素在下一轮扫描中均不考虑
                    newLen = i;
                }
            }
            len = newLen;
        } while (newLen > 0);
    }

    @Test
    public void test() {
        int[] arr = Utils.generateRandomArray(1000, 0, 1000);
        Utils.testSort(BubbleSort2.class, arr);
    }
}
