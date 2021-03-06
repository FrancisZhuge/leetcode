package com.francis.leetcode.algorithms.ch_8_minimun_span_trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hzzhugequn@corp.netease.com
 */
public class SparseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {

    private int n;

    private int m;

    private boolean directed;

    private List<Edge<Weight>>[] g;

    @SuppressWarnings("unchecked")
    public SparseWeightedGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = (List<Edge<Weight>>[]) new List[n];
        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<>();
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addEdge(Edge e) {
        assert e.v() >= 0 && e.v() < n;
        assert e.w() >= 0 && e.w() < n;
        // 注意, 由于在邻接表的情况, 查找是否有重边需要遍历整个链表
        // 我们的程序允许重边的出现
        g[e.v()].add(new Edge(e));
        if (e.v() != e.w() && !directed)
            g[e.w()].add(new Edge(e.w(), e.v(), e.weight()));
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        for (int i = 0; i < g[v].size(); i++)
            if (g[v].get(i).other(v) == w)
                return true;
        return false;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("vertex " + i + ":\t");
            for (int j = 0; j < g[i].size(); j++) {
                Edge e = g[i].get(j);
                System.out.print("( to:" + e.other(i) + ",wt:" + e.weight() + ")\t");
            }
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
