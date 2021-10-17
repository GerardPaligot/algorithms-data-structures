package com.paligot.algorithms.searching

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BreathFirstSearchTest {
    @Test
    fun `find if a path exists in graph`() {
        val bfs = BreathFirstSearch()
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 0)
        )
        assertTrue(bfs.validPath(3, edges, 0, 2))
        val edges2 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(3, 5),
            intArrayOf(5, 4),
            intArrayOf(4, 3)
        )
        assertFalse(bfs.validPath(6, edges2, 0, 5))
    }
}