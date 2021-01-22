package com.example.kiwi.algorithmstudy.problems.stringproblems

// . First Unique Character in a String
fun firstUniqChar(s: String): Int {
    // char, isNonRepeat, index
    // save to hashmap: key char, value count
    val repeatMap = linkedMapOf<Char, Int>()
    s.forEach { c ->
        repeatMap[c] = repeatMap[c]?.plus(1) ?: 1
    }
    // find the index
    s.forEachIndexed { index, c ->
        if (repeatMap[c] == 1) {
            return index
        }
    }
    return -1
}

fun main(args: Array<String>) {
    val s = "lllle"
    println("answer: ${firstUniqChar(s)}")
}