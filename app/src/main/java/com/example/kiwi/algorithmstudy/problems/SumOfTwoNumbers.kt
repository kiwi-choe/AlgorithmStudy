package com.example.kiwi.algorithmstudy.problems

fun solution(numbers: IntArray): IntArray {
    val intSet: MutableSet<Int> = mutableSetOf()
    for (i in numbers.indices) {
        for (j in i + 1 until numbers.size) {
            intSet.add(numbers[i] + numbers[j])
        }
    }
    println("intSet: $intSet")
    println("sorted intSet: ${intSet.sorted()}")
    return intSet.sorted().toIntArray()
    // ref. list answers.distinct().toIntArray()
}

fun main(args: Array<String>) {
    val answer = solution(intArrayOf(2, 1, 3, 4, 1))

    println("result: $answer")
}