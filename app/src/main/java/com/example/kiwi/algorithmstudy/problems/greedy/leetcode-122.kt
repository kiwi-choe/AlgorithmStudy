package com.example.kiwi.algorithmstudy.problems.greedy

// . Best Time to Buy and Sell Stock II
fun calculate(prices: IntArray, s: Int): Int {
    // from 0 ~ lastIndex, 1 step ... n step
    if (s >= prices.size) {
        return 0
    }
    var maxProfit = 0
    for (start in s until prices.size) {
        var maxProfitCandidate = 0
        for (i in start + 1 until prices.size) {
            if (prices[start] < prices[i]) {
                val profit = prices[i] - prices[start] + calculate(prices, i + 1)
                if (profit > maxProfitCandidate) {
                    maxProfitCandidate = profit
                }
            }
        }
        if (maxProfitCandidate > maxProfit) {
            maxProfit = maxProfitCandidate
        }
    }
    return maxProfit
}

fun maxProfit(prices: IntArray): Int {
    return calculate(prices, 0)
}

fun maxProfit_peak_valley(prices: IntArray): Int {
    var i = 0
    var valley: Int
    var peak: Int
    var maxprofit = 0
    while (i < prices.size - 1) {
        while (i < prices.size - 1 && prices[i] >= prices[i + 1]) i++
        valley = prices[i]
        while (i < prices.size - 1 && prices[i] <= prices[i + 1]) i++
        peak = prices[i]
        maxprofit += peak - valley
    }
    return maxprofit
}
fun main(args: Array<String>) {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    println("answer: ${maxProfit_peak_valley(prices)}")
}