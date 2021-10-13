package com.paligot.algorithms.searching

/**
 * Time Complexity:     O(log N)
 * Space Complexity:    O(1)
 */
class BinarySearch {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val pivot = (right + left) / 2
            if (nums[pivot] == target) return pivot
            if (target < nums[pivot]) right = pivot - 1
            else left = pivot + 1
        }
        return -1
    }

    fun sqrt(x: Int): Int {
        if (x < 2) return x
        var left = 2
        var right = x / 2
        while (left <= right) {
            val pivot = (right + left) / 2
            val num = (pivot * pivot).toLong()
            if (num > x) right = pivot - 1
            else if (num < x) left = pivot + 1
            else return pivot
        }
        return -1
    }
}