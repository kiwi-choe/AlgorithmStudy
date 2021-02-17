package com.example.kiwi.algorithmstudy.problems.array

// https://leetcode.com/problems/maximum-subarray/
fun maxSubArray(nums: IntArray): Int {
    var maxCurrent = nums[0]
    var maxGlobal = nums[0]
    // maxOf(nums[i], nums[i] + subarray)
    for (i in 1 until nums.size) {
        maxCurrent = maxOf(nums[i], nums[i] + maxCurrent)
        maxGlobal = maxOf(maxCurrent, maxGlobal)
    }
    return maxGlobal
}

fun main(args: Array<String>) {
    val nums = intArrayOf(1)
    val solution = maxSubArray(nums)
    println("solution: $solution")
}