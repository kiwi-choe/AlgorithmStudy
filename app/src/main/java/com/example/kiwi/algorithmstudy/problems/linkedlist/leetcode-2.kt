package com.example.kiwi.algorithmstudy.problems.linkedlist

import com.example.kiwi.algorithmstudy.problems.ListNode


// https://leetcode.com/problems/add-two-numbers/
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    // sum each node values of two lists
    var list1 = l1
    var list2 = l2
    val sumHead = ListNode(0)
    var cur = sumHead
    var carry = 0
    while (list1 != null || list2 != null) {
        val sum = (list1?.`val` ?: 0) + (list2?.`val` ?: 0) + carry
        carry = sum / 10
        val extra = sum % 10

        cur.next = ListNode(extra)
        cur = cur.next!!

        list1 = list1?.next
        list2 = list2?.next
    }

    if(carry > 0) {
        cur.next = ListNode(carry)
    }
    return sumHead.next
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

fun main(args: Array<String>) {
    val head = ListNode(2)
    appendNode(head, ListNode(4))
    appendNode(head, ListNode(3))
    val head2 = ListNode(5)
    appendNode(head2, ListNode(6))
    appendNode(head2, ListNode(4))

    var node: ListNode? = head
    while (node != null) {
        println("node: ${node.`val`}")
        node = node.next
    }

    println("----")
    node = addTwoNumbers(head, head2)
    while (node != null) {
        println("node: ${node.`val`}")
        node = node.next
    }
}