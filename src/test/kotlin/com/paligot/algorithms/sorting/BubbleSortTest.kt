package com.paligot.algorithms.sorting

import kotlin.test.Test
import kotlin.test.assertContentEquals

class BubbleSortTest {
    @Test
    fun bubbleSortUsage() {
        val bubble = Bubble()
        assertContentEquals(intArrayOf(1, 2, 3, 4), bubble.sort(intArrayOf(2, 4, 1, 3)))
    }
}