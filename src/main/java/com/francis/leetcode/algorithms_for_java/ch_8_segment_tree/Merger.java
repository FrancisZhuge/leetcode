package com.francis.leetcode.algorithms_for_java.ch_8_segment_tree;

/**
 * @author zhugequn
 * @since jdk8
 */
public interface Merger<E> {

    E merge(E a, E b);
}
