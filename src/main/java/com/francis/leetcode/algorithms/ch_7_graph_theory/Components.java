package com.francis.leetcode.algorithms.ch_7_graph_theory;

/**
 * 求无权图的联通分量
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Components {

    private Graph graph;

    private boolean[] visited;

    private int componentCount;

    private int[] id;

    public Components(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.getV()];
        id = new int[graph.getV()];
        componentCount = 0;

        for (int i = 0; i < graph.getV(); i++)
            id[i] = -1;

        for (int i = 0; i < graph.getV(); i++) {
            if (!visited[i]) {
                dfs(i);
                componentCount++;
            }
        }
    }

    public int count() {
        return componentCount;
    }

    public boolean isConnected(int v, int w) {
        assert v >= 0 && v < graph.getV();
        assert w >= 0 && v < graph.getV();
        return id[v] == id[w];
    }

    private void dfs(int v) {
        visited[v] = true;
        id[v] = componentCount;
        for (int i : graph.adj(v)) {
            if (!visited[i])
                dfs(i);
        }
    }

}
