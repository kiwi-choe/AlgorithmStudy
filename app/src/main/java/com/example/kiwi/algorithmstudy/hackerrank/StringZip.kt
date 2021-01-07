package com.example.kiwi.algorithmstudy.hackerrank

fun solution(s: String): Int {
    var minLength = s.length

    (1..s.length / 2).forEach { zipSize ->
        val chunkedString = s.chunked(zipSize)
        var sumString = ""

        var count = 1
        val comparingList = chunkedString.subList(1, chunkedString.size) + ""
        comparingList.forEachIndexed { i, chunked ->
            if (chunkedString[i] == chunked) {
                count++
            } else {
                sumString += if (count == 1) {
                    chunkedString[i]
                } else {
                    count.zeroToEmptyString() + chunkedString[i]
                }
                count = 1
            }
        }

        minLength = minOf(minLength, sumString.length)
    }

    return minLength
}

private fun Int.zeroToEmptyString() = if (this == 0) "" else this.toString()

fun main(args: Array<String>) {
    val answer = solution("aabbaccc")
    println("answer: $answer")
}