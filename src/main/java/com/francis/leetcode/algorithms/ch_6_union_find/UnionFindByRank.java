package com.francis.leetcode.algorithms.ch_6_union_find;

/**
 * @author hzzhugequn@corp.netease.com
 */
public class UnionFindByRank {

    private int[] rank;

    private int[] parent;

    private int count;

    public UnionFindByRank(int n) {
        this.count = n;
        rank = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int p) {
        assert (p >= 0 && p < count);
        while (p != parent[p])
            p = parent[p];
        return p;
    }

    public int findPathCompression(int p) {
        assert (p >= 0 && p < count);
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public int findPathCompression1(int p) {
        assert (p >= 0 && p < count);
        if (p != parent[p])
            parent[p] = findPathCompression1(parent[p]);
        return parent[p];
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        if (rank[pRoot] < rank[qRoot])
            parent[pRoot] = qRoot;
        else if (rank[pRoot] > rank[qRoot])
            parent[qRoot] = pRoot;
        else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;   // 此时, 我维护rank的值
        }
    }
}
