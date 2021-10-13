package com.paligot.algorithms.sorting

/**
 * Time Complexity:     O(N Log N)
 * Space Complexity:    O(N)
 */
class Merge : Sort {
    fun sort(nums: IntArray): IntArray {
        if (nums.size <= 1) return nums
        val middle = nums.size / 2
        return merge(
            sort(nums.sliceArray(0 until middle)),
            sort(nums.sliceArray(middle until nums.size))
        )
    }

    private fun merge(left: IntArray, right: IntArray): IntArray {
        var lIndex = 0
        var rIndex = 0
        val newArray = IntArray(left.size + right.size)
        var i = 0
        while (lIndex < left.size && rIndex < right.size) {
            if (left[lIndex] <= right[rIndex]) {
                newArray[i] = left[lIndex]
                lIndex++
            } else {
                newArray[i] = right[rIndex]
                rIndex++
            }
            i++
        }
        while (lIndex < left.size) {
            newArray[i] = left[lIndex]
            lIndex++
            i++
        }
        while (rIndex < right.size) {
            newArray[i] = right[rIndex]
            rIndex++
            i++
        }
        return newArray
    }
}