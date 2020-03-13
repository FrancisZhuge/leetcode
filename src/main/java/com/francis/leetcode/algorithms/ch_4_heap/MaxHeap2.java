package com.francis.leetcode.algorithms.ch_4_heap;

/**
 * 堆
 * <p>
 * 二叉堆（英语：binary heap）是一种特殊的堆，
 * 二叉堆是完全二叉树或者是近似完全二叉树。
 * 二叉堆满足堆特性：父节点的键值总是保持固定的序关系于任何一个子节点的键值，
 * 且每个节点的左子树和右子树都是一个二叉堆。
 * <p>
 * 当父节点的键值总是大于或等于任何一个子节点的键值时为“最大堆”。
 * 当父节点的键值总是小于或等于任何一个子节点的键值时为“最小堆”。
 * ----------------62:1
 * --------41:2           30:3
 * ---28:4       16:5  22:6  13:7
 * -19:8 17:9  15:10
 * <p>
 * | 0 |  1 | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  | 10
 * | - | 62 | 41 | 30 | 28 | 16 | 22 | 13 | 19 | 17 | 15
 * <p>
 * parent(i)= i/2
 * left child(i) = 2*i
 * right child(2) = 2*i+1
 * <p>
 * 1. insert core operate shift up
 *
 * @author hzzhugequn@corp.netease.com
 */
public class MaxHeap2 {

    /**
     * 数据
     */
    private int[] data;

    /**
     * 堆中大小
     */
    private int count;

    /**
     * 堆容量
     */
    private int capacity;

    /**
     * 构造函数
     */
    public MaxHeap2(int capacity) {
        data = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    // 构造函数, 通过一个给定数组创建一个最大堆
    // 该构造堆的过程, 时间复杂度为O(n)
    public MaxHeap2(int arr[]) {
        int n = arr.length;
        data = new int[n + 1];
        capacity = n;
        for (int i = 0; i < n; i++)
            data[i + 1] = arr[i];
        count = n;
        // 叶子节点天然是最大堆
        for (int i = count / 2; i >= 1; i--)
            shiftDown(i);
    }

    /**
     * 堆中大小
     */
    public int size() {
        return count;
    }

    /**
     * 堆是否为空
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 新增
     */
    public void insert(int item) {
        assert count + 1 <= capacity;
        data[++count] = item;
        shiftUp(count);
    }

    public int extractMax() {
        assert count > 0;
        int item = data[1];
        swap(1, count);
        count--;
        shiftDown(1);
        return item;
    }

    public int getMax() {
        assert count > 0;
        return data[1];
    }

    /**
     * 堆中数据交换
     * <p>
     * 可以改为赋值操作
     */
    private void swap(int i, int j) {
        int item = data[i];
        data[i] = data[j];
        data[j] = item;
    }

    private void shiftUp(int k) {
        int v = data[k];
        while (k > 1 && v > data[k / 2]) {
            data[k] = data[k / 2];
            k = k / 2;
        }
        data[k] = v;
    }

    private void shiftDown(int k) {
        int v = data[k];
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[j + 1] > data[j])
                j++;
            if (v >= data[j]) break;
            data[k] = data[j];
            k = j;
        }
        data[k] = v;
    }
}
