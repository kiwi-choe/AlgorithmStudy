package com.example.kiwi.algorithmstudy.problems.tree

class Node(var data: Char) {
    var left: Node? = null
    var right: Node? = null
}

fun createNode(newData: Char): Node {
    return Node(newData).apply {
        left = null
        right = null
    }
}

fun addChildNode(parent: Node, child: Node) {
    if (parent.left == null) {
        parent.left = child
    } else {
        var tempNode = parent.left!!
        while (tempNode.right != null) {
            tempNode = tempNode.right!!
        }
        // 최우측 child의 right에 연결
        tempNode.right = child
    }
}

fun printTree(node: Node, depth: Int) {
    for (i in 0 until depth) {
        print(" ")
    }

    println("${node.data}")

    node.left?.let { left ->
        printTree(left, depth + 1)
    }

    node.right?.let { right ->
        printTree(right, depth)
    }
}

fun main() {
    val root = createNode('A')

    val b = createNode('B')
    val c = createNode('C')
    val d = createNode('D')
    val e = createNode('E')
    val f = createNode('F')
    val g = createNode('G')
    val h = createNode('H')
    val i = createNode('I')

    addChildNode(root, b)
        addChildNode(b, c)
        addChildNode(b, d)
            addChildNode(d, e)
            addChildNode(d, f)

    addChildNode(root, g)
        addChildNode(g, h)

    addChildNode(root, i)

    printTree(root, 0)
}
