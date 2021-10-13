package com.paligot.algorithms.searching

import kotlin.test.Test
import kotlin.test.assertEquals

class BinarySearchTest {
    @Test
    fun binarySearchUsage() {
        val binary = BinarySearch()
        assertEquals(4, binary.search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
    }

    @Test
    fun sqrtBinarySearchUsage() {
        val binary = BinarySearch()
        assertEquals(2, binary.sqrt(4))
    }
}