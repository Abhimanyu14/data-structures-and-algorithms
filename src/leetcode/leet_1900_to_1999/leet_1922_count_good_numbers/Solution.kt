package leetcode.leet_1900_to_1999.leet_1922_count_good_numbers

import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/count-good-numbers/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 *
 */
fun countGoodNumbers(n: Long): Int {
    if (n.toInt() == 1) {
        return 5
    }
    val multiplier = if (n.toInt() % 2 == 0) {
        1
    } else {
        5
    }
    return (((20.0.pow((n / 2).toInt())) * multiplier) % (10.0.pow(9) + 7)).toInt()
}

private fun main() {
    println(countGoodNumbers(1L))
    println(countGoodNumbers(2L))
    println(countGoodNumbers(3L))
    println(countGoodNumbers(4L))
    println(countGoodNumbers(50L))
}
