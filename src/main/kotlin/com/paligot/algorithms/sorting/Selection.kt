package com.paligot.algorithms.sorting

/**
 * Time Complexity:     O(N^2)
 * Space Complexity:    O(1)
 */
class Selection: Sort {
    fun sort(nums: IntArray): IntArray {
        for (i in nums.indices) {
            var indexOfMin = i
            for (j in nums.size - 1 downTo i) {
                if (nums[j] < nums[indexOfMin]) indexOfMin = j
            }
            if (i != indexOfMin) {
                swap(i, indexOfMin, nums)
            }
        }
        return nums
    }
}