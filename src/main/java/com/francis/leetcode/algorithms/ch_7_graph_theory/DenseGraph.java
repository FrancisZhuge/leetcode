package com.francis.leetcode.algorithms.ch_7_graph_theory;

import java.util.ArrayList;
import java.util.List;

/**
 * 稠密图 - 邻接矩阵
 *
 * @author hzzhugequn@corp.netease.com
 */
public class DenseGraph implements Graph {

    /**
     * 节点数
     */
    private int n;

    /**
     * 边数
     */
    private int m;

    /**
     * 是否为有向图
     */
    private boolean directed;

    /**
     * 图具体数据
     */
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        assert n > 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new boolean[n][n];
    }

    @Override
    public int getV() {
        return n;
    }

    @Override
    public int getE() {
        return m;
    }

    @Override
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        if (hasEdge(v, w)) return;
        g[v][w] = true;
        if (!directed) g[w][v] = true;
        m++;
    }

    @Override
    public void addEdge(int v, List<Integer> wList) {
        if (wList != null && wList.size() > 0) {
            wList.forEach(w -> addEdge(v, w));
        }
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(g[i][j] + "\t");
            System.out.println();
        }
    }

    @Override
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        List<Integer> adjV = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (g[v][i]) adjV.add(i);
        }
        return adjV;
    }
}
























