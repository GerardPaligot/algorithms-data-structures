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

    fun sort2(nums: IntArray): IntArray {
        quicksort(nums, 0, nums.size - 1)
        return nums
    }

    private fun quicksort(array: IntArray, left: Int, right: Int) {
        val index = partition(array, left, right)
        if (left < index - 1) {
            quicksort(array, left, index - 1)
        }
        if (index < right) {
            quicksort(array, index, right)
        }
    }

    private fun partition(array: IntArray, l: Int, r: Int): Int {
        var left = l
        var right = r
        val pivot = array[(right + left) / 2]
        while (left <= right) {
            // find first left should be on the right side
            while (array[left] < pivot) left++
            // find the first right should be on the left side
            while (array[right] > pivot) right--
            // check if we found a swap
            if (left <= right) {
                swap(left, right, array)
                left++
                right--
            }
        }
        return left
    }
}