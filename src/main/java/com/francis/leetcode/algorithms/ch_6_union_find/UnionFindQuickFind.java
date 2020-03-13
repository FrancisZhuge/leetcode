package com.francis.leetcode.algorithms.ch_6_union_find;

/**
 * 并查集
 *
 * @author hzzhugequn@corp.netease.com
 */
public class UnionFindQuickFind {

    private int[] id;

    private int count;

    public UnionFindQuickFind(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    public int find(int p) {
        assert p >= 0 && p < count;
        return id[p];
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) return;
        for (int i = 0; i < count; i++)
            if (id[i] == pId)
                id[i] = qId;
    }
}
