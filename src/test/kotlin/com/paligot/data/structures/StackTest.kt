package com.paligot.data.structures

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class StackTest {
    @Test
    fun stackUsage() {
        val stack = Stack()
        stack.push(-2)
        stack.push(0)
        stack.push(-3)

        assertEquals(-3, stack.getMin())

        assertTrue(stack.pop())
        assertEquals(0, stack.peek())
        assertEquals(-2, stack.getMin())
    }
}