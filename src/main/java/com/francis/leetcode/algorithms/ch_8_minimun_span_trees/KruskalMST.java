package com.francis.leetcode.algorithms.ch_8_minimun_span_trees;

import com.francis.leetcode.algorithms.ch_6_union_find.UnionFindByRank;

import java.util.LinkedList;
import java.util.List;

/**
 * 新建图{\displaystyle G}G，{\displaystyle G}G中拥有原图中相同的节点，但没有边
 * 将原图中所有的边按权值从小到大排序
 * 从权值最小的边开始，如果这条边连接的两个节点于图{\displaystyle G}G中不在同一个连通分量中，则添加这条边到图{\displaystyle G}G中
 * 重复3，直至图{\displaystyle G}G中所有的节点都在同一个连通分量中
 *
 * @author hzzhugequn@corp.netease.com
 */
public class KruskalMST<Weight extends Number & Comparable> {

    /**
     * 最小生成树所包含的所有边
     */
    private List<Edge<Weight>> mst;

    /**
     * 最小生成树的权值
     */
    private Number mstWeight;

    @SuppressWarnings("unchecked")
    public KruskalMST(WeightedGraph graph) {
        mst = new LinkedList<>();
        MinHeap<Edge<Weight>> heap = new MinHeap<>(graph.E());

        for (int i = 0; i < graph.V(); i++) {
            for (Object item : graph.adj(i)) {
                Edge<Weight> edge = (Edge<Weight>) item;
                if (edge.v() < edge.w())
                    heap.insert(edge);
            }
        }

        UnionFindByRank unionFind = new UnionFindByRank(graph.V());
        while (!heap.isEmpty() && mst.size() < graph.V() - 1) {
            Edge<Weight> edge = heap.extractMin();
            if (unionFind.isConnected(edge.v(), edge.w()))
                continue;
            mst.add(edge);
            unionFind.unionElements(edge.v(), edge.w());
        }

        mstWeight = mst.get(0).weight();
        for (int i = 1; i < mst.size(); i++)
            mstWeight = mstWeight.doubleValue() + mst.get(i).weight().doubleValue();
    }

    public List<Edge<Weight>> mstEdges() {
        return mst;
    }

    private Number result() {
        return mstWeight;
    }
}
