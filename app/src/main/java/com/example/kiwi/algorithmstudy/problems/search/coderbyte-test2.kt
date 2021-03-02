package com.example.kiwi.algorithmstudy.problems.search

fun LongestWord(sen: String): String {
    // count until white space or not character
    val tmpWord = StringBuilder()
    var longest = ""
    for (c in sen) {
        if (c.isLetter()) {
            tmpWord.append(c)
        } else {
            if (longest.length < tmpWord.length) {
                longest = tmpWord.toString()
                tmpWord.clear()
            }
        }
    }
    return longest

}

fun main() {
    val str = "A goes here"
    println(LongestWord(str))
}