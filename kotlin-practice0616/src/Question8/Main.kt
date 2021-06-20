package Question8

fun main() {
    val arr = readLine()!!.trimEnd().split(",").map{ it.toInt() }.toTypedArray()
    val index = arr.size - 1; var count = 1

    for (i in 0..index) {
        if (arr[i] != arr[count - 1]) {
            arr[count++] = arr[i]
        }
    }
    println(count)
}