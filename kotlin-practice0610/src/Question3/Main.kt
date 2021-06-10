package Question3

fun main() {
    println("Main")
    val linkedList = LinkedList()
    linkedList.push(2)
    println(linkedList.tail())
    linkedList.push(3)
    println(linkedList.tail())
    linkedList.push(4)
    println(linkedList.tail())
    linkedList.push(1)
    println(linkedList.tail())
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