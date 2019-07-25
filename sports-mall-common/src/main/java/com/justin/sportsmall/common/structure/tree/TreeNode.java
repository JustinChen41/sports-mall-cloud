package com.justin.sportsmall.common.structure.tree;

import lombok.Data;

import java.util.List;

/**
 * 树节点类
 * @Author: chenjianting
 * @Date: 2019/7/24 11:32
 */
@Data
public class TreeNode<T> implements Comparable<TreeNode<T>> {
    /**
     * 所在父节点下编号，从左到右从0计数，二叉树index最大为1
     */
    private int index;

    private T data;

    private String color;

    private TreeNode<T> parentNode;

    private List<TreeNode<T>> childNodes;

    public TreeNode(T data) {
        this.data = data;
    }

    @Override
    public int compareTo(TreeNode<T> node) {
        if (node.getData() instanceof Integer && this.getData() instanceof Integer) {
            return Integer.compare((Integer) node.getData(), (Integer)this.getData());
        }
        return 0;
    }
}
