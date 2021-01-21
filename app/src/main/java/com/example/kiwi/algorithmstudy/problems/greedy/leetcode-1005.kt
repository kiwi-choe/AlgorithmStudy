package com.example.kiwi.algorithmstudy.problems.greedy

import java.util.*
import kotlin.math.min

// https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
fun largestSumAfterKNegations(A: IntArray, K: Int): Int {
    // while k != 0
    // sort
    // A[i] < 0, A[i] = -A[i], K--
    // A[i] == 0, break loop and return sum of array
    // else, sort again, A[i] = -A[i], K--
    var times = K
    while (times > 0) {
        A.sort()
        A[0] = -A.first()
        times--
    }
    return A.sum()
}

fun main(args: Array<String>) {
    val A = intArrayOf(3,-1,0,2)
    val K = 1
    println("answer: ${largestSumAfterKNegations(A, K)}")
}
