package com.paligot.data.structures

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LinkedListTest {
    @Test
    fun linkedListUsage() {
        val list = LinkedList<Int>()
        list.addFirst(1)
        list.addLast(3)
        list.addAtIndex(1, 2)
        assertEquals(2, list.get(1))
        assertEquals(2, list.get(1))

        list.removeAtIndex(1)
        assertEquals(3, list.get(1))

        list.removeFirst()
        assertEquals(3, list.get(0))

        list.removeLast()
        assertTrue(list.isEmpty())
    }
}