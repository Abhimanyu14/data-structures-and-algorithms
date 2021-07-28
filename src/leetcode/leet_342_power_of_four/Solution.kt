package leetcode.leet_342_power_of_four

/**
 * Stats
 * Runtime: 232 ms, faster than 51.61%
 * Memory Usage: 35.4 MB, less than 83.87%
 */
fun isPowerOfFour(n: Int): Boolean {
    var ele = n
    while (ele % 4 == 0 && ele > 0) {
        ele /= 4
    }
    return ele == 1
}

fun main() {
    val input1 = 16
    val input2 = 5
    val input3 = 1
    println(isPowerOfFour(input1))
    println(isPowerOfFour(input2))
    println(isPowerOfFour(input3))
}
