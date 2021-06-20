package Question3

fun main() {
    var arr1 = emptyArray<Int>(); var arr2 = emptyArray<Int>()
    val str1 = readLine(); val str2 = readLine()

    if (!str1.isNullOrBlank()) {
        arr1 = str1.trimEnd().split(",").map{ it.toInt() }.toTypedArray()
    }

    if (!str2.isNullOrBlank()) {
        arr2 = str2.trimEnd().split(",").map{ it.toInt() }.toTypedArray()
    }

//    println(arr1.contentToString())
    var res = medianOfTwoSortedArrays(arr1, arr2)
    println(res)
}

fun medianOfTwoSortedArrays(arr1: Array<Int>, arr2: Array<Int>) : Double {
    val len1 = arr1.size; val len2 = arr2.size; val len = len1 + len2
    var cut1 = 0; var cut2: Int; var start = 0; var end = len1

    if (len1 > len2) {
        return medianOfTwoSortedArrays(arr2, arr1)
    }

    while (cut1 <= len1) {
        cut1 = start + (end - start) / 2
        cut2 = len / 2 - cut1

        val L1 = if (cut1 == 0) Int.MIN_VALUE else arr1[cut1 - 1]
        val L2 = if (cut2 == 0) Int.MIN_VALUE else arr2[cut2 - 1]
        val R1 = if (cut1 == len1) Int.MAX_VALUE else arr1[cut1]
        val R2 = if (cut2 == len2) Int.MAX_VALUE else arr2[cut2]

        if (L1 > R2) {
            end = cut1 - 1
        } else if (L2 > R1) {
            start = cut1 + 1
        } else {
            if (len % 2 == 0) {
                val max = if (L1 > L2) L1 else L2
                val min = if (R1 < R2) R1 else R2
                return (min.toDouble() + max.toDouble()) / 2
            } else {
                when (R1 < R2) {
                    true -> return R1.toDouble()
                    false -> return R2.toDouble()
                }
            }
        }
    }
    return -1.0
}