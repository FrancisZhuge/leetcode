package com.francis.leetcode.algorithms.ch_4_heap;

import com.francis.leetcode.algorithms.utils.Utils;

/**
 * 索引堆
 * <p>
 * 普通堆最大的问题是没有办法索引到指定的元素
 * +-------+-----+-----+-----+-----+-----+-----+-----+-----+-----+------+
 * | 0     |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |  10  |
 * | index |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |  10  |
 * | data  |  15 |  17 |  19 |  13 |  22 |  16 |  28 |  30 |  41 |  62  |
 * +-------+-----+-----+-----+-----+-----+-----+-----+-----+-----+------+
 * <p>
 * +-------+-----+-----+-----+-----+-----+-----+-----+-----+-----+------+
 * | 0     |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |  10  |
 * | index |  10 |  9  |  7  |  8  |  5  |  6  |  3  |  1  |  4  |  2   |
 * | data  |  15 |  17 |  19 |  13 |  22 |  16 |  28 |  30 |  41 |  62  |
 * +-------+-----+-----+-----+-----+-----+-----+-----+-----+-----+------+
 *
 * @author hzzhugequn@corp.netease.com
 */
public class IndexMaxHeap {

    private int[] data;

    /**
     * 最大索引堆中的索引, indexes[x] = i 表示索引i在x的位置
     */
    private int[] indexes;

    private int count;

    private int capacity;

    public IndexMaxHeap(int capacity) {
        data = new int[capacity + 1];
        indexes = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(int i, int item) {
        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;
        i++;
        data[i] = item;
        indexes[count + 1] = i;
        count++;
        shiftUp(count);
    }

    public int extractMax() {
        assert count > 0;
        int item = data[indexes[1]];
        Utils.swap(indexes, count, 1);
        count--;
        shiftDown(1);
        return item;
    }

    public int extractMaxIndex() {
        assert count > 0;
        int item = indexes[1] - 1;
        Utils.swap(indexes, count, 1);
        count--;
        shiftDown(1);
        return item;
    }

    public int getMax() {
        assert count > 0;
        return data[indexes[1]];
    }

    public int getMaxIndex() {
        assert count > 0;
        return indexes[1] - 1;
    }

    public void change(int i, int item) {
        i++;
        data[i] = item;
        for (int j = 1; j <= count; j++) {
            if (indexes[j] == i) {
                shiftUp(j);
                shiftDown(j);
                return;
            }
        }
    }

    private void shiftUp(int k) {
        while (k > 1 && data[indexes[k / 2]] < data[indexes[k]]) {
            Utils.swap(indexes, k / 2, k);
            k /= 2;
        }
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[indexes[j + 1]] > data[indexes[j]])
                j++;
            if (data[indexes[k]] >= data[indexes[j]]) break;
            Utils.swap(indexes, k, j);
            k = j;
        }
    }
}