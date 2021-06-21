package Question2

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

    //query
    while(scanner.hasNext()) {
        val names = scanner.nextLine()
        if (phoneBook.containsKey(names)) println(names + "=" + phoneBook[names]) else println("Not found")
    }

}
