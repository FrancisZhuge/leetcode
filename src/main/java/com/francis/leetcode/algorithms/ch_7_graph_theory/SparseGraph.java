package com.francis.leetcode.algorithms.ch_7_graph_theory;

import java.util.LinkedList;
import java.util.List;

/**
 * 稀疏图 - 邻接表
 *
 * @author hzzhugequn@corp.netease.com
 */
public class SparseGraph implements Graph {

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
    private List<Integer>[] g;

    @SuppressWarnings("unchecked")
    public SparseGraph(int n, boolean directed) {
        assert n > 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new List[n];
        for (int i = 0; i < n; i++)
            g[i] = new LinkedList<>();
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

        // 成本比较高
        //  if (hasEdge(v, w)) return;
        g[v].add(w);
        if (v != w && !directed) {
            g[w].add(v);
        }
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
        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].get(i) == w)
                return true;
        }
        return false;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("vertex " + i + ":\t");
            for (int j = 0; j < g[i].size(); j++)
                System.out.print(g[i].get(j) + "\t");
            System.out.println();
        }
    }

    @Override
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
















