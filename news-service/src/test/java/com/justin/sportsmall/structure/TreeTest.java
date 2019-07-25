package com.justin.sportsmall.structure;

import com.justin.sportsmall.NewsServiceApplicationTests;
import com.justin.sportsmall.common.algorithm.BinaryTreeTraverse;
import com.justin.sportsmall.common.structure.tree.BinaryTree;
import com.justin.sportsmall.common.structure.tree.TreeNode;
import org.junit.Test;

/**
 * @Author: chenjianting
 * @Date: 2019/7/25 18:36
 */
public class TreeTest extends NewsServiceApplicationTests {

    @Test
    public void sortedTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        TreeNode<Integer> root = new TreeNode<>(5);
        tree.sortedInsertNode(root);
        int[] array = {6, 7, 4, 3, 9, 2, 8, 1, 10};
        for (int i = 0; i < array.length; i++) {
            System.out.println("data value: "+ array[i]);
            TreeNode<Integer> treeNode = new TreeNode<>(array[i]);
            tree.sortedInsertNode(treeNode);
        }
        BinaryTreeTraverse.recursionBeforeOrder(tree.rootNode);
        BinaryTreeTraverse.recursionInOrder(tree.rootNode);
        BinaryTreeTraverse.recursionAfterOrder(tree.rootNode);
    }
}
