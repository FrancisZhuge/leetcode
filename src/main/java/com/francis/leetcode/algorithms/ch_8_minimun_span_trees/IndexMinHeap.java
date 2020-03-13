package com.francis.leetcode.algorithms.ch_8_minimun_span_trees;

import com.francis.leetcode.algorithms.utils.Utils;

/**
 * @author hzzhugequn@corp.netease.com
 */
public class IndexMinHeap<Item extends Comparable> {

    private Item[] data;

    private int[] indexs;

    private int[] reverse;

    private int count;

    private int capacity;

    @SuppressWarnings("unchecked")
    public IndexMinHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        indexs = new int[capacity + 1];
        reverse = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(int i, Item item) {
        assert count + 1 < capacity;
        assert i + 1 >= 1 && i + 1 < capacity;
        assert !contain(i);
        i++;
        data[i] = item;
        indexs[count + 1] = i;
        reverse[i] = count + 1;
        count++;
        shiftUp(count);
    }

    public Item extractMin() {
        assert count > 0;
        Item item = data[indexs[1]];
        swap(1, count);
        reverse[indexs[count]] = 0;
        count--;
        shiftDown(count);
        return item;
    }

    public int extractMinIndex() {
        assert count > 0;
        int index = indexs[1] - 1;
        swap(1, count);
        reverse[indexs[count]] = 0;
        shiftDown(1);
        return index;
    }

    public Item getMin() {
        assert count > 0;
        return data[indexs[1]];
    }

    public int getMinIndex() {
        assert count > 0;
        return indexs[1] - 1;
    }

    public Item getItem(int i) {
        assert contain(i);
        return data[i + 1];
    }

    public void change(int i, Item item) {
        assert contain(i);
        i++;
        data[i] = item;
        shiftUp(reverse[i]);
        shiftDown(reverse[i]);
    }

    public boolean contain(int i) {
        assert i + 1 >= 1 && i + 1 < capacity;
        return reverse[i + 1] != 0;
    }

    @SuppressWarnings("unchecked")
    private void shiftUp(int k) {
        while (k > 1 && data[indexs[k / 2]].compareTo(data[indexs[k]]) > 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    @SuppressWarnings("unchecked")
    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[indexs[j + 1]].compareTo(data[indexs[j]]) < 0)
                j++;
            if (data[indexs[k]].compareTo(data[indexs[j]]) <= 0)
                break;
            swap(k, j);
            k = j;
        }
    }

    private void swap(int i, int j) {
        Utils.swap(indexs, i, j);
        reverse[indexs[i]] = i;
        reverse[indexs[j]] = j;
    }

}
