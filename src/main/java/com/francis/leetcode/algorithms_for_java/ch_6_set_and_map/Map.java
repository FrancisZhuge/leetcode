package com.francis.leetcode.algorithms_for_java.ch_6_set_and_map;

/**
 * @author zhugequn
 * @since jdk8
 */
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

    boolean isEmpty();
}
