package com.francis.leetcode.algorithms_for_java.ch_6_set_and_map;

/**
 * @author zhugequn
 * @since jdk8
 */
public interface Set<E> {

    void add(E e);

    boolean contains(E e);

    void remove(E e);

    int getSize();

    boolean isEmpty();
}
