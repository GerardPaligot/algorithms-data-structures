package com.paligot.algorithms.sorting

/**
 * Time Complexity:     O(N^2)
 * Space Complexity:    O(1)
 */
class Bubble: Sort {
    fun sort(nums: IntArray): IntArray {
        var swap = true
        while (swap) {
            swap = false
            for (i in 0 until nums.size - 1) {
                if (nums[i] > nums[i + 1]) {
                    swap(i, i + 1, nums)
                    swap = true
                }
            }
        }
        return nums
    }
}
