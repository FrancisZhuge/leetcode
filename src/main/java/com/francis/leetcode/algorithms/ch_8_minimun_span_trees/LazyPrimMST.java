package com.francis.leetcode.algorithms.ch_8_minimun_span_trees;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hzzhugequn@corp.netease.com
 */
public class LazyPrimMST<Weight extends Number & Comparable> {

    /**
     * 图的引用
     */
    private WeightedGraph<Weight> graph;

    /**
     * 最小堆, 算法辅助数据结构
     */
    private MinHeap<Edge<Weight>> heap;

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

    public LazyPrimMST(WeightedGraph<Weight> graph) {
        this.graph = graph;
        this.heap = new MinHeap<>(graph.E());
        marked = new boolean[graph.V()];
        mst = new LinkedList<>();

        visit(0);
        while (!heap.isEmpty()){
            Edge<Weight> edge = heap.extractMin();
            if (marked[edge.v()] == marked[edge.w()]) continue;
            mst.add(edge);
            if (!marked[edge.v()])
                visit(edge.v());
            else
                visit(edge.w());
        }
        mstWeight = mst.get(0).weight();
        for (int i = 1; i < mst.size(); i++)
            mstWeight = mstWeight.doubleValue() + mst.get(i).weight().doubleValue();
    }

    private void visit(int v) {
        assert !marked[v];
        marked[v] = true;

        for (Edge<Weight> edge : graph.adj(v))
            if (!marked[edge.other(v)])
                heap.insert(edge);
    }

    public List<Edge<Weight>> mstEdges() {
        return mst;
    }

    public Number result() {
        return mstWeight;
    }
}
