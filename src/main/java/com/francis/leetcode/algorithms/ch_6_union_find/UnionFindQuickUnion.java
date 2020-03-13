package com.francis.leetcode.algorithms.ch_6_union_find;

/**
 * @author hzzhugequn@corp.netease.com
 */
public class UnionFindQuickUnion {

    private int[] parent;

    private int count;

    public UnionFindQuickUnion(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    public int find(int p) {
        assert p >= 0 && p < count;
        while (p != parent[p])
            p = parent[p];
        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        parent[pRoot] = qRoot;
    }
}
