package com.example.kiwi.algorithmstudy.problems.search

//https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

// brute force.
fun countNegatives(grid: Array<IntArray>): Int {
    var count = 0
    for (i in grid.indices) {
        count += grid[i].filter { it < 0 }.count()
    }
    return count
}

fun countNegatives_b_search(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) {
        return 0
    }
    var count = 0
    // loop all rows
    for (i in grid.indices) {
        count += getNegativeCountOfEachRow(grid[i])
    }
    return count
}

fun getNegativeCountOfEachRow(row: IntArray): Int {
    var count = 0
    var left = 0
    var right = row.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        // if mid is positive, go to right side
        // if mid is negative, count right side and go to left side
        if (row[mid] >= 0) {
            left = mid + 1
        } else if (row[mid] < 0) {
            count += right - mid + 1
            right = mid - 1
        }
    }
    return count
}

fun main(args: Array<String>) {
    val grid = arrayOf(intArrayOf(1, -1), intArrayOf(-1, -1))
    println("answer: ${countNegatives(grid)}")
}