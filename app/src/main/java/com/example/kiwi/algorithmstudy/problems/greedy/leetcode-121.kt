package com.example.kiwi.algorithmstudy.problems.greedy

// . Best Time to Buy and Sell Stock
fun maxProfit_I(prices: IntArray): Int {

    // Time limit exceeded
//    for (i in prices.indices) {
//        for (j in i + 1 until prices.size) {
//            if (prices[j] > prices[i]) {
//                val profit = prices[j] - prices[i]
//                if (profit > max) {
//                    max = profit
//                }
//            }
//        }
//    }
    var max = 0
    var min = Integer.MAX_VALUE
    // we need to find max(prices[j] - prices[i]), for every i and j such that j > i.
    for (i in 0 until prices.size - 1) {
        min = minOf(prices[i], min)
        max = maxOf(prices[i + 1] - min, max)
    }
    return if (max == -1) 0 else max
}

fun main(args: Array<String>) {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    println("answer: ${maxProfit_I(prices)}")
}
