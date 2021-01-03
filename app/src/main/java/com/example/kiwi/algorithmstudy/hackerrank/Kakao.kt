package com.example.kiwi.algorithmstudy.hackerrank

import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*


/*
 * Complete the 'solution' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun solution1(arr: Array<Int>): Int {
    // find max
    // left의 min과의 차
    val max = arr.max() ?: 0
    var maxIndex = arr.indexOf(max)
    if (maxIndex == 0) return -1

    // max의 오른쪽배열에서 find max
    // left의 min과의 차 ..loop
    var maxOfMax = 0
    var start = 0
    while (maxIndex < arr.size) {
        if (start >= maxIndex) {
            return maxOfMax
        }

        val diffMax = diffMaxWithMin(arr.sliceArray(start..maxIndex))
        if (maxOfMax < diffMax) {
            maxOfMax = diffMax
        }
        start = maxIndex + 1

        val tmpArray = arr.sliceArray(start until arr.size)
        maxIndex = arr.indexOf(tmpArray.max())
    }
    return maxOfMax
}

fun diffMaxWithMin(arr: Array<Int>): Int {
    return arr.last() - (arr.min() ?: 0)
}

fun solution(n: Long): String {
    // init colArray
    val colArray = CharArray(26)
    for (i in 0..colArray.size) {
        colArray[i] = (96+i).toChar()
        println(colArray[i])
    }

    // n = 26* x + y
    // n < 702, row:1
    // n / 702, row: result+1
    // n % 702, col: array[result]

    return colArray.toString()
}

fun main(args: Array<String>) {
//    val n = readLine()!!.trim().toLong()

    val result = solution(10)

    println(result)
}

//fun main(args: Array<String>) {
//    val arrCount = readLine()!!.trim().toInt()
//
//    val arr = Array<Int>(arrCount, { 0 })
//    for (i in 0 until arrCount) {
//        val arrItem = readLine()!!.trim().toInt()
//        arr[i] = arrItem
//    }

//    val arr = arrayOf(7, 9, 5, 6, 3, 2)
//    val result = solution(arr)
//
//    println(result)
//}