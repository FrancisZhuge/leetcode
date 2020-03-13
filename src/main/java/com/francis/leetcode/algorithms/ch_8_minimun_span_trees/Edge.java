package com.francis.leetcode.algorithms.ch_8_minimun_span_trees;

/**
 * @author hzzhugequn@corp.netease.com
 */
public class Edge<Weight extends Number & Comparable> implements Comparable<Edge> {

    private int a;

    private int b;

    private Weight weight;

    public Edge(int a, int b, Weight weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public Edge(Edge<Weight> edge) {
        this.a = edge.a;
        this.b = edge.b;
        this.weight = edge.weight;
    }

    public int v() {
        return a;
    }

    public int w() {
        return b;
    }

    public Weight weight() {
        return weight;
    }

    public int other(int x) {
        assert x == a || x == b;
        return x == a ? b : a;
    }

    public String toString() {
        return "" + a + "-" + b + ": " + weight;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int compareTo(Edge o) {
        if (weight.compareTo(o.weight()) < 0)
            return -1;
        else if (weight.compareTo(o.weight()) > 0)
            return +1;
        else
            return 0;
    }
}
