package com.paligot.algorithms.sorting

import kotlin.test.Test
import kotlin.test.assertContentEquals

class MergeSortTest {
    @Test
    fun mergeSortUsage() {
        val merge = Merge()
        assertContentEquals(intArrayOf(1, 2, 3, 4), merge.sort(intArrayOf(2, 4, 1, 3)))
    }
}