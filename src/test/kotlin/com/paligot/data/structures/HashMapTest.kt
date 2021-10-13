package com.paligot.data.structures

import kotlin.test.Test
import kotlin.test.assertEquals

class HashMapTest {
    @Test
    fun hashMapUsage() {
        val map = HashMap(5)
        map.put(1, 1)
        map.put(2, 2)
        assertEquals(1, map.get(1))
        assertEquals(-1, map.get(3))

        map.put(2, 1)
        assertEquals(1, map.get(2))

        map.remove(2)
        assertEquals(-1, map.get(2))
    }
}