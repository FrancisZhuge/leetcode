package com.francis.leetcode.algorithms.ch_9_shortest_tree;

import com.francis.leetcode.algorithms.ch_8_minimun_span_trees.Edge;
import com.francis.leetcode.algorithms.ch_8_minimun_span_trees.WeightedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author hzzhugequn@corp.netease.com
 */
public class BellmanFord<Weight extends Number & Comparable> {

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
     * from[i]记录最短路径中, 到达i点的边是哪一条
     * 可以用来恢复整个最短路径
     */
    Edge<Weight>[] from;

    /**
     * 标记图中是否有负权环
     */
    boolean hasNegativeCycle;

    @SuppressWarnings("unchecked")
    public BellmanFord(WeightedGraph graph, int start) {
        this.graph = graph;
        this.start = start;
        distTo = new Number[graph.V()];
        from = new Edge[graph.V()];

        for (int i = 0; i < graph.V(); i++) {
            from[i] = null;
        }
        // 设置distTo[s] = 0, 并且让from[s]不为NULL, 表示初始s节点可达且距离为0
        distTo[start] = 0.0;
        // 这里我们from[s]的内容是new出来的
        from[start] = new Edge<>(start, start, (Weight) (Number) (0.0));

        for (int pass = 1; pass < graph.V(); pass++) {
            // 每次循环中对所有的边进行一遍松弛操作
            // 遍历所有边的方式是先遍历所有的顶点, 然后遍历和所有顶点相邻的所有边
            for (int i = 0; i < graph.V(); i++) {
                // 使用我们实现的邻边迭代器遍历和所有顶点相邻的所有边
                for (Object item : graph.adj(i)) {
                    Edge<Weight> e = (Edge<Weight>) item;
                    // 对于每一个边首先判断e->v()可达
                    // 之后看如果e->w()以前没有到达过， 显然我们可以更新distTo[e->w()]
                    // 或者e->w()以前虽然到达过, 但是通过这个e我们可以获得一个更短的距离, 即可以进行一次松弛操作, 我们也可以更新distTo[e->w()]
                    if (from[e.v()] != null && (from[e.w()] == null || distTo[e.v()].doubleValue() + e.weight().doubleValue() < distTo[e.w()].doubleValue())) {
                        distTo[e.w()] = distTo[e.v()].doubleValue() + e.weight().doubleValue();
                        from[e.w()] = e;
                    }
                }
            }
        }
    }

    // 判断图中是否有负权环
    @SuppressWarnings("unchecked")
    boolean detectNegativeCycle() {
        for (int i = 0; i < graph.V(); i++) {
            for (Object item : graph.adj(i)) {
                Edge<Weight> e = (Edge<Weight>) item;
                if (from[e.v()] != null && distTo[e.v()].doubleValue() + e.weight().doubleValue() < distTo[e.w()].doubleValue())
                    return true;
            }
        }
        return false;
    }

    // 返回图中是否有负权环
    boolean negativeCycle() {
        return hasNegativeCycle;
    }

    // 返回从s点到w点的最短路径长度
    Number shortestPathTo(int w) {
        assert w >= 0 && w < graph.V();
        assert !hasNegativeCycle;
        assert hasPathTo(w);
        return distTo[w];
    }

    // 判断从s点到w点是否联通
    boolean hasPathTo(int w) {
        assert (w >= 0 && w < graph.V());
        return from[w] != null;
    }

    // 寻找从s到w的最短路径, 将整个路径经过的边存放在vec中
    public List<Edge<Weight>> shortestPath(int w) {
        assert w >= 0 && w < graph.V();
        assert !hasNegativeCycle;
        assert hasPathTo(w);
        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        Stack<Edge<Weight>> s = new Stack<Edge<Weight>>();
        Edge<Weight> e = from[w];
        while (e.v() != this.start) {
            s.push(e);
            e = from[e.v()];
        }
        s.push(e);
        // 从栈中依次取出元素, 获得顺序的从s到w的路径
        List<Edge<Weight>> res = new ArrayList<Edge<Weight>>();
        while (!s.empty()) {
            e = s.pop();
            res.add(e);
        }
        return res;
    }

    // 打印出从s点到w点的路径
    public void showPath(int w) {
        assert (w >= 0 && w < graph.V());
        assert (!hasNegativeCycle);
        assert (hasPathTo(w));
        List<Edge<Weight>> path = shortestPath(w);
        String res = path.stream().map(p -> String.valueOf(p.v())).collect(Collectors.joining("->"));
        System.out.println(res);
    }
}
