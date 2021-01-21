package com.example.kiwi.algorithmstudy.problems.greedy

// Split a String in Balanced Strings
fun balancedStringSplit(s: String): Int {
    // r: +1, l: -1
    // if rlCount == 0, balanceStringCount++
    var balanceStringCount = 0
    var rlCount = 0
    s.forEach { c ->
        rlCount += getCountNumberByRL(c)
        if (rlCount == 0) {
            balanceStringCount++
        }
    }
    return balanceStringCount
}

fun getCountNumberByRL(c: Char): Int {
    return when (c) {
        'R' -> +1
        else -> -1
    }
}

fun main(args: Array<String>) {
    val s = "RLLLLRRRLR"
    println("answer: ${balancedStringSplit(s)}")
}