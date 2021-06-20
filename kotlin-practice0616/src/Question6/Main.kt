package Question6

fun main() {
    val arr = readLine()!!.trimEnd().split(",").map{ it.toInt() }.toTypedArray()
    val target = readLine()!!.trim().toInt(); val index = arr.size - 1
    var start = 0; var end = index

    while (start <= end) {
        var mid = start + (end - start) / 2
        if (arr[mid] == target) {
            println(mid)
            return
        }

        if (arr[start] <= arr[mid]) {
            if (target >= arr[start] && target < arr[mid]) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }

        if (arr[mid] <= arr[end]) {
            if (target > arr[mid] && target <= arr[end]) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
    }

    println(-1)

}