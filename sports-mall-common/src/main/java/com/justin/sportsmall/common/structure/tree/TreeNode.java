package com.justin.sportsmall.common.structure.tree;

import lombok.Data;

/**
 * 树节点类
 * @Author: chenjianting
 * @Date: 2019/7/24 11:32
 */
@Data
public class TreeNode<T> implements Comparable<TreeNode<T>> {

    private T data;

    private String color;

    private TreeNode<T> parentNode;

    private TreeNode<T> leftChildNode;

    private TreeNode<T> rightChildNode;

    public TreeNode(T data) {
        this.data = data;
    }

    @Override
    public int compareTo(TreeNode<T> node) {
        if (node.getData() instanceof Integer && this.getData() instanceof Integer) {
            return ((Integer) this.getData()).compareTo((Integer) node.getData());
        }
        return 0;
    }
}
