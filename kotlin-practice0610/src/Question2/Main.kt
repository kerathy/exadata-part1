package Question2

import java.util.*
fun main() {
    query()
}

fun query() {

    var phoneBook = hashMapOf<String, Int>()
    val scanner = Scanner(System.`in`)
    val queries = Integer.valueOf(scanner.nextLine())
    for (i in 1..queries) {
        val names = scanner.next()
        val phoneNumber = scanner.nextInt()
//        println(names)
//        println(phoneNumber)
        phoneBook.put(names, phoneNumber)
    }

    //query
    while(scanner.hasNext()) {
        val names = scanner.next()
        if (!phoneBook.containsKey(names)) {
            println("Not found")
        } else {
            println(names + "=" + phoneBook[names])
        }
    }

}
