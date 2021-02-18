package com.example.kiwi.algorithmstudy.problems.linkedlist

import com.example.kiwi.algorithmstudy.problems.ListNode

// https://leetcode.com/problems/palindrome-linked-list/
// O(n): using array
fun isPalindrome_array(head: ListNode?): Boolean {
    if (head == null) {
        return true
    }
    var cur = head
    val nodeArray = arrayListOf<Int>()
    while (cur != null) {
        nodeArray.add(cur.`val`)
        cur = cur.next
    }
    // 양 끝에서부터 같은 지 확인하며 중간지점까지 오기
    val halfLength = nodeArray.size / 2
    for (i in 0..halfLength) {
        if (nodeArray[i] != nodeArray[nodeArray.lastIndex - i]) {
            return false
        }
    }
    return true
}

// solution2
// 1. Get the middle of the linked list (using runner, walker way)
// 2. Reverse the second half list
// 3. Check if the first half list and the reversed second half list are the same
fun isPalindrome(head: ListNode?): Boolean {
    // Get the middle
    var runner = head
    var walker = head
    while (runner != null) {
        runner = runner.next
        if (runner != null) {
            runner = runner.next
            walker = walker?.next
        }
    }

    var prev: ListNode? = null
    var cur = walker
    while (cur != null) {
        val nextTmp = cur.next
        cur.next = prev
        prev = cur
        cur = nextTmp
    }
    // prev is reversed second half list
    cur = prev
    var check = head
    while (cur != null) {
        if(cur.`val` != check?.`val`) {
            return false
        }
        check = check.next
        cur = cur.next
    }
    return true
}

fun main(args: Array<String>) {
    val head = ListNode(0) // head
    val li2 = ListNode(0)
    head.next = li2

//    var node: ListNode? = head
//    while (node != null) {
//        println("node: ${node.`val`}")
//        node = node.next
//    }

    println("isPalindrom: ${isPalindrome(head)}")
}