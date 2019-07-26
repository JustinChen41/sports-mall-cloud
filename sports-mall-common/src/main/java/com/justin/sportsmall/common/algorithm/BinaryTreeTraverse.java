package com.justin.sportsmall.common.algorithm;

import com.justin.sportsmall.common.structure.tree.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 二叉树遍历算法
 * @Author: chenjianting
 * @Date: 2019/7/25 14:11
 */
public class BinaryTreeTraverse {
    private static Logger logger = LoggerFactory.getLogger(BinaryTreeTraverse.class);
    /**
     * 递归前序算法
     * 根结点 ---> 左子树 ---> 右子树
     * @param treeNode
     */
    public static <T> void recursionBeforeOrder(TreeNode<T> treeNode) {
        if (treeNode == null) {
            return;
        }
        logger.info("Before Order value: {}", treeNode.getData());
        recursionBeforeOrder(treeNode.getLeftChildNode());
        recursionBeforeOrder(treeNode.getRightChildNode());
    }

    /**
     * 递归中序算法
     * 左子树 ---> 根结点 ---> 右子树
     * @param treeNode
     */
    public static <T> void recursionInOrder(TreeNode<T> treeNode) {
        if (treeNode == null) {
            return;
        }
        recursionInOrder(treeNode.getLeftChildNode());
        logger.info("In Order value: {}", treeNode.getData());
        recursionInOrder(treeNode.getRightChildNode());
    }

    /**
     * 递归后序算法
     * 左子树 ---> 右子树 ---> 根结点
     * @param treeNode
     */
    public static <T> void recursionAfterOrder(TreeNode<T> treeNode) {
        if (treeNode == null) {
            return;
        }
        recursionAfterOrder(treeNode.getLeftChildNode());
        recursionAfterOrder(treeNode.getRightChildNode());
        logger.info("After Order value: {}", treeNode.getData());
    }
}
