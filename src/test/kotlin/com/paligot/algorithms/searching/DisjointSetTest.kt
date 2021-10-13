package com.paligot.algorithms.searching

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DisjointSetTest {
    @Test
    fun disjointSetUsage() {
        val disjointSet = DisjointSet(10)
        disjointSet.union(1, 2)
        disjointSet.union(2, 5)
        disjointSet.union(5, 6)
        disjointSet.union(6, 7)
        disjointSet.union(3, 8)
        disjointSet.union(3, 9)
        assertTrue(disjointSet.isConnected(1, 5))
        assertTrue(disjointSet.isConnected(5, 7))
        assertFalse(disjointSet.isConnected(4, 9))

        disjointSet.union(9, 4)
        assertTrue(disjointSet.isConnected(4, 9))
    }
}