package com.example.kiwi.algorithmstudy.problems.stack

import java.util.*

// Crawler Log Folder
fun minOperations(logs: Array<String>): Int {
    // "../": pop
    // "./": same
    // else: push
    val stack = Stack<String>()
    logs.forEach { dir ->
        when(dir) {
            "../" -> {
                if(!stack.empty()) {
                    stack.pop()
                }
            }
            "./" -> return@forEach
            else -> stack.push(dir)
        }
    }
    return stack.size
}

fun main(args: Array<String>) {
    val logs = arrayOf("d1/", "d2/", "../", "d21/", "./")
    println("answer: ${minOperations(logs)}")
}