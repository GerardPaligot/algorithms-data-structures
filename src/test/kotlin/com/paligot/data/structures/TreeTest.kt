package com.paligot.data.structures

import kotlin.test.*

class TreeTest {
    @Test
    fun treePreorderUsage() {
        val node = TreeNode(1, null, TreeNode(2, TreeNode(3), null))
        assertContentEquals(
            listOf(1, 2, 3),
            node.preorder()
        )
    }

    @Test
    fun treeInorderUsage() {
        val node = TreeNode(1, null, TreeNode(2, TreeNode(3), null))
        assertContentEquals(
            listOf(1, 3, 2),
            node.inorder()
        )
    }

    @Test
    fun treePostorderUsage() {
        val node = TreeNode(1, null, TreeNode(2, TreeNode(3), null))
        assertContentEquals(
            listOf(3, 2, 1),
            node.postorder()
        )
    }

    @Test
    fun treeLevelorderUsage() {
        val node = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
        assertContentEquals(
            listOf(listOf(3), listOf(9, 20), listOf(15, 7)),
            node.levelorder()
        )
    }

    @Test
    fun treeMaxUsage() {
        val node = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
        assertEquals(3, node.max())
    }

    @Test
    fun treePathSumUsage() {
        val node = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
        assertTrue(node.hasPathSum(30))
        assertFalse(node.hasPathSum(100))
    }

    @Test
    fun constructBinaryTreeFromInorderAndPostorderTraversal() {
        val node = createTreeNodePostorder(intArrayOf(9, 3, 15, 20, 7), intArrayOf(9, 15, 7, 20, 3))
        assertContentEquals(
            listOf(listOf(3), listOf(9, 20), listOf(15, 7)),
            node?.levelorder()
        )
    }

    @Test
    fun constructBinaryTreeFromInorderAndPreorderTraversal() {
        val node = createTreeNodePreorder(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7))
        assertContentEquals(
            listOf(listOf(3), listOf(9, 20), listOf(15, 7)),
            node?.levelorder()
        )
    }
}