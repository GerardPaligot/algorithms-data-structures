package com.paligot.data.structures

/**
 * Time Complexity:     O(1)
 * Space Complexity:    O(N)
 */
class QueueCircular(private val maxSize: Int) {
    private val array = IntArray(maxSize)
    private var head: Int = 0
    private var tail: Int = 0
    private var size: Int = 0

    fun front(): Int = if (isEmpty()) -1 else this.array[this.head]

    fun rear(): Int {
        val index = if (this.tail - 1 < 0) this.tail - 1 + this.maxSize else this.tail - 1
        return if (isEmpty()) -1 else this.array[index]
    }

    fun enQueue(value: Int): Boolean {
        if (isFull()) return false
        array[this.tail] = value
        this.tail = (this.tail + 1) % this.maxSize
        this.size++
        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) return false
        this.head = (this.head + 1) % this.maxSize
        this.size--
        return true
    }

    fun isEmpty(): Boolean = this.size == 0

    fun isFull(): Boolean = this.size == this.maxSize
}