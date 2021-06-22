package Question4

fun main(args: Array<String>) {

    val arrCount = readLine()!!.trim().toInt()
    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    var count = 0
    val len = arr.size - 2
    for (i in 0..len) {
        for (j in 0..len-i) {
            if (arr[j] > arr[j+1]) {
                var temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp
                count++
            }
        }
    }

    println("Array is sorted in " + count + " swaps.")
    println("First Element: " + arr[0])
    println("Last Element: " + arr[len+1])
}






