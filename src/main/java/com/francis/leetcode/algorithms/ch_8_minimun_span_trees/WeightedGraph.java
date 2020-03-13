package com.francis.leetcode.algorithms.ch_8_minimun_span_trees;

/**
 * @author hzzhugequn@corp.netease.com
 */
public interface WeightedGraph<Weight extends Number & Comparable> {

    int V();

    int E();

    void addEdge(Edge<Weight> e);

    boolean hasEdge(int v, int w);

    void show();

    Iterable<Edge<Weight>> adj(int v);
}
