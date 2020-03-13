package com.francis.leetcode.algorithms.ch_9_shortest_tree;

import com.francis.leetcode.algorithms.ch_8_minimun_span_trees.Edge;
import com.francis.leetcode.algorithms.ch_8_minimun_span_trees.IndexMinHeap;
import com.francis.leetcode.algorithms.ch_8_minimun_span_trees.WeightedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author hzzhugequn@corp.netease.com
 */
public class Dijkstra<Weight extends Number & Comparable> {

    /**
     * 图的引用
     */
    private WeightedGraph graph;

    /**
     * 起始点
     */
    private int start;

    /**
     * distTo[i]存储从起始点s到i的最短路径长度
     */
    private Number[] distTo;

    /**
     * 标记数组, 在算法运行过程中标记节点i是否被访问
     */
    private boolean[] marked;

    /**
     * from[i]记录最短路径中, 到达i点的边是哪一条
     * 可以用来恢复整个最短路径
     */
    private Edge<Weight>[] from;

    @SuppressWarnings("unchecked")
    public Dijkstra(WeightedGraph graph, int start) {
        this.graph = graph;
        this.start = start;
        assert start >= 0 && start < graph.V();
        distTo = new Number[graph.V()];
        marked = new boolean[graph.V()];
        from = new Edge[graph.V()];
        for (int i = 0; i < graph.V(); i++)
            distTo[i] = 0.0;

        IndexMinHeap<Weight> heap = new IndexMinHeap<>(graph.V());
        distTo[start] = 0.0;
        from[start] = new Edge<>(start, start, (Weight) (Number) 0.0);
        heap.insert(start, (Weight) distTo[start]);
        marked[start] = true;

        while (!heap.isEmpty()) {
            int v = heap.extractMinIndex();
            marked[v] = true;
            for (Object item : graph.adj(v)) {
                Edge<Weight> edge = (Edge<Weight>) item;
                int w = edge.other(v);
                if (!marked[w]) {
                    if (from[w] == null || distTo[v].doubleValue() + edge.weight().doubleValue() < distTo[w].doubleValue()) {
                        distTo[w] = distTo[v].doubleValue() + edge.weight().doubleValue();
                        from[w] = edge;
                        if (heap.contain(w))
                            heap.change(w, (Weight) distTo[w]);
                        else
                            heap.insert(w, (Weight) distTo[w]);
                    }
                }
            }
        }
    }

    public Number shortestPathTo(int w) {
        assert w >= 0 && w < graph.V();
        assert hasPathTo(w);
        return distTo[w];
    }

    public boolean hasPathTo(int w) {
        assert w >= 0 && w < graph.V();
        return marked[w];
    }

    // 寻找从s到w的最短路径, 将整个路径经过的边存放在vec中
    public List<Edge<Weight>> shortestPath(int w) {
        assert w >= 0 && w < graph.V();
        assert hasPathTo(w);

        Stack<Edge<Weight>> s = new Stack<Edge<Weight>>();
        Edge<Weight> e = from[w];
        while (e.v() != this.start) {
            s.push(e);
            e = from[e.v()];
        }
        s.push(e);

        List<Edge<Weight>> res = new ArrayList<Edge<Weight>>();
        while (!s.empty()) {
            e = s.pop();
            res.add(e);
        }
        return res;
    }

    // 打印出从s点到w点的路径
    void showPath(int w) {
        assert w >= 0 && w < graph.V();
        assert hasPathTo(w);
        List<Edge<Weight>> path = shortestPath(w);
        String res = path.stream().map(p -> String.valueOf(p.v())).collect(Collectors.joining("->"));
        System.out.println(res);
    }
}