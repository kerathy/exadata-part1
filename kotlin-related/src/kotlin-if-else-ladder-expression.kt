
fun main() {
    val num1 = 1
    val res = if (num1 > 0) {
        "$num1 is positive"
    } else if (num1 < 0) {
        "$num1 is negative"
    } else {
        "$num1 is zero"
    }

    println(res)
}