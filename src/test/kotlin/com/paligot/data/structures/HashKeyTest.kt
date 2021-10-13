package com.paligot.data.structures

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class HashKeyTest {
    @Test
    fun hashKeyUsage() {
        val set = HashSet(5)
        set.add(1)
        set.add(2)
        assertTrue(set.contains(1))
        assertFalse(set.contains(3))

        set.add(2)
        assertTrue(set.contains(2))

        set.remove(2)
        assertFalse(set.contains(2))
    }
}