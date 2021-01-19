package com.example.kiwi.algorithmstudy.problems

import java.util.*

fun solution(board: Array<IntArray>, moves: IntArray): Int {
    var answer = 0
    val basket = arrayListOf(0)

    val rowLength = board.size
//    val colLength = board[0].size
    moves.forEach {
        val colIndex = it - 1
        println("colIndex: $colIndex")
        for (i in 0 until rowLength) {
            val number = board[i][colIndex]
            println("board[$i][$colIndex]: $number")

            // break condition 2
            if (number != 0) {
                // break condition 1
                if (number == basket.last()) {
                    basket.removeAt(basket.lastIndex)   // asis: list.remove(o: Object) Coz of the complexity of time it has not passed the test 7~10
                    answer += 2
                } else {
                    basket.add(number)
                }
                // pop value; init 0
                board[i][colIndex] = 0
                break
            }
        }
    }
//    println("basket: $basket")
    // row of board loop
    return answer
}

// another's solution
fun otherSolution(board: Array<IntArray>, moves: IntArray): Int {
    var answer = 0
    val stack = Stack<Int>()

    moves.forEach {
        for (i in board.indices) {
            val colIndex = it - 1
            if (board[i][colIndex] != 0) {
                if(stack.isNotEmpty() && stack.peek() == board[i][colIndex]) {
                    answer +=2
                    stack.pop()
                } else {
                    stack.push(board[i][colIndex])
                }
                board[i][colIndex] = 0
                break
            }
        }
    }
    return answer
}

fun main(args: Array<String>) {
    val ar = intArrayOf(0, 0, 0, 0, 0)  // row 0
    val ar2 = intArrayOf(0, 0, 1, 0, 3) // row 1
    val ar3 = intArrayOf(0, 2, 5, 0, 1)
    val ar4 = intArrayOf(4, 2, 4, 4, 2)
    val ar5 = intArrayOf(3, 5, 1, 3, 1) // ... row 4

    val board = arrayOf(ar, ar2, ar3, ar4, ar5)
    val moves = intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
    val result = solution(board, moves)

    println("result: $result")
}