package com.example.kiwi.algorithmstudy.problems.search

import java.util.*

// https://leetcode.com/problems/kth-largest-element-in-an-array/
fun findKthLargest(nums: IntArray, k: Int): Int {
    // sort
    // return kth element
    return nums.sortedDescending()[k - 1]
}

fun findKthLargest_using_heap(nums: IntArray, k: Int): Int {
    val maxHeap = PriorityQueue { a: Int, b: Int -> b - a }
    for (num in nums) {
        maxHeap.offer(num)
    }
    // remove until k-1th
    for (i in 1 until k) {
        maxHeap.poll()
    }
    return maxHeap.poll()
}

fun main(args: Array<String>) {
    val nums = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6)
    val k = 4
    println("${findKthLargest_using_heap(nums, k)}")
}