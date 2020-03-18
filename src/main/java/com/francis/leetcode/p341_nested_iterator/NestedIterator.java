package com.francis.leetcode.p341_nested_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> data = new ArrayList<>();

    private int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        dfs(nestedList);
    }

    @Override
    public Integer next() {
        return data.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < data.size();
    }

    private void dfs(List<NestedInteger> nestedIntegers) {
        for (NestedInteger nestedInteger : nestedIntegers)
            if (nestedInteger.isInteger()) data.add(nestedInteger.getInteger());
            else dfs(nestedInteger.getList());
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }
}
