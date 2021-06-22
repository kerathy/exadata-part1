package Question1

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val title = scanner.nextLine()
    val author = scanner.nextLine()
    val price = Integer.valueOf(scanner.nextLine())

    val myBook = MyBook(title, author, price)
    myBook.display()
}


abstract class Book {
    var title: String? = null
    var author: String? = null
    var price: Int

    constructor(_title: String, _author: String, _price: Int) {
        title = _title
        author = _author
        price = _price
    }
    abstract fun display()
}

class MyBook: Book {
    constructor(_title: String, _author: String, _price: Int) : super(_title, _author, _price)

    override fun display() {
        println("Title: " + this.title)
        println("Author: " + this.author)
        println("Price: " + this.price)
    }
}
