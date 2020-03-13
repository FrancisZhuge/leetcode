package com.francis.leetcode.algorithms.utils;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author hzzhugequn@corp.netease.com
 */
public class Utils {

    /**
     * 交换
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 随机生成 [rangeL, rangeR]
     */
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        return arr;
    }

    public static int[] generateNearlyOrderedArray(int n, int swapTimes) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i;
        for (int i = 0; i < swapTimes; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            swap(arr, a, b);
        }
        return arr;
    }

    /**
     * 当前是否已经有序
     */
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] > arr[i + 1])
                return false;
        return true;
    }

    /**
     * 输出数组
     */
    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 测试指定排序的执行时间
     */
    public static void testSort(Class tClass, int[] arr) {
        Method sortMethod = null;

        Method[] methods = tClass.getMethods();
        for (Method method : methods) {
            Sort sort = method.getAnnotation(Sort.class);
            if (sort != null) {
                sortMethod = method;
                break;
            }
        }
        if (sortMethod == null) {
            System.out.println("not find sort method");
            return;
        }
        sortMethod.setAccessible(true);
        try {
            Object instance = tClass.newInstance();
            long start = System.currentTimeMillis();
            sortMethod.invoke(instance, arr);
            long end = System.currentTimeMillis();
            assert isSorted(arr);
            System.out.println(tClass.getSimpleName() + " : " + (end - start) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertSort(int[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            int e = arr[i];
            int j = i;
            for (; j > l && arr[j - 1] > e; j--)
                arr[j] = arr[j - 1];
            arr[j] = e;
        }
    }

    public static int[] copyArray(int[] arr) {
        return Arrays.copyOfRange(arr, 0, arr.length);
    }
}
