//fun main() {
//    val num1 = 1
//    val num2 = 2
//    val num3 = 3
//
//    val max = if (num1 > num2 && num1 > num3) {
//        "maxinum: " + num1
//    } else if (num2 > num1 && num2 > num3) {
//        "maximum: " + num2
//    } else {
//        "maximum: " + num3
//    }
//
//    println("$max")
//}



//fun main() {
//    val num1 = 1
//    val num2 = 2
//    val num3 = 3
//    val res = if (num1 > num2) {
//        if (num1 > num3) {
//            "maximum: " + num1
//        } else {
//            "maximum: " + num3
//        }
//    } else {
//        if (num2 > num3) {
//            "maximum: " + num2
//        } else {
//            "minimum: "  + num1
//        }
//    }
//
//    println("$res")
//}

fun main() {
    val num1 = 5
    val num2 = 2
    val num3 = 3
    val res = if (num1 > num2) {
        if (num1 > num3) {
            "maximum: $num1"
        } else {
            "maximum: $num3"
        }
    } else {
        if (num2 > num3) {
            "maximum: $num2"
        } else {
            "minimum: $num1"
        }
    }

    println(res)
}

