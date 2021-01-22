package com.example.kiwi.algorithmstudy.problems.stringproblems

import java.lang.StringBuilder
import java.util.*

// https://leetcode.com/problems/sort-array-by-increasing-frequency/
fun frequencySort(nums: IntArray): IntArray {
    // increasing order based on the frequency of values
    val freq = hashMapOf<Int, Int>()
    nums.forEach {
        freq[it] = freq.getOrDefault(it, 0) + 1
    }
    // if multiple values have the same freq, sort them in dec order
    val heap = PriorityQueue(compareBy<Int> { freq.getOrDefault(it, 0) }.thenByDescending { it })
    for (num in freq.keys) {
        heap.add(num)
    }
    val answer = arrayListOf<Int>()
    while (heap.isNotEmpty()) {
        val num = heap.poll()
        val count = freq.getOrDefault(num, 0)
        for (i in 0 until count) {
            answer.add(num)
        }
    }
    return answer.toIntArray()
}

fun main(args: Array<String>) {
    val nums = intArrayOf(-1, 1, -6, 4, 5, -6, 1, 4, 1)
    println(frequencySort(nums).contentToString())
}
