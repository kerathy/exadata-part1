package Question5

fun main() {
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    node1.next = node2
    node2.next = node3
    print(node1)

    println()
    val node4 = Node(1)
    val node5 = Node(3)
    val node6 = Node(4)
    node4.next = node5
    node5.next = node6
    print(node4)

    println()
    val res = merge(node1, node4)
    print(res)

    println()
    println("test case 2")
    val res2 = merge(null, null)
    print(res2)

    println()
    println("test case 3")
    val node7 = Node(0)
    val res3 = merge(null, node7)
    print(res3)
}



class Node(var value: Int, var next: Node? = null)

fun merge(list1: Node?, list2: Node?) : Node? {
    var dummy = Node(0)
    var cur: Node? = dummy
    var l1 = list1
    var l2 = list2

    while (l1 != null && l2 != null) {
        if (l1.value < l2.value) {
            cur?.next = l1
            l1 = l1.next
        } else {
            cur?.next = l2
            l2 = l2.next
        }
        cur = cur?.next
    }
    if (l1 != null) {
        cur?.next = l1
    } else if (l2 != null) {
        cur?.next = l2
    }
    return dummy.next

}

fun print(head: Node?) {
    var cur = head
    while (cur != null) {
        print("${cur.value}" + "->")
        cur = cur.next
    }
}
