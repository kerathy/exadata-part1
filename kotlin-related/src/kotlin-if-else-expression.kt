var num3 = 0
var flag = true

fun main() {
    num3 = 1

    val res = if (num3 > 2) {
        flag = true
    } else {
        flag = false
    }
    println("the number is greater than 2 is: " + flag);
}
