package com.justin.sportsmall.common.algorithm;

import com.justin.sportsmall.common.structure.tree.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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
    static <T> void recursionBeforeOrder(TreeNode<T> treeNode) {
        if (treeNode == null) {
            return;
        }
        logger.info("Before Order value: {}", treeNode.getData());
        List<TreeNode<T>> childNodes = treeNode.getChildNodes();
        if (childNodes == null || childNodes.size() == 0) {
            return;
        }
        recursionBeforeOrder(childNodes.get(0));
        recursionBeforeOrder(childNodes.size() == 2 ? childNodes.get(1) : null);
    }

    /**
     * 递归中序算法
     * 左子树 ---> 根结点 ---> 右子树
     * @param treeNode
     */
    static <T> void recursionInOrder(TreeNode<T> treeNode) {
        if (treeNode == null) {
            return;
        }
        List<TreeNode<T>> childNodes = treeNode.getChildNodes();
        if (childNodes == null || childNodes.size() == 0) {
            logger.info("In Order value: {}", treeNode.getData());
            return;
        }
        recursionInOrder(childNodes.get(0));
        logger.info("In Order value: {}", treeNode.getData());
        recursionInOrder(childNodes.size() == 2 ? childNodes.get(1) : null);
    }

    /**
     * 递归后序算法
     * 左子树 ---> 右子树 ---> 根结点
     * @param treeNode
     */
    static <T> void recursionAfterOrder(TreeNode<T> treeNode) {
        if (treeNode == null) {
            return;
        }
        List<TreeNode<T>> childNodes = treeNode.getChildNodes();
        if (childNodes == null || childNodes.size() == 0) {
            logger.info("After Order value: {}", treeNode.getData());
            return;
        }
        recursionAfterOrder(childNodes.get(0));
        recursionAfterOrder(childNodes.size() == 2 ? childNodes.get(1) : null);
        logger.info("After Order value: {}", treeNode.getData());
    }
}
