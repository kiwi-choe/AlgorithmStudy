package com.example.kiwi.algorithmstudy.problems.greedy

// . Number Of Rectangles That Can Form The Largest Square
fun countGoodRectangles(rectangles: Array<IntArray>): Int {
    // min of intarray
//    var maxLen = 0
//    rectangles.forEach { rect ->
//        maxLen = maxOf(maxLen, rect.min() ?: 0)
//    }
//    var count = 0
//    rectangles.forEach { rect ->
//        if (maxLen == rect.min()) {
//            count++
//        }
//    }
//    return count

    var maxLen = 0
    var count = 0
    rectangles.forEach { rect ->
        val side = rect.min() ?: 0
        if (side > maxLen) {
            count = 1
            maxLen = side
        } else if (side == maxLen) {
            count++
        }
    }
    return count
}

fun main(args: Array<String>) {
    val rectangles =
        arrayOf(intArrayOf(5, 8), intArrayOf(3, 9), intArrayOf(5, 12), intArrayOf(16, 5))
    println("answer: ${countGoodRectangles(rectangles)}")
}