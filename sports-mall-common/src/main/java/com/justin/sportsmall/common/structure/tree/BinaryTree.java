package com.justin.sportsmall.common.structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树
 * @Author: chenjianting
 * @Date: 2019/7/25 10:11
 */
public class BinaryTree<T> extends AbstractTree<T> {

    public final static int CHILD_NODE_MAX_COUNT = 2;

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
            List<TreeNode<T>> childNodes = new ArrayList<>();
            while (true) {
                //子节点为空，插入左孩子
                if (currentNode.getChildNodes() == null) {
                    treeNode.setIndex(0);
                    treeNode.setParentNode(currentNode);
                    childNodes.add(treeNode);
                    currentNode.setChildNodes(childNodes);
                    treeNodes.add(treeNode);
                    break;
                } else if (currentNode.getChildNodes().size() < CHILD_NODE_MAX_COUNT) {
                    setParentChildNode(currentNode, treeNode);
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
            List<TreeNode<T>> childNodes = new ArrayList<>();
            while (true) {
                if (treeNode.compareTo(currentNode) < 0) {
                    if (currentNode.getChildNodes() == null) {
                        treeNode.setIndex(0);
                        treeNode.setParentNode(currentNode);
                        childNodes.add(treeNode);
                        currentNode.setChildNodes(childNodes);
                        break;
                    }
                    currentNode = currentNode.getChildNodes().get(0);
                } else if (treeNode.compareTo(currentNode) > 0) {
                    if (currentNode.getChildNodes().size() < CHILD_NODE_MAX_COUNT) {
                        setParentChildNode(currentNode, treeNode);
                        break;
                    }
                    currentNode = currentNode.getChildNodes().get(CHILD_NODE_MAX_COUNT);
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

    private void setParentChildNode(TreeNode<T> parentNode, TreeNode<T> childNode) {
        List<TreeNode<T>> childNodes = parentNode.getChildNodes();
        childNode.setIndex(CHILD_NODE_MAX_COUNT - childNodes.size());
        childNode.setParentNode(parentNode);
        childNodes.add(childNode);
        parentNode.setChildNodes(childNodes);
    }
}
