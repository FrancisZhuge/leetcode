package com.francis.leetcode.algorithms_for_java.ch_3_stacks_queues;

/**
 * @author zhugequn
 * @since jdk8
 */
public interface Queue<E> {

    /**
     * 大小
     *
     * @return 大小
     */
    int getSize();

    /**
     * 是否为空
     *
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 进队
     *
     * @param e 元素
     */
    void enqueue(E e);

    /**
     * 出队
     *
     * @return 元素
     */
    E dequeue();

    /**
     * 看队首元素
     *
     * @return 元素
     */
    E getFront();
}
