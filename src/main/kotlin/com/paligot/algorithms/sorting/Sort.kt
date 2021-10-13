package com.paligot.algorithms.sorting

interface Sort

fun Sort.swap(x: Int, y: Int, array: IntArray) {
    val temp = array[x]
    array[x] = array[y]
    array[y] = temp
}