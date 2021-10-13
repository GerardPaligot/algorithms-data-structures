package com.paligot.algorithms.sorting

import kotlin.test.Test
import kotlin.test.assertContentEquals

class SelectionSortTest {
    @Test
    fun bubbleSortUsage() {
        val selection = Selection()
        assertContentEquals(intArrayOf(1, 2, 3, 4), selection.sort(intArrayOf(2, 4, 1, 3)))
    }
}