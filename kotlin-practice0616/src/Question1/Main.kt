package Question1

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`); val str = scanner.nextLine()

    if (str.isEmpty()) {
        println(0)
        return
    }

    var res = 0; var i = 0; var j = 0
    val index = str.length - 1; var set = HashSet<Char>()

    while(i <= index) {
        if (set.contains(str[i])) {
            set.remove(str[j++])
        } else {
            set.add(str[i])
            res = Math.max(res, i - j + 1)
            i++
        }
    }
    println(res)

}