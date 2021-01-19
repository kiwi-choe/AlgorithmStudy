package com.example.kiwi.algorithmstudy.problems


fun holloweenSaleSolve(price: Int, discountValue: Int, minValue: Int, budget: Int): Int {
    var totalBudget = budget
    var changingPrice = price
    var count = 0
    // end condition
    while (totalBudget > 0) {
        if (changingPrice <= minValue) {
            if (totalBudget < minValue) {
                break
            }
            println("price$minValue, totalBudget$totalBudget")
            totalBudget -= minValue
        } else {
            totalBudget -= changingPrice
            println("price$changingPrice, totalBudget$totalBudget")
            changingPrice -= discountValue
        }
        count++
    }
    return count
}

fun main(args: Array<String>) {
    val result = holloweenSaleSolve(20, 3, 6, 80)

    println("result: $result")
}