package com.paligot.data.structures

class Stack {
    private val list = LinkedList<Int>()

    /**
     * Time Complexity:     O(N)
     */
    fun push(value: Int) = list.addLast(value)

    /**
     * Time Complexity:     O(N)
     */
    fun pop(): Boolean {
        if (isEmpty()) return false
        list.removeLast()
        return true
    }

    /**
     * Time Complexity:     O(N)
     */
    fun peek(): Int = list.get(list.size - 1) ?: -1

    /**
     * Time Complexity:     O(1)
     */
    fun isEmpty(): Boolean = list.isEmpty()

    /**
     * Time Complexity:     O(N)
     */
    fun getMin(): Int {
        if (list.isEmpty()) return -1
        var min = list.get(0)!!
        for (i in 1 until list.size) {
            val item = list.get(i)
            if (item != null && item < min) {
                min = item
            }
        }
        return min
    }
}