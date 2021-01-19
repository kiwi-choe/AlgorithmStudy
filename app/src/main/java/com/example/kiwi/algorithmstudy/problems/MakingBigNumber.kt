package com.example.kiwi.algorithmstudy.problems

fun solution(number: String, k: Int): String {

    val maxNumberList = arrayListOf<Char>()
    var maxNumberIndex = 0
    var extraCntForMaxNumber = number.length - k
    while (extraCntForMaxNumber != 0) {
        println("maxNumberIndex: $maxNumberIndex")
//        println("number.length - extraCntForMaxNumber: ${number.length - extraCntForMaxNumber}")
        // if max is found,
        val string = number.substring(maxNumberIndex..number.length - extraCntForMaxNumber)
        println("string: $string")
        string.max()
            ?.also { maxNum ->
                println("maxNum: $maxNum")
                // - update maxNumberIndex value
                maxNumberIndex += string.indexOf(maxNum) + 1
                // - and add a max item to answer list
                maxNumberList.add(maxNum)
            }
        extraCntForMaxNumber--
    }
    return maxNumberList.joinToString("")
}

fun solution제출용(number: String, k: Int): String {
    val maxNumberList = arrayListOf<Char>()
    var left = 0
    var extraCntForMaxNumber = number.length - k
    while (extraCntForMaxNumber != 0) {
        // if max is found,
        val string = number.substring(left..number.length - extraCntForMaxNumber)
        string.max()
            ?.also { maxNum ->
                // - update maxNumberIndex value
                left += string.indexOf(maxNum) + 1
                // - and add a max item to answer list
                maxNumberList.add(maxNum)
            }
        extraCntForMaxNumber--
    }
    return maxNumberList.joinToString("")
}

fun othersolution(number: String, k: Int): String {
    var answer = ""
    var stringSize = number.length - k
    var index = 0
    val list = mutableListOf<Char>()
    while (stringSize > 0) {
        val string = number.substring(index, number.length - (stringSize - 1))
        string.max()?.let { max ->
            index += string.indexOf(max) + 1
            list.add(max)
        }
        stringSize -= 1
    }
    answer = list.joinToString("")
    return answer
}

fun main(args: Array<String>) {
    val answer = solution("4177252841", 4)
    println("answer: $answer")
}