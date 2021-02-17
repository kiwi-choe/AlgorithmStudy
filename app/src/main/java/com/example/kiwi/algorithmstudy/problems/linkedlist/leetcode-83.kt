package com.example.kiwi.algorithmstudy.problems.linkedlist

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class `leetcode-83` {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun deleteDuplicates(head: ListNode?): ListNode? {
        // sorted head
        // if current node value == node.next.val, skip to the next.next node
        var current = head // current is a pointer
        while (current?.next != null) {
            if (current.`val` == current.next!!.`val`) {
                current.next = current.next!!.next
            } else {
                current = current.next
            }
        }
        return head
    }
}

fun main(args: Array<String>) {
    var head = `leetcode-83`.ListNode(1)
    val n1 = `leetcode-83`.ListNode(1)
    val n2 = `leetcode-83`.ListNode(2)
    head.next = n1
    n1.next = n2
    var answer = `leetcode-83`().deleteDuplicates(head)
    if (answer != null) {
        while (answer != null) {
            println("answer: ${answer.`val`}")
            answer = answer.next
        }
    }
}
