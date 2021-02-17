package com.example.kiwi.algorithmstudy.problems.dynamicp

// https://leetcode.com/problems/climbing-stairs/
/**
 * f(3) = (ways of climbing 2 steps after move 1 step) + (ways of climbing 1 step after move 2 step)
 * .. f(n) = (ways of climbing n-1 steps after move 1 step) + (ways of climbing n-2 step after move 2 step)
 */
fun climbStairs(n: Int): Int {
    return climbStairs(n, IntArray(n + 1))
}

fun climbStairs(n: Int, memo: IntArray): Int {
    if (n == 1 || n == 2) return n
    if (memo[n] == 0) {
        memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo)
    }
    return memo[n]
}

fun main(args: Array<String>) {
    println("answer: ${climbStairs(4)}")
}