package com.example.kiwi.algorithmstudy.problems.array

// https://leetcode.com/problems/majority-element/

// 1. Brute force: Time O(n^2), Space O(1)
fun majorityElement(nums: IntArray): Int {
    val majorityArrSize = nums.size / 2

    nums.forEach {num ->
        var count = 0
        nums.forEach {curNum ->
            if(curNum == num) {
                count++
            }
        }

        if(count > majorityArrSize) {
            return num
        }
    }

    return -1
}
// 2. Sorting
fun majorityElement_sorting(nums: IntArray): Int {
    val majorityArrSize = nums.size / 2
    nums.sort()
    return nums[majorityArrSize]
}

fun main(args: Array<String>) {
    val nums = intArrayOf(2,2,1,1,1,2,2)
    println("solution: ${majorityElement_sorting(nums)}")
}