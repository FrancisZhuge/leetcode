package com.francis.leetcode.algorithms.ch_8_minimun_span_trees;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hzzhugequn@corp.netease.com
 */
public class PrimMST<Weight extends Number & Comparable> {

    /**
     * 图的引用
     */
    private WeightedGraph<Weight> graph;

    /**
     * 最小堆, 算法辅助数据结构
     */
    private IndexMinHeap<Edge<Weight>> heap;

    /**
     * 访问的点所对应的边, 算法辅助数据结构
     */
    private Edge<Weight>[] edgeTo;

    /**
     * 标记数组, 在算法运行过程中标记节点i是否被访问
     */
    private boolean[] marked;

    /**
     * 最小生成树所包含的所有边
     */
    private List<Edge<Weight>> mst;

    /**
     * 最小生成树的权值
     */
    private Number mstWeight;

    @SuppressWarnings("unchecked")
    public PrimMST(WeightedGraph<Weight> graph) {
        this.graph = graph;
        assert graph.E() >= 1;

        this.heap = new IndexMinHeap<>(graph.E());
        marked = new boolean[graph.V()];
        edgeTo = new Edge[graph.V()];
        mst = new LinkedList<>();

        visit(0);
        while (!heap.isEmpty()) {
            int v = heap.extractMinIndex();
            assert (edgeTo[v] != null);
            mst.add(edgeTo[v]);
            visit(v);
        }
        mstWeight = mst.get(0).weight();
        for (int i = 1; i < mst.size(); i++)
            mstWeight = mstWeight.doubleValue() + mst.get(i).weight().doubleValue();
    }

    @SuppressWarnings("unchecked")
    private void visit(int v) {
        assert !marked[v];
        marked[v] = true;

        for (Edge<Weight> edge : graph.adj(v)) {
            int w = edge.other(v);
            if (!marked[w]) {
                if (edgeTo[w] == null) {
                    edgeTo[w] = edge;
                    heap.insert(w, edge);
                } else if (edge.weight().compareTo(edgeTo[w].weight()) < 0) {
                    edgeTo[w] = edge;
                    heap.change(w, edge);
                }
            }
        }
    }

    public List<Edge<Weight>> mstEdges() {
        return mst;
    }

    public Number result() {
        return mstWeight;
    }
}
