package com.example.kiwi.algorithmstudy.problems

fun canThreePartsEqualSum(arr: IntArray): Boolean {
    // first part sum is sum of arr / 3
    val sumOfTotal = arr.sum()
    var firstPartSum = 0
    if (sumOfTotal == 0) {
        firstPartSum = 0
    }
    if (sumOfTotal % 3 != 0) {
        return false
    }
    firstPartSum = sumOfTotal / 3
    var sumOfNum = 0
    var partCount = 0
    arr.forEach { num ->
        sumOfNum += num
        if (firstPartSum == sumOfNum) {
            sumOfNum = 0
            partCount++
        }
    }
    return partCount >= 3
}

fun main(args: Array<String>) {
    val arr = intArrayOf(0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1)
    println("answer: ${canThreePartsEqualSum(arr)}")
}