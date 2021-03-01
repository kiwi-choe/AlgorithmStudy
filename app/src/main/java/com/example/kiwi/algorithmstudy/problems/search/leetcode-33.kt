package com.example.kiwi.algorithmstudy.problems.search

// https://leetcode.com/problems/search-in-rotated-sorted-array/
fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.lastIndex
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) {
            return mid
        } else if (nums[left] <= nums[mid]) {
            // left side is sorted
            if (target >= nums[left] && target < nums[mid]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        } else {
            // right side is sorted
            if (target <= nums[right] && target > nums[mid]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
    }

    return -1
}

fun main(args: Array<String>) {
    val nums = intArrayOf(3,1)
    val target = 1
    println("answer: ${search(nums, target)}")
}