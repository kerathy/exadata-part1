package Question7

fun main() {

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    val target = readLine()!!.trim().toInt()
    val index = arr.size - 1

    var start = 0
    var end = index
    while (start <= end) {
        var mid = start + (end - start) / 2
        if (arr[mid] == target) {
            println(mid)
            return
        } else if (arr[mid] < target) {
            start = mid + 1
        } else {
            end = mid - 1
        }
    }
    println(start)
}