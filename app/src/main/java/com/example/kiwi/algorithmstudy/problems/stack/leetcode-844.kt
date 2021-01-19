package com.example.kiwi.algorithmstudy.problems.stack

import java.util.*

// Backspace String Compare
fun backspaceCompare(S: String, T: String): Boolean {
    // if encounter '#', pop it off
    val stack = Stack<Char>()
    S.forEach { c ->
        if (c == '#') {
            if (!stack.empty()) {
                stack.pop()
            }
        } else {
            stack.push(c)
        }
    }
    val modS = stack.toString()
    stack.clear()
    T.forEach { c ->
        if (c == '#') {
            if (!stack.empty()) {
                stack.pop()
            }
        } else {
            stack.push(c)
        }
    }
    val modT = stack.toString()
    return modS == modT
}

fun main(args: Array<String>) {
    val S = "y#fo##f"
    val T = "y#f#o##f"
    println("answer: ${backspaceCompare(S, T)}")
}