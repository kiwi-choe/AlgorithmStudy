package com.example.kiwi.algorithmstudy.problems.recursion

// https://leetcode.com/problems/n-th-tribonacci-number/
//fun tribonacci(n: Int): Int {
//    if (n == 0) return 0
//    if (n == 1 || n == 2) return 1
//    return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3)
//}

//fun tribonacci(n: Int): Int {
//    return tribonacci(n, IntArray(n + 1))
//}
//
//fun tribonacci(n: Int, memo: IntArray): Int {
//    if (n == 0) return 0
//    if (n == 1 || n == 2) return 1
//
//    if (memo[n] == 0) {
//        memo[n] = tribonacci(n - 1, memo) + tribonacci(n - 2, memo) + tribonacci(n - 3, memo)
//    }
//    return memo[n]
//}

fun tribonacci(n: Int): Int {
    if (n == 0) return 0
    if (n == 1 || n == 2) return 1
    var a = 0
    var b = 1
    var c = 1
    for (i in 3 until n) {
        val sum = a + b + c
        a = b
        b = c
        c = sum
    }
    return a + b + c
}

fun main(args: Array<String>) {
    println("answer: ${tribonacci(4)}")
}