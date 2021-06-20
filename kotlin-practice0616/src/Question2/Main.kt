package Question2

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`); val str = scanner.nextLine()

    if (str.isEmpty()) {
        println(0)
        return
    }

    var res = ""; val len = str.length; var i = 0; var j = 0
    val dp = Array(len) { BooleanArray(len) }

    while (i < len) {
        while (j <= i) {
            dp[j][i] = (str[j] == str[i]) && ((i - j < 2) || dp[j + 1][i - 1])
            if (dp[j][i]) {
                var cur = str.substring(j, i + 1)
                if (cur.length > res.length) {
                    res = cur
                }
            }
            j++
        }
        j = 0
        i++
    }
    println(res)
}
