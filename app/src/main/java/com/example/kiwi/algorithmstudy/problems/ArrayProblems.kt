package com.example.kiwi.algorithmstudy.problems

fun xorOperation(n: Int, start: Int): Int {
    var answer = 0
    (0 until n).forEach { i ->
        answer = answer.xor(start + 2 * i)
    }
    return answer
}

fun hasGroupsSizeX(deck: IntArray): Boolean {
    // set an array of count
    var countArray = IntArray(deck.size + 1) { 0 }
    deck.forEach { number ->
        countArray[number]++
    }
    // filter "count == 0" value
    countArray.filter { it != 0 }.let {
        countArray = it.toIntArray()
    }
    // if N%X == 0 & count%X == 0
    val n = deck.size
    loop@ for (x in 2..n) {
        if (n % x == 0) {
            for (count in countArray) {
                if (count % x != 0) {
                    continue@loop
                }
            }
            return true
        }
    }
    return false
}

fun arrangeCoins(n: Int): Int {
    // n - i loop
    var i = 1
    var coin = n
    while (true) {
        if (coin - i < 0) {
            return i - 1
        }
        coin -= i++
    }

    /**
     * binary search
     */
//    var left = 0
//    var right = n
//    var k: Int
//    var curr: Int
//
//    while (left <= right) {
//        k = left + (right - left / 2)
//        curr = k * k + 1 / 2
//
//        if (curr == n) return k
//
//        if (n < curr) {
//            right = k - 1
//        } else {
//            left = k + 1
//        }
//    }
//    return right
}

//fun gcd(a: Int, b: Int): Int = if (a == 0) b else gcd(b % a, a)

fun removeDuplicates(nums: IntArray): Int {
//    println(nums.distinct().toString())
//    return nums.distinct().size

    var i = 0
    for (j in 1 until nums.size) {
        if (nums[j] != nums[i]) {
            i++
            nums[i] = nums[j]
        }
    }
    return i + 1 // size = index+1
}

fun main(args: Array<String>) {
    println("answer: ${removeDuplicates(intArrayOf(1, 1, 2))}")
}