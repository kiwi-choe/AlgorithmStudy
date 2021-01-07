package com.example.kiwi.algorithmstudy.hackerrank

/*
* 그리디 알고리즘을 한마디로 설명한다면 그 유명한 마시멜로 실험에 비유할 수 있겠다.
* 그리디 알고리즘을 사용한다는 것은 지금 당장 눈 앞에 있는 마시멜로를 먹는 것이다.
* 하지만 이 방법을 사용하는 것은 "기다렸다가 2개를 먹는다"라는 최적해를 보장해주지 못한다.
* 그리디 알고리즘은 부분의 최적해들의 집합이 곧 전체문제의 해답이 될 때 사용 할 수 있다.
* */

/**
 * 동전들의 관계는 배수 관계
 */
fun coin0(coinsSize: Int, coins: IntArray, k: Int): Int {
    var minCount = 0

    // init k
    var calculatingK = k
    // from last to first
    coins.reversed().forEach { coin ->
        // compare to k
        if (calculatingK > coin) {
            minCount += calculatingK / coin
            calculatingK %= coin
        }
    }
    return minCount
}

fun main(args: Array<String>) {
    val answer = coin0(10, intArrayOf(1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000), 4790)

    println("result: $answer")
}
