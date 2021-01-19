package com.example.kiwi.algorithmstudy.problems

// Complete the sockMerchant function below.
fun sockMerchant(n: Int, ar: Array<Int>): Int {
    val socksOfColors = hashMapOf<Int, Int>()
    ar.forEach { color ->
        socksOfColors[color] = socksOfColors[color]?.plus(1) ?: 1
    }

    var result = 0
    socksOfColors.forEach {
        result += it.value/2
    }
    return result
}

fun main(args: Array<String>) {
    val ar = intArrayOf(10, 20, 20, 10, 10, 30, 50, 10, 20)
    val ar1: Array<Int> = ar.toTypedArray()
    val result = sockMerchant(9, ar1)

    println("result: $result")
}