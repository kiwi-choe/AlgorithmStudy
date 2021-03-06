package com.example.kiwi.algorithmstudy.problems.search

// https://leetcode.com/problems/missing-number/
fun missingNumber(nums: IntArray): Int {
    val missingNum = nums.size
    nums.sorted().forEachIndexed { index, num ->
        if (index != num) {
            return index
        }
    }
    return missingNum
}

fun main(args: Array<String>) {
    val nums = intArrayOf(9,6,4,2,3,5,7,0,1)
    println("${missingNumber(nums)}")
}

