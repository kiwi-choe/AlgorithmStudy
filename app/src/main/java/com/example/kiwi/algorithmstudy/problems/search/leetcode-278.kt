package com.example.kiwi.algorithmstudy.problems.search

// https://leetcode.com/problems/first-bad-version/

/* The isBadVersion API is defined in the parent class VersionControl.
      def isBadVersion(version: Int): Boolean = {} */
fun firstBadVersion(n: Int): Int {
    // binary search
    // find the first bad version among the n numbers of versions
    // there is isBadVersion() api
    var l = 1
    var r = n
    while (l <= r) {
        val mid = l + (r - l) / 2
        if (isBadVersion(mid)) {
            r = mid - 1
        } else {
            l = mid + 1
        }
    }

    return l
}

fun isBadVersion(n: Int): Boolean {
    return false
}

fun main(args: Array<String>) {
    println("answer: ${firstBadVersion(2)}")
}