package com.paligot.data.structures

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class QueueTest {
    @Test
    fun queueUsage() {
        val queue = Queue()
        assertTrue(queue.isEmpty())

        assertTrue(queue.enQueue(1))
        assertTrue(queue.enQueue(2))
        assertTrue(queue.enQueue(3))
        assertEquals(1, queue.front())
        assertEquals(3, queue.rear())

        assertTrue(queue.deQueue())
        assertTrue(queue.enQueue(4))
        assertEquals(2, queue.front())
        assertEquals(4, queue.rear())
    }

    @Test
    fun queueCircularUsage() {
        val queue = QueueCircular(3)
        assertTrue(queue.isEmpty())

        assertTrue(queue.enQueue(1))
        assertTrue(queue.enQueue(2))
        assertTrue(queue.enQueue(3))
        assertFalse(queue.enQueue(4))
        assertEquals(1, queue.front())
        assertEquals(3, queue.rear())
        assertTrue(queue.isFull())

        assertTrue(queue.deQueue())
        assertTrue(queue.enQueue(4))
        assertEquals(2, queue.front())
        assertEquals(4, queue.rear())
    }
}