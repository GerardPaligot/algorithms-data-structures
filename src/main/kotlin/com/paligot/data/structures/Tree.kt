package com.paligot.data.structures

class TreeNode<T>(
    val value: T,
    var left: TreeNode<T>? = null,
    var right: TreeNode<T>? = null
)

/**
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
fun <T> TreeNode<T>.preorder(): List<T> {
    fun recursive(node: TreeNode<T>?, array: MutableList<T>) {
        if (node == null) return
        array.add(node.value)
        recursive(node.left, array)
        recursive(node.right, array)
    }

    val list = mutableListOf<T>()
    recursive(this, list)
    return list
}

/**
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
fun <T> TreeNode<T>.inorder(): List<T> {
    fun recursive(node: TreeNode<T>?, array: MutableList<T>) {
        if (node == null) return
        recursive(node.left, array)
        array.add(node.value)
        recursive(node.right, array)
    }

    val list = mutableListOf<T>()
    recursive(this, list)
    return list
}

/**
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
fun <T> TreeNode<T>.postorder(): List<T> {
    fun recursive(node: TreeNode<T>?, array: MutableList<T>) {
        if (node == null) return
        recursive(node.left, array)
        recursive(node.right, array)
        array.add(node.value)
    }

    val list = mutableListOf<T>()
    recursive(this, list)
    return list
}

/**
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
fun <T> TreeNode<T>.levelorder(): List<List<T>> {
    fun recursive(node: TreeNode<T>?, array: MutableList<MutableList<T>>, level: Int): List<List<T>> {
        if (node == null) return array
        if (array.size < level + 1) array.add(mutableListOf(node.value))
        else array[level].add(node.value)
        if (node.left != null) recursive(node.left, array, level + 1)
        if (node.right != null) recursive(node.right, array, level + 1)
        return array
    }

    return recursive(this, mutableListOf(), 0)
}

/**
 * Time Complexity:     O(N)
 * Space Complexity:    O(log N)
 */
fun <T> TreeNode<T>?.max(): Int {
    if (this == null) return 0
    val lMax = left.max()
    val rMax = right.max()
    return kotlin.math.max(lMax, rMax) + 1
}

/**
 * Time Complexity:     O(N)
 * Space Complexity:    O(log N)
 */
fun TreeNode<Int>.hasPathSum(targetSum: Int): Boolean {
    fun recursive(node: TreeNode<Int>, sum: Int, targetSum: Int): Boolean {
        if (node.left != null && recursive(node.left!!, sum + node.value, targetSum)) return true
        if (node.right != null && recursive(node.right!!, sum + node.value, targetSum)) return true
        return (sum + node.value) == targetSum
    }

    return recursive(this, 0, targetSum)
}

/**
 * Time Complexity:     O(N)
 * Space Complexity:    O(N) + O(H) ~ O(N)
 */
fun createTreeNodePostorder(inorder: IntArray, postorder: IntArray): TreeNode<Int>? {
    val inorderValToIdx = HashMap<Int, Int>().apply {
        for (i in inorder.indices) this[inorder[i]] = i
    }
    fun dfs(idxPostorder: Int, idxStartInorder: Int, idxEndInorder: Int): TreeNode<Int>? {
        if (idxPostorder > 0 || idxStartInorder > idxEndInorder) return null
        val rootValue = postorder[idxPostorder]
        val root = TreeNode(rootValue)
        val idxRoot = inorderValToIdx[rootValue]!!
        root.right = dfs(idxPostorder - 1, idxRoot + 1, idxEndInorder)
        root.left = dfs(idxPostorder - (idxEndInorder - idxRoot + 1), idxStartInorder, idxRoot - 1)
        return root
    }
    return dfs(inorder.size - 1, 0, inorder.size - 1)
}

/**
 * Time Complexity:     O(N)
 * Space Complexity:    O(N) + O(H) ~ O(N)
 */
fun createTreeNodePreorder(preorder: IntArray, inorder: IntArray): TreeNode<Int>? {
    val inorderValToIdx = HashMap<Int, Int>().apply {
        for (i in inorder.indices) this[inorder[i]] = i
    }
    var idxPreorder = 0
    fun dfs(idxStartInorder: Int, idxEndInorder: Int): TreeNode<Int>? {
        if (idxStartInorder > idxEndInorder) return null
        val rootValue = preorder[idxPreorder++]
        val root = TreeNode(rootValue)
        val idxRoot = inorderValToIdx[rootValue]!!
        root.left = dfs(idxStartInorder, idxRoot - 1)
        root.right = dfs(idxRoot + 1, idxEndInorder)
        return root
    }
    return dfs( 0, preorder.size - 1)
}
