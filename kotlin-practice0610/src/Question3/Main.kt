package Question3

import java.lang.StringBuilder
import java.util.*


fun main() {
    val scanner = Scanner(System.`in`); val size = scanner.nextInt()
    val headVal = scanner.nextInt(); var head = Node(headVal)

    val res = StringBuilder()
    res.append(getTailValue(head))
    res.append(" ")

    var cur = head; val index = size - 2

    for (i in 0..index) {
        val newNode = Node(scanner.nextInt())
        cur.next = newNode
        cur = newNode
        res.append(getTailValue(head))
        res.append(" ")
    }
    println(res.toString())


//    val scanner = Scanner(System.`in`); val size = scanner.nextInt()
//    val headVal = scanner.nextInt(); var head = Node(headVal)
//
//    val res = StringBuilder()
//    res.append(getTailValue(head))
//    res.append(" ")
//
//    var cur: Node? = head; val index = size - 2
//    for (i in 0..index) {
//        val newNode = Node(scanner.nextInt())
//        cur?.next = newNode
//        cur = cur?.next
//        res.append(getTailValue(head))
//        res.append(" ")
//    }
//    println(res.toString())
}

class Node {
    var value: Int
    var next: Node? = null

    constructor(_value: Int) {
        value = _value
    }
}


fun insertNode(head: Node?, value: Int) : Node? {
    var cur = head
    var count = 0
    while (cur != null) {
        cur = cur.next
        count++
    }

    val index = count - 2
    var pre = head
    for (i in 0..index) {
        pre = pre?.next
    }
    pre?.next = Node(value)
    return head
}

fun print(head: Node?) {
    var cur = head
    while (cur != null) {
        print("${cur.value}" + "->")
        cur = cur.next
    }
}

fun getTailValue(head: Node?) : Int {
    var cur = head
    while (cur?.next != null) {
        cur = cur.next
    }
    return cur!!.value
}