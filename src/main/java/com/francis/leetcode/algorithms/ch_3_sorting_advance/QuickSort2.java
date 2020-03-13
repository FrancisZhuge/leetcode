package com.francis.leetcode.algorithms.ch_3_sorting_advance;

import com.francis.leetcode.algorithms.utils.Sort;
import com.francis.leetcode.algorithms.utils.Utils;
import org.junit.Test;

/**
 * 快速排序
 * <p>
 * 快速排序使用分治法（Divide and conquer）策略来把一个序列（list）分为较小和较大的2个子序列，
 * 然后递归地排序两个子序列。
 * 步骤为：
 * 挑选基准值：从数列中挑出一个元素，称为“基准”（pivot），
 * 分割：重新排序数列，所有比基准值小的元素摆放在基准前面，
 * 所有比基准值大的元素摆在基准后面（与基准值相等的数可以到任何一边）。
 * 在这个分割结束之后，对基准值的排序就已经完成，
 * 递归排序子序列：递归地将小于基准值元素的子序列和大于基准值元素的子序列排序。
 *
 * @author hzzhugequn@corp.netease.com
 */
public class QuickSort2 {

    @Sort
    public void sort(int[] arr) {
        int len = arr.length;
        sort(arr, 0, len - 1);
    }

    private void sort(int[] arr, int l, int r) {
        if (r - l <= 15) {
            Utils.insertSort(arr, l, r);
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private int partition(int[] arr, int l, int r) {
        Utils.swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        int v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                j++;
                Utils.swap(arr, j, i);
            }
        }
        Utils.swap(arr, l, j);
        return j;
    }

    @Test
    public void test() {
        int n = 100000;
        int[] array1 = Utils.generateNearlyOrderedArray(n, 50);
        int[] array2 = Utils.copyArray(array1);
        Utils.testSort(QuickSort.class, array1);
        Utils.testSort(QuickSort2.class, array2);
    }
}
