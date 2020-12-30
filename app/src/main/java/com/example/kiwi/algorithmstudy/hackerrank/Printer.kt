package com.example.kiwi.algorithmstudy.hackerrank

fun solution(priorities: IntArray, location: Int): Int {
    var answer = 0
    // check position of location
    val prioritiesMap = priorities.mapIndexed { index, priority ->
        if (index == location) {
            priority to true
        } else {
            priority to false
        }
    }.toMutableList()

    while (true) {
        val firstTask = prioritiesMap.first()
        if (firstTask == prioritiesMap.maxBy { it.first }) {
            prioritiesMap.removeAt(0)
            answer++
            if (firstTask.second) {
                return answer
            }
        } else {
            prioritiesMap.add(firstTask)
            prioritiesMap.removeAt(0)
        }
    }
}

fun main(args: Array<String>) {
    val priorities = intArrayOf(1, 1, 9, 2, 3, 3)
    val location = 0
    val result = solution(priorities, location)

    println("result: $result")
}