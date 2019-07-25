package com.justin.sportsmall.common.structure.tree;

/**
 * @Author: chenjianting
 * @Date: 2019/7/25 10:04
 */
public abstract class AbstractTree<T> {
    /**
     * 无序插入
     * @param treeNode
     */
    public abstract void disorderInsertNode(TreeNode<T> treeNode);

    /**
     * 顺序插入
     * @param treeNode
     */
    public abstract void sortedInsertNode(TreeNode<T> treeNode);

    /**
     * 查找节点
     * @param data
     * @return
     */
    public abstract TreeNode getNode(T data);

    public abstract void deleteNode(T data);
}
