package com.example.kiwi.algorithmstudy.hackerrank

//fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
//    val sameValues = lost.intersect(reserve.toList())
//    val lostList = lost.toMutableList().apply { removeAll(sameValues) }
//    val reserveList = reserve.toMutableList().apply { removeAll(sameValues) }
//
//    // lost loop, meet lost value, check left, right
//    var numOfLostStudent = lost.size - sameValues.size
//    var reserveArray = reserve
//    lostList.forEach { lostNum ->
//        val left = lostNum - 1
//        val right = lostNum + 1
//
//        reserveArray = reserveList.toIntArray()
//        reserveArray.forEachIndexed { i, reserveNum ->
//            if(reserveNum < left || reserveNum > right) {
//                return@forEach
//            }
//            if (reserveNum == left || reserveNum == right) {
//                numOfLostStudent--
//                reserveList.removeAt(i)
//                return@forEach
//            }
//        }
//    }
//    return n - numOfLostStudent
//}

fun otherSolution(n: Int, lost: IntArray, reserve: IntArray): Int {
    var answer = n
    // LinkedHashSet
    val lostSet = lost.toSet() - reserve.toSet()
    val reserveSet = (reserve.toSet() - lost.toSet()) as MutableSet

    lostSet.forEach {
        when {
            it + 1 in reserveSet -> reserveSet.remove(it + 1)
            it - 1 in reserveSet -> reserveSet.remove(it - 1)
            else -> answer--
        }
    }
    return answer
}

fun main(args: Array<String>) {
    val n = 5
    val lost = intArrayOf(1, 2, 4, 5)
    val reserve = intArrayOf(2, 3)
    val result = otherSolution(n, lost, reserve)

    println("result: $result")
}