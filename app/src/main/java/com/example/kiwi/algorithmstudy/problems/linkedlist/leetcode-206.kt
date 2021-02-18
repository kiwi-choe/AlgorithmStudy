package com.example.kiwi.algorithmstudy.problems.linkedlist

import com.example.kiwi.algorithmstudy.problems.ListNode


fun reverseList(head: ListNode?): ListNode? {
    var current = head
    var prev: ListNode? = null
    while (current != null) {
        val curNextTmp = current.next
        current.next = prev
        prev = current
        current = curNextTmp
    }
    return prev
}

fun main(args: Array<String>) {
    val head = ListNode(1) // head
    val li2 = ListNode(2)
    val li3 = ListNode(3)
    head.next = li2
    li2.next = li3

    var node: ListNode? = head
    while (node != null) {
        println("node: ${node.`val`}")
        node = node.next
    }

    println("reversed: ${reverseList(head)}")
}