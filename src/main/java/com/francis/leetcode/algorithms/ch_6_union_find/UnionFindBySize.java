package com.francis.leetcode.algorithms.ch_6_union_find;

/**
 * @author hzzhugequn@corp.netease.com
 */
public class UnionFindBySize {

    private int[] parent;

    private int[] size;

    private int count;

    public UnionFindBySize(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        this.count = n;
    }

    public int find(int p) {
        assert (p >= 0 && p < count);
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
        if (size[pRoot] < size[qRoot]) {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }
}
