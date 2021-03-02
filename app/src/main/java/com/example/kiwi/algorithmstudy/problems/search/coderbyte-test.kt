package com.example.kiwi.algorithmstudy.problems.search

fun FindIntersection(strArr: Array<String>): String {

    val arr1 = strArr[0].split(", ").map { it.toInt() }
    val arr2 = strArr[1].split(", ").map { it.toInt() }

    val answer = arrayListOf<Int>()
    for (n1 in arr1) {
        for (n2 in arr2) {
            if (n1 == n2) {
                answer.add(n1)
                break
            }
        }
    }
    return if (answer.isEmpty()) "false" else answer.joinToString(",")
}

fun main(args: Array<String>) {
    val arr = arrayOf("1, 3, 4, 7, 13", "1, 2, 4, 13, 15")
    println(FindIntersection(arr))
}