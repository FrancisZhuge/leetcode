package com.francis.leetcode.algorithms_for_java.ch_3_stacks_queues;

/**
 * @author zhugequn
 * @since jdk8
 */
public interface Stack<E> {

    /**
     * 获取大小
     *
     * @return 大小
     */
    int getSize();

    /**
     * 当前stack是否为空
     *
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 放入stack
     *
     * @param e 元素
     */
    void push(E e);

    /**
     * 取出数据
     *
     * @return 数据
     */
    E pop();

    /**
     * 查看stack顶数据
     *
     * @return 数据
     */
    E peek();
}
