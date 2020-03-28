package com.francis.leetcode.algorithms_for_java.ch_2_arrays;


import java.util.Arrays;

/**
 * 数组
 *
 * @author zhugequn
 * @since jdk8
 */
public class Array<E> {

    /**
     * 数据
     */
    private E[] data;

    /**
     * 有效元素
     */
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity 容量
     */
    @SuppressWarnings("unchecked")
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组的容量
     *
     * @return 容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组中的元素个数
     *
     * @return 元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回数组是否为空
     *
     * @return {@code true}为空，{@code false}不为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 末尾添加
     *
     * @param e 新元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 开头添加元素
     *
     * @param e 需要添加的元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    private void checkIndex1(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("failed. Index is illegal.");
    }

    private void checkIndex2(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("failed. Index is illegal.");
    }

    /**
     * 在index索引的位置插入一个新元素e
     *
     * @param index 索引
     * @param e     元素
     */
    public void add(int index, E e) {
        if (size == data.length)
            resize(2 * data.length);
        checkIndex1(index);
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];
        data[index] = e;
        size++;
    }

    /**
     * 获取index索引位置的元素
     *
     * @param index 索引
     * @return 值
     */
    public E get(int index) {
        checkIndex2(index);
        return data[index];
    }

    /**
     * 获取最后的元素
     *
     * @return 最后的元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获取最开始的元素
     *
     * @return 最开始的元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 修改index索引位置的元素为e
     *
     * @param index 索引
     * @param e     值
     */
    public void set(int index, E e) {
        checkIndex2(index);
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     *
     * @param e 元素
     * @return {@code true} 包含
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) if (data[i] == e) return true;
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     *
     * @param e 元素
     * @return 索引
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return i;
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素, 返回删除的元素
     *
     * @param index 索引
     * @return 删除的元素
     */
    public E remove(int index) {
        checkIndex2(index);
        E result = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return result;
    }

    /**
     * 从数组中删除第一个元素, 返回删除的元素
     *
     * @return 删除的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素, 返回删除的元素
     *
     * @return 删除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     *
     * @param e 元素
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    @Override
    public String toString() {
        return String.format("Array: size = %d , capacity = %d\n", size, data.length) + Arrays.toString(this.data);
    }

    /**
     * 将数组空间的容量变成newCapacity大小
     *
     * @param newCapacity 新大小
     */
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(20);
        for (int i = 0; i < 10; i++)
            arr.addLast(i);
        System.out.println(arr);
    }
}
