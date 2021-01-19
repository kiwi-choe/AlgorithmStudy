package com.example.kiwi.algorithmstudy.problems.stack

class MinStack() {

    /** initialize your data structure here. */
    val stack = mutableListOf<Int>()

    fun push(x: Int) {
        stack.add(x)
    }

    fun pop() {
        stack.removeAt(stack.size - 1)
    }

    fun top(): Int {
        return stack[stack.size - 1]
    }

    fun getMin(): Int {
        var min = 0
        stack.forEach {
            min = minOf(it, min)
        }
        return min
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */