package Question2

import java.lang.StringBuilder
import java.util.*
fun main() {
    query()
}

fun query() {

    val scanner = Scanner(System.`in`)
    val queries = Integer.valueOf(scanner.nextLine())
    var phoneBook = hashMapOf<String, String>()

    for (i in 1..queries) {
        val names = scanner.next()
        val phoneNumber = scanner.nextLine().substring(1)
        phoneBook.put(names, phoneNumber)
    }

    val res = StringBuilder()
    //query
    while(scanner.hasNext()) {
        val names = scanner.nextLine()
        if (names.equals("quit")) break
        if (phoneBook.containsKey(names)) {
            res.append(names + "=" + phoneBook[names])
            res.append("*")
        } else {
            res.append("Not found")
            res.append("*")
        }
    }
    val strs = res.toString().split("*")

    for (str in strs) {
        println(str)
    }
}
