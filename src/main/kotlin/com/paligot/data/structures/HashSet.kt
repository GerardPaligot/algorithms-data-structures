package com.paligot.data.structures

/**
 * Time Complexity:     O(N / K) (N number of all possibles values, K number of buckets)
 * Space Complexity:    O(K + M) (M number of unique values that has been inserted)
 */
class HashSet(private val keyRange: Int = 1024) {
    private val buckets: Array<Bucket> = Array(this.keyRange) { Bucket() }

    fun add(key: Int) = this.buckets[hashKey(this.keyRange)].insert(key)

    fun contains(key: Int): Boolean = this.buckets[hashKey(this.keyRange)].exists(key)

    fun remove(key: Int) = this.buckets[hashKey(this.keyRange)].delete(key)

    private fun hashKey(key: Int): Int = key % this.keyRange

    private class Bucket {
        private val list = LinkedList<Int>()

        fun insert(key: Int) {
            val index = list.indexOf(key)
            if (index == -1) {
                this.list.addFirst(key)
            }
        }

        fun delete(key: Int) {
            val index = list.indexOf(key)
            if (index != -1) {
                this.list.removeAtIndex(index)
            }
        }

        fun exists(key: Int): Boolean {
            val index = list.indexOf(key)
            return index != -1
        }
    }
}