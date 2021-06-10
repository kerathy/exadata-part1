package Question3

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val queries = Integer.valueOf(scanner.nextLine())
    var res = ""
    for (i in 1..queries) {
        val data = scanner.nextInt()
        val linkedList = LinkedList()
        linkedList.push(data)
        res += linkedList.tail().toString() + " "
    }
    println(res)
}


class LinkedList {
    private var first: Node? = null
    private var last: Node? = null
    private var len: Int = 0

    fun push(data: Int) {
        val previous = last
        last = Node(data)
        if (len == 0) {
            first = last
        } else {
            previous?.next = last
        }
        len++
    }

    inner class Node(var data: Int) {
        var next: Node? = null
    }

    fun tail(): Int {
        val res = last?.data
        return res ?:-1
    }
}