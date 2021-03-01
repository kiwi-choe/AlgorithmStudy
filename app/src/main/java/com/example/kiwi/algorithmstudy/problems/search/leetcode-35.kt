package com.example.kiwi.algorithmstudy.problems.search

// https://leetcode.com/problems/search-insert-position/

fun searchInsert_brute_force(nums: IntArray, target: Int): Int {
    var index = 0
    // if found return the index
    // if not found, return the index where it would be if it were inserted in order
    // 1. brute force
    for (i in nums.indices) {
        if (nums[i] >= target) {
            return i
        }
    }
    // if not found until lastIndex, target would be inserted into the last
    index = nums.lastIndex + 1
    return index
}

fun searchInsert_b_search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        when {
            nums[mid] < target -> {
                left = mid + 1
            }
            nums[mid] > target -> {
                right = mid - 1
            }
            else -> {
                return mid
            }
        }
    }
    return left
}

fun main(args: Array<String>) {
    val nums = intArrayOf(1,3,5,6)
    val target = 2
    println("answer: ${searchInsert_b_search(nums, target)}")
}