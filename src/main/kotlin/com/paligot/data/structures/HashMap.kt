package com.paligot.data.structures

import java.util.LinkedList

/**
 * Time Complexity:     O(N / K) (N number of all possibles values, K number of buckets)
 * Space Complexity:    O(K + M) (M number of unique values that has been inserted)
 */
class HashMap(private val keyRange: Int = 1024) {
    private val buckets = Array(this.keyRange) { Bucket() }

    fun put(key: Int, value: Int) = this.buckets[hashKey(key)].update(key, value)

    fun get(key: Int) = this.buckets[hashKey(key)].get(key)

    fun remove(key: Int) = this.buckets[hashKey(key)].remove(key)

    private fun hashKey(key: Int) = key % this.keyRange

    private class Bucket {
        private val list = LinkedList<Pair<Int, Int>>()

        fun update(key: Int, value: Int) {
            var found = false
            for (item in this.list) {
                if (item.first == key) {
                    item.second = value
                    found = true
                    break
                }
            }
            if (!found) {
                this.list.addFirst(Pair(key, value))
            }
        }

        fun get(key: Int): Int {
            for (item in this.list) {
                if (item.first == key) {
                    return item.second
                }
            }
            return -1
        }

        fun remove(key: Int) {
            for (item in this.list) {
                if (item.first == key) {
                    this.list.remove(item)
                    return
                }
            }
        }
    }

    data class Pair<K, V>(var first: K, var second: V)
}