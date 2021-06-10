package Question1

//open class Book {
//    val title: String
//    val author: String
//    val price: Int
//    abstract fun display()
//}

class MyBook(val title: String, val author: String, val price: Int){

    fun display() {
        println("Title: " + this.title)
        println("Author: " + this.author)
        println("Price: " + this.price)
    }
}


//class MyBook : Book{
//    init {
//        println("1")
//    }
//    constructor(): this("The Alchemist", "Paulo Coelho",  248) {
//        println("seconday constructor")
//    }


//    fun display() {
//        println("Title: " + this.title)
//        println("Author: " + this.author)
//        println("Price: " + this.price)
//    }
//    override fun display() {
//        println("Title: " + this.title)
//        println("Author: " + this.author)
//        println("Price: " + this.price)
//
//    }
//}

