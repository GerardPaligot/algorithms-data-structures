package com.paligot.algorithms.sorting

/**
 * Time Complexity:     O(N log N) - worst O(N²)
 * Space Complexity:    O(log N)
 */
class Quick: Sort {
    fun sort(nums: IntArray): IntArray {
        if (nums.size < 2) return nums
        val pivot = nums[nums.size / 2]
        val equal = nums.filter { it == pivot }
        val less = nums.filter { it < pivot }.toIntArray()
        val greater = nums.filter { it > pivot }.toIntArray()
        return sort(less) + equal + sort(greater)
    }
}