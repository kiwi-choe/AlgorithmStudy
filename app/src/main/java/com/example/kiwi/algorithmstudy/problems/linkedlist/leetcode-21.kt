package com.example.kiwi.algorithmstudy.problems

// https://leetcode.com/problems/merge-two-sorted-lists/
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun appendNode(head: ListNode?, node: ListNode): ListNode {
    if (head == null) {
        return node
    }
    var cur = head
    while (cur?.next != null) {
        cur = cur.next
    }
    cur?.next = node
    return head
}

// recursive
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1
    return if (l1.`val` < l2.`val`) {
        l1.next = mergeTwoLists(l1.next, l2)
        l1
    } else {
        l2.next = mergeTwoLists(l1, l2.next)
        l2
    }
}

// loop
fun mergeTwoLists_loop(l1: ListNode?, l2: ListNode?): ListNode? {
    var firstList = l1
    var secondList = l2
    val head = ListNode(-1)
    var resultList = head // resultList is pointer for making the result
    while (firstList != null && secondList != null) {
        val next: ListNode
        if (firstList.`val` < secondList.`val`) {
            next = firstList
            firstList = firstList.next
        } else {
            next = secondList
            secondList = secondList.next
        }
        resultList.next = next
        resultList = next
    }
    if (firstList != null) {
        resultList.next = firstList
    } else {
        resultList.next = secondList
    }
    return head.next
}

fun main(args: Array<String>) {
    val li = ListNode(5)
    println("li: ${li.`val`}")
//    val solution = mergeTwoLists()
}