package com.example.kiwi.algorithmstudy.problems.greedy

import java.util.*

// https://leetcode.com/problems/last-stone-weight/
fun lastStoneWeight(stones: IntArray): Int {
    // choose heaviest 2 stones (from lastindex)
    // if x == y, remove both
    // else if y > x, remain y-x, remove x
    val list = stones.toMutableList()
    while (list.size > 1) {
        list.sortDescending().also {
            if (list.first() - list[1] == 0) {
                list.removeAt(0)
                list.removeAt(0)
            } else {
                list[0] = list.first() - list[1]
                list.removeAt(1)
            }
        }
    }
    return if (list.isEmpty()) 0 else list.first()
}

fun lastStoneWeight_priority_queue(stones: IntArray): Int {
    // choose heaviest 2 stones
    // if x == y, remove both
    // else if y > x, remain y-x, remove x
    val pq = PriorityQueue<Int>(reverseOrder())
    stones.forEach {
        pq.add(it)
    }

    while (pq.size > 1) {
        val y = pq.poll()
        val x = pq.poll()
        if (y - x != 0) {
            pq.add(y - x)
        }
    }
    return if(pq.isEmpty()) 0 else pq.peek()
}

fun main(args: Array<String>) {
    val stones = intArrayOf(2,2)
    println("answer: ${lastStoneWeight_priority_queue(stones)}")
}