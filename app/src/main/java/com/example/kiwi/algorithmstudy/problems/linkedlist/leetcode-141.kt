package com.example.kiwi.algorithmstudy.problems.linkedlist

// https://leetcode.com/problems/linked-list-cycle-ii/submissions/
class `leetcode-141` {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    /**
     * walkrunner way
     */
    fun hasCycle(head: ListNode?): Boolean {
        // walker and runner will be encountered
        var runner = head
        var walker = head
        while (runner != null) {
            runner = runner.next
            if (runner != null && walker != null) {
                runner = runner.next
                walker = walker.next
            }
            if (runner == walker) {
                return true
            }
        }
        return false
    }

    /**
     * leetcode-142
     */
    fun detectCycle(head: ListNode?): ListNode? {
        var runner = head
        var walker = head
        while (runner != null) {
            runner = runner.next
            if (runner != null && walker != null) {
                runner = runner.next
                walker = walker.next
            }
            if (runner == walker) {
                break
            }
        }
        walker = head
        while (walker != runner) {
            walker = walker?.next
            runner = runner?.next
        }
        return walker
    }
}
