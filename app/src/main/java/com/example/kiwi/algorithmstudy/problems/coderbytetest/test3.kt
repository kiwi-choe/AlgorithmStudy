package com.example.kiwi.algorithmstudy.problems.coderbytetest

import java.util.*


fun isOccupied(desk: Int, occupiedDesks: Set<Int>, totalDesks: Int): Boolean {
    return desk > totalDesks || occupiedDesks.contains(desk)
}

fun SeatingStudents(arr: Array<Int>): Int {
    val totalDesks: Int = arr[0]
    val occupiedDesks: MutableSet<Int> = HashSet()
    for (i in 1 until arr.size) {
        occupiedDesks.add(arr.get(i))
    }
    println("totalDesks: $totalDesks")
    println("occupiedDesks: $occupiedDesks")
    var count = 0
    for (currentDesk in 1 until totalDesks) {
        if (isOccupied(currentDesk, occupiedDesks, totalDesks)) {
            continue
        }
        if (currentDesk % 2 != 0) {
            val sideDesk = currentDesk + 1
            if (!isOccupied(sideDesk, occupiedDesks, totalDesks)) {
                count++
            }
        }
        val belowDesk = currentDesk + 2
        if (!isOccupied(belowDesk, occupiedDesks, totalDesks)) {
            count++
        }
    }
    return count
}


fun main() {
    println(SeatingStudents(arrayOf(6, 4)))
}