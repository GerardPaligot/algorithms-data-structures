package com.paligot.algorithms.searching

/**
 * Time Complexity:     O(log N)
 * Space Complexity:    O(N)
 */
class DisjointSet(size: Int) {
    private val root = IntArray(size)
    private val rank = IntArray(size)

    init {
        for (i in 0 until  size) {
            root[i] = i
            rank[i] = 1
        }
    }

    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY
            } else {
                root[rootY] = rootX
                rank[rootX] += 1
            }
        }
    }

    private fun find(x: Int): Int {
        if (x == root[x]) return x
        root[x] = find(root[x])
        return root[x]
    }

    fun isConnected(x: Int, y: Int): Boolean = find(x) == find(y)
}