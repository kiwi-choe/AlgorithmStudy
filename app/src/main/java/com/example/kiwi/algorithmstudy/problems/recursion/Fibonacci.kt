package com.example.kiwi.algorithmstudy.problems.recursion

class Fibonacci {
    /**
     * memorization top-down way
     */
    //    fun solution(i: Int): Int {
//        return solution(i, IntArray(i + 1))
//    }
    //    fun solution(i: Int, memo: IntArray): Int {
//        if (i == 0 || i == 1) return i
//        if (memo[i] == 0) {
//            memo[i] = solution(i - 1, memo) + solution(i - 2, memo)
//        }
//        return memo[i]
//    }
    fun solution(i: Int): Int {
        if (i == 0 || i == 1) return i
        var a = 0
        var b = 1
        for (x in 2 until i) {
            val c = a + b
            a = b
            b = c
        }
        return a + b
    }
}

fun main(args: Array<String>) {
    println("answer: ${Fibonacci().solution(5)}")
}