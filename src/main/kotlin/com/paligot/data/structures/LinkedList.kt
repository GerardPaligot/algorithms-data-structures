package com.paligot.data.structures

class LinkedList<T> {
    private var head: Node<T>? = null
    var size: Int = 0

    /**
     * Time Complexity:     O(k) (k is the index of the element to get)
     */
    fun get(index: Int): T? = findAtIndex(index)?.value

    /**
     * Time Complexity:     O(1)
     */
    fun addFirst(value: T) = addAtIndex(0, value)
    /**
     * Time Complexity:     O(N)
     */
    fun addLast(value: T) = addAtIndex(size, value)
    /**
     * Time Complexity:     O(k)
     */
    fun addAtIndex(index: Int, value: T) {
        if (index < 0 || index > size) return
        val prev = findAtIndex(index - 1)
        val node = Node(value)
        when {
            prev == null -> this.head = node
            index == 0 -> {
                node.next = this.head
                this.head = node
            }
            else -> {
                node.next = prev.next
                prev.next = node
            }
        }
        size++
    }

    /**
     * Time Complexity:     O(1)
     */
    fun removeFirst() = removeAtIndex(0)
    /**
     * Time Complexity:     O(N)
     */
    fun removeLast() = removeAtIndex(size - 1)
    /**
     * Time Complexity:     O(k)
     */
    fun removeAtIndex(index: Int) {
        when {
            size == 0 || index > size || index < 0 -> return
            index == 0 -> this.head = this.head?.next
            else -> {
                findAtIndex(index - 1)?.let {
                    it.next = it.next?.next
                }
            }
        }
        size--
    }

    private fun findAtIndex(index: Int): Node<T>? {
        return when {
            size == 0 || index >= size -> null
            index <= 0 -> this.head
            else -> {
                var cur = this.head?.next
                repeat(index - 1) {
                    cur = cur?.next
                }
                cur
            }
        }
    }

    /**
     * Time Complexity:     O(1)
     */
    fun isEmpty(): Boolean = size == 0

    /**
     * Time Complexity:     O(k)
     */
    fun indexOf(value: T): Int {
        if (isEmpty()) return -1
        var cur = this.head
        var i = 0
        while (cur != null && cur.value != value) {
            cur = cur.next
            i++
        }
        return if (cur == null) -1 else i
    }
}

private data class Node<T>(val value: T, var next: Node<T>? = null)