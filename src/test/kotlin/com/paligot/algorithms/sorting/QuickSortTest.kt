package com.paligot.algorithms.sorting

import kotlin.test.Test
import kotlin.test.assertContentEquals

class QuickSortTest {
    @Test
    fun quickSortUsage() {
        val quick = Quick()
        assertContentEquals(intArrayOf(1, 2, 3, 4), quick.sort(intArrayOf(2, 4, 1, 3)))
    }

    @Test
    fun quickSort2Usage() {
        val quick = Quick()
        assertContentEquals(intArrayOf(1, 2, 3, 4), quick.sort2(intArrayOf(2, 4, 1, 3)))
    }
}