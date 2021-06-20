package Question4

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`); val str = scanner.nextLine()
    val numRows = Integer.valueOf(scanner.nextLine())

    if (numRows <= 1) {
        println(str)
        return
    }

    val sb = Array<StringBuilder?>(numRows) { null }; val res = StringBuilder()
    val strLen = str.length; val index = strLen - 1; val rowIndex = numRows - 1

    for (i in 0..rowIndex) {
        sb[i] = StringBuilder()
    }

    for (i in 0..index) {
        var index = i % (2 * numRows - 2)

        if (index >= numRows) {
            index = 2 * numRows - 2 - index
        }
        sb[index]?.append(str[i])
    }

    for (i in 0..rowIndex) {
        res.append(sb[i])
    }
    print(res.toString())
}
