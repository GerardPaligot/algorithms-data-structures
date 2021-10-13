package com.paligot.algorithms.searching

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DepthFirstSearchTest {
    @Test
    fun `find if a path exists in graph`() {
        val dfs = DepthFirstSearch()
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 0)
        )
        assertTrue(dfs.validPath(3, edges, 0, 2))
        val edges2 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(3, 5),
            intArrayOf(5, 4),
            intArrayOf(4, 3)
        )
        assertFalse(dfs.validPath(6, edges2, 0, 5))
    }

    @Test
    fun `find all paths from source to target`() {
        val dfs = DepthFirstSearch()
        assertContentEquals(
            listOf(listOf(0, 1, 3), listOf(0, 2, 3)),
            dfs.allPathsSourceTarget(arrayOf(intArrayOf(1, 2), intArrayOf(3), intArrayOf(3), intArrayOf()))
        )
    }
}