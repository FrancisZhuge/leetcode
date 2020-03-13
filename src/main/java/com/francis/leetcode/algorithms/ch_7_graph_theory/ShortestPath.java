package com.francis.leetcode.algorithms.ch_7_graph_theory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hzzhugequn@corp.netease.com
 */
public class ShortestPath {

    /**
     * 图的引用
     */
    private Graph graph;

    /**
     * 起始点
     */
    private int start;

    /**
     * 记录dfs的过程中节点是否被访问
     */
    private boolean[] visited;

    /**
     * 记录路径, from[i]表示查找的路径上i的上一个节点
     */
    private int[] from;

    /**
     * 记录路径中节点的次序。order[i]表示i节点在路径中的次序。
     */
    private int[] order;

    public ShortestPath(Graph graph, int start) {
        this.graph = graph;
        assert start >= 0 && start < graph.getV();
        visited = new boolean[graph.getV()];
        from = new int[graph.getV()];
        order = new int[graph.getV()];
        this.start = start;

        for (int i = 0; i < graph.getV(); i++) {
            visited[i] = false;
            from[i] = -1;
            order[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        order[start] = 0;

        while (!queue.isEmpty()) {
            Integer v = queue.remove();
            for (int i : graph.adj(v)) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    from[i] = v;
                    order[i] = order[v] + 1;
                }
            }
        }
    }

    public boolean hasPath(int w) {
        assert w >= 0 && w < graph.getV();
        return visited[w];
    }

    public List<Integer> path(int w) {
        assert hasPath(w);
        Stack<Integer> stack = new Stack<>();
        while (w != -1) {
            stack.push(w);
            w = from[w];
        }
        List<Integer> res = new LinkedList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    public void showPath(int w) {
        assert hasPath(w);
        List<Integer> path = path(w);
        String res = path.stream().map(String::valueOf).collect(Collectors.joining("->"));
        System.out.println(res);
    }

    public static void main(String[] args) {
        Graph graph = new DenseGraph(7, false);
        graph.addEdge(0, Arrays.asList(1, 2, 5, 6));
        graph.addEdge(1, Arrays.asList(0));
        graph.addEdge(2, Arrays.asList(0));
        graph.addEdge(3, Arrays.asList(4, 5));
        graph.addEdge(4, Arrays.asList(3, 5, 6));
        graph.addEdge(5, Arrays.asList(0, 3, 4));
        graph.addEdge(6, Arrays.asList(0, 4));
        ShortestPath path = new ShortestPath(graph, 0);
        path.showPath(6);
    }
}
