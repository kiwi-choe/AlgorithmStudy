package com.example.kiwi.algorithmstudy.problems.coderbytetest

import java.util.*

fun Calculator(str: String): String {

    // infix to postfix
    val postfix = getPostFix(str)
    println("postfix: $postfix")
    // calculate postfix
    val stack = Stack<Int>()
    for (token in postfix) {
        if (token.isDigit()) {
            stack.push(token.toString().toInt())
        } else {
            if(stack.isNotEmpty()) {
                val num2 = stack.pop()
                val num1 = stack.pop()
                stack.push(calculateByOpType(token, num1, num2))
            }
        }
    }
    return if(stack.isNotEmpty()) stack.pop().toString() else ""
}

fun calculateByOpType(token: Char, num1: Int, num2: Int): Int {
    return when (token) {
        '+' -> num1 + num2
        '-' -> num1 - num2
        '/' -> num1 / num2
        '*' -> num1 * num2
        else -> 0
    }
}

fun isPrior(token: Char): Int {
    return when (token) {
        '+', '-' -> 0
        '/', '*' -> 1
        '(' -> 2
        ')' -> 3
        else -> 4
    }
}

fun getPostFix(infix: String): String {
    val RIGHT_PAREN = ')'
    val LEFT_PAREN = '('
    val stack = Stack<Char>()
    val postfix = StringBuilder()
    var hasRightParen = false
    for (c in infix) {
        if (c.isDigit()) {
            postfix.append(c)
        } else if (c == RIGHT_PAREN) {
            // pop until left paren
            while (stack.isNotEmpty()) {
                val popped = stack.pop()
                if (popped == LEFT_PAREN) {
                    break
                } else {
                    postfix.append(popped)
                }
            }
            hasRightParen = true
        } else {
            if(c == LEFT_PAREN && hasRightParen) {
                stack.push('*')
                hasRightParen = false
                continue
            }
            // check the priority
            while (stack.isNotEmpty() && isPrior(c) < isPrior(stack.peek())) {
                val popped = stack.pop()
                if (popped != LEFT_PAREN) {
                    postfix.append(popped)
                }
            }
            stack.push(c)
        }
    }

    while (stack.isNotEmpty()) {
        val popped = stack.pop()
        if (popped != LEFT_PAREN) {
            postfix.append(popped)
        }
    }
    return postfix.toString()
}

fun main() {
    val str = "1*2"
    println(Calculator(str))
}