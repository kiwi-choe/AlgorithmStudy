package com.example.kiwi.algorithmstudy.problems.stack

import java.util.*

fun isValid_OtherSolution(s: String): Boolean {
    // closing bracket is key, opening bracket is value
    val bracketMaps = linkedMapOf(
        ')' to '(',
        '}' to '{',
        ']' to '['
    )
    val stack = Stack<Char>()
    s.forEach { c ->
        // if the closing bracket, pop. '#' is dummy
        if (bracketMaps.containsKey(c)) {
            val top = if (stack.isEmpty()) '#' else stack.pop()
            // and validation if not matching, return false
            if (top != bracketMaps[c]) {
                return false
            }
        } else {
            // if the opening bracket, push it
            stack.push(c)
        }
    }
    return stack.isEmpty()
}

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    s.forEach { paren ->
        if (!stack.empty()) {
            if (validParen(stack.peek(), paren)) {
                stack.pop()
                return@forEach
            }
        }
        stack.push(paren)
    }
    return stack.isEmpty()
}

fun validParen(peek: Char, paren: Char): Boolean {
    return when (peek) {
        '(' -> paren == ')'
        '{' -> paren == '}'
        '[' -> paren == ']'
        else -> false
    }
}

fun main(args: Array<String>) {
    val s = "{]}"
    println("answer: ${isValid_OtherSolution(s)}")
}