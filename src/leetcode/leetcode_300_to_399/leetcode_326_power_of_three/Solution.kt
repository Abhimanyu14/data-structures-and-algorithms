package leetcode.leetcode_300_to_399.leetcode_326_power_of_three

/**
 * Stats
 * Runtime: 232 ms, faster than 78.33%
 * Memory Usage: 35.4 MB, less than 93.33%
 */
fun isPowerOfThree(n: Int): Boolean {
    var ele = n
    while (ele % 3 == 0 && ele > 0) {
        ele /= 3
    }
    return ele == 1
}

private fun main() {
    val input1 = 27
    val input2 = 0
    val input3 = 9
    val input4 = 45
    println(isPowerOfThree(input1))
    println(isPowerOfThree(input2))
    println(isPowerOfThree(input3))
    println(isPowerOfThree(input4))
}
