package com.justin.sportsmall.common.structure.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树
 * @Author: chenjianting
 * @Date: 2019/7/25 10:11
 */
public class BinaryTree<T> extends AbstractTree<T> {

    public TreeNode<T> rootNode;

    private LinkedList<TreeNode<T>> treeNodes = new LinkedList<>();

    @Override
    public void disorderInsertNode(TreeNode<T> treeNode) {
        LinkedList<TreeNode<T>> currentTreeNodes = new LinkedList<>(treeNodes);
        if (null == rootNode) {
            rootNode = treeNode;
            treeNodes.add(rootNode);
        } else {
            TreeNode<T> currentNode = rootNode;
            while (true) {
                //子节点为空，插入左孩子
                if (currentNode.getLeftChildNode() == null) {
                    setLeftChildNode(currentNode, treeNode);
                    treeNodes.add(treeNode);
                    break;
                } else if (currentNode.getRightChildNode() == null) {
                    setRightChildNode(currentNode, treeNode);
                    treeNodes.add(treeNode);
                    break;
                } else {
                    //子节点数量大于等于最大数量，表示子节点数量满，取节点队列第一个并从队列移除
                    currentNode = currentTreeNodes.poll();
                }
            }
        }
    }

    @Override
    public void sortedInsertNode(TreeNode<T> treeNode) {
        if (null == rootNode) {
            rootNode = treeNode;
        } else {
            TreeNode<T> currentNode = rootNode;
            while (true) {
                if (treeNode.compareTo(currentNode) < 0) {
                    if (currentNode.getLeftChildNode() == null) {
                        setLeftChildNode(currentNode, treeNode);
                        break;
                    }
                    currentNode = currentNode.getLeftChildNode();
                } else if (treeNode.compareTo(currentNode) > 0) {
                    if (currentNode.getRightChildNode() == null) {
                        setRightChildNode(currentNode, treeNode);
                        break;
                    }
                    currentNode = currentNode.getRightChildNode();
                }
            }
        }
    }

    @Override
    public TreeNode<T> getNode(T data) {
        return null;
    }

    @Override
    public void deleteNode(T data) {

    }

    private void setLeftChildNode(TreeNode<T> parentNode, TreeNode<T> childNode) {
        childNode.setParentNode(parentNode);
        parentNode.setLeftChildNode(childNode);
    }

    private void setRightChildNode(TreeNode<T> parentNode, TreeNode<T> childNode) {
        childNode.setParentNode(parentNode);
        parentNode.setRightChildNode(childNode);
    }
}
