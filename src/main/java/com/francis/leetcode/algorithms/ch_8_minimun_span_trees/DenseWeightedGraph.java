package com.francis.leetcode.algorithms.ch_8_minimun_span_trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 稠密图 - 邻接矩阵
 *
 * @author hzzhugequn@corp.netease.com
 */
public class DenseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {

    private int n;

    private int m;

    private boolean directed;

    private Edge<Weight>[][] edges;

    @SuppressWarnings("unchecked")
    public DenseWeightedGraph(int n, boolean directed) {
        assert n > 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        this.edges = new Edge[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                edges[i][j] = null;
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
        if (hasEdge(e.v(), e.w())) return;
        edges[e.v()][e.w()] = new Edge(e);
        if (e.v() != e.w() && !directed)
            edges[e.w()][e.v()] = new Edge(e.w(), e.v(), e.weight());
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return edges[v][w] != null;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (edges[i][j] != null)
                    System.out.print(edges[i][j].weight() + "\t");
                else
                    System.out.print("NULL\t");
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        List<Edge<Weight>> adjV = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (edges[v][i] != null)
                adjV.add(edges[v][i]);
        return adjV;
    }
}
