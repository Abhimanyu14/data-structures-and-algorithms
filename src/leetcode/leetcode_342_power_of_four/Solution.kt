package leetcode.leetcode_342_power_of_four

/**
 * leetcode - https://leetcode.com/problems/power-of-four/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 123 ms, faster than 95.59%
 * Memory Usage: 34.2 MB, less than 13.24%
 */
private fun isPowerOfFour(n: Int): Boolean {
    var ele = n
    while (ele % 4 == 0 && ele > 0) {
        ele /= 4
    }
    return ele == 1
}

private fun main() {
    val input1 = 16
    val input2 = 5
    val input3 = 1
    println(isPowerOfFour(input1))
    println(isPowerOfFour(input2))
    println(isPowerOfFour(input3))
}
