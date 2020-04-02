package com.francis.leetcode.algorithms_for_java.ch_10_union_find;

/**
 * @author zhugequn
 * @since jdk8
 */
public interface UF {

    int getSize();

    boolean isConnected(int p, int q);
    
    void unionElements(int p, int q);
}
