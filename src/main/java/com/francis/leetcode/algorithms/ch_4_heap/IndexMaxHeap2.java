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
 * |  rev  |  8  |  10 |  7  |  9  |  5  |  6  |  3  |  4  |  2  |  1   |
 * +-------+-----+-----+-----+-----+-----+-----+-----+-----+-----+------+
 * <p>
 * reverse[i] 表示索引i在indexes中的位置
 * indexes[i]=j
 * reverse[j]=i
 * <p>
 * indexes[reverse[i]]=i
 * reverse[indexes[i]]=i
 *
 * @author hzzhugequn@corp.netease.com
 */
public class IndexMaxHeap2 {

    private int[] data;

    /**
     * 最大索引堆中的索引, indexes[x] = i 表示索引i在x的位置
     */
    private int[] indexes;

    /**
     * 最大索引堆中的反向索引, reverse[i] = x 表示索引i在x的位置
     */
    private int[] reverse;

    private int count;

    private int capacity;

    public IndexMaxHeap2(int capacity) {
        data = new int[capacity + 1];
        indexes = new int[capacity + 1];
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

    public void insert(int i, int item) {
        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;
        assert !contain(i);
        i++;
        data[i] = item;
        indexes[count + 1] = i;
        reverse[i] = count + 1;
        count++;
        shiftUp(count);
    }

    public int extractMax() {
        assert count > 0;
        int item = data[indexes[1]];
        swapIndex(count, 1);
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

    private boolean contain(int i) {
        assert i + 1 >= 1 && i + 1 <= capacity;
        return reverse[i + 1] != 0;
    }

    public void change(int i, int item) {
        assert contain(i);
        i++;
        data[i] = item;
        shiftUp(reverse[i]);
        shiftDown(reverse[i]);
    }

    private void shiftUp(int k) {
        while (k > 1 && data[indexes[k / 2]] < data[indexes[k]]) {
            swapIndex(k / 2, k);
            k /= 2;
        }
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[indexes[j + 1]] > data[indexes[j]])
                j++;
            if (data[indexes[k]] >= data[indexes[j]]) break;
            swapIndex(k, j);
            k = j;
        }
    }

    private void swapIndex(int i, int j) {
        Utils.swap(indexes, i, j);
        reverse[indexes[i]] = i;
        reverse[indexes[j]] = j;
    }
}




























