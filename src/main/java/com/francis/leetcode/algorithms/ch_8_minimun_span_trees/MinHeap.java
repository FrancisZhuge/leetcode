package com.francis.leetcode.algorithms.ch_8_minimun_span_trees;

import com.francis.leetcode.algorithms.utils.Utils;

/**
 * @author hzzhugequn@corp.netease.com
 */
public class MinHeap<Item extends Comparable> {

    private Item[] data;

    private int count;

    private int capacity;

    @SuppressWarnings("unchecked")
    public MinHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    @SuppressWarnings("unchecked")
    public MinHeap(Item[] arr) {
        int len = arr.length;
        data = (Item[]) new Comparable[capacity + 1];
        capacity = len;
        for (int i = 0; i < len; i++)
            data[i + 1] = arr[i];
        count = len;
        for (int i = count / 2; i >= 1; i--)
            shiftDown(i);
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(Item item) {
        assert count + 1 < capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    public Item extractMin() {
        assert count > 0;
        Item item = data[1];
        Utils.swap(data, 1, count);
        count--;
        shiftDown(1);
        return item;
    }

    public Item getMin() {
        assert count > 0;
        return data[1];
    }

    @SuppressWarnings("unchecked")
    private void shiftUp(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) > 0) {
            Utils.swap(data, k / 2, k);
            k /= 2;
        }
    }

    @SuppressWarnings("unchecked")
    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) < 0)
                j++;
            if (data[k].compareTo(data[j]) <= 0)
                break;
            Utils.swap(data, k, j);
            k = j;
        }
    }
}
