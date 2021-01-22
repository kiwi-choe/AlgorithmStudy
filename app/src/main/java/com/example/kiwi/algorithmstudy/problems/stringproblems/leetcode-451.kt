package com.example.kiwi.algorithmstudy.problems.stringproblems

import java.lang.StringBuilder
import java.util.*

// . Sort Characters By Frequency
fun frequencySort(s: String): String {
    // linked hashmap
    val map = linkedMapOf<Char, Int>()
    s.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }
    // sort map decrease order
    var answer = ""
    map.toList().sortedByDescending { it.second }.forEach { (c, count) ->
        for (j in 0 until count) {
            answer += c
        }
    }
    return answer
}

fun frequencySort_priorityQ(s: String): String {
    val map = hashMapOf<Char, Int>()
    s.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }

    val heap = PriorityQueue<Char>(compareByDescending { map.getOrDefault(it, 0) })
    for (c in map.keys) {
        heap.add(c)
    }
    println(heap)
    val sb = StringBuilder()
    while (heap.isNotEmpty()) {
        val c = heap.remove()
        val count = map.getOrDefault(c, 0)
        for (i in 0 until count) {
            sb.append(c)
        }
    }
    return sb.toString()
}

fun main(args: Array<String>) {
    val s = "Aabb"
    println(frequencySort_priorityQ(s))
}