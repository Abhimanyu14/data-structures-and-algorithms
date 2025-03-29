package course.argorithmic_toolbox.week2

/**
 * Euclidean algorithm
 */
private fun greatestCommonDivisor(a: Int, b: Int): Int {
    if (b == 0) {
        return a
    }
    return greatestCommonDivisor(b, a % b)
}

private fun main() {
    val list = listOf(
        Pair(2, 3),
        Pair(3, 4),
        Pair(4, 8),
        Pair(5, 25),
        Pair(30, 5),
        Pair(40, 50),
        Pair(357, 234),
    )
    list.forEach {
        println(greatestCommonDivisor(it.first, it.second))
    }
}
