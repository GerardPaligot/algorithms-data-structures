package com.paligot.data.structures

class Queue {
    private val list = LinkedList<Int>()

    /**
     * Time Complexity:     O(1)
     */
    fun front(): Int = list.get(0) ?: -1

    /**
     * Time Complexity:     O(N)
     */
    fun rear(): Int = list.get(list.size - 1) ?: -1

    /**
     * Time Complexity:     O(N)
     */
    fun enQueue(value: Int): Boolean {
        list.addLast(value)
        return true
    }

    /**
     * Time Complexity:     O(1)
     */
    fun deQueue(): Boolean {
        if (list.isEmpty()) return false
        list.removeFirst()
        return true
    }

    fun isEmpty(): Boolean = list.isEmpty()
}