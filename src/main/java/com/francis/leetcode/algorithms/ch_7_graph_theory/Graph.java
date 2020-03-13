package com.francis.leetcode.algorithms.ch_7_graph_theory;

import java.util.List;

/**
 * 图的接口
 *
 * @author hzzhugequn@corp.netease.com
 */
public interface Graph {

    int getV();

    int getE();

    void addEdge(int v, int w);

    void addEdge(int v, List<Integer> wList);

    boolean hasEdge(int v, int w);

    void show();

    Iterable<Integer> adj(int v);
}
