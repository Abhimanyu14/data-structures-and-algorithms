package algorithms.number

fun toDigits(n: Int): IntArray {
    val result = mutableListOf<Int>()
    var ele = n
    while (ele != 0) {
        result.add(ele % 10)
        ele /= 10
    }
    return result.reversed().toIntArray()
}
