package leetcode.leetcode_231_power_of_two

/**
 * leetcode - https://leetcode.com/problems/power-of-two/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Bitwise operations
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 232 ms, faster than 18.42%
 * Memory Usage: 35.4 MB, less than 94.74%
 *
 * Time - O(log(n))
 * Space - O(1)
 *
 * Companies - Google
 */
private fun isPowerOfTwo(n: Int): Boolean {
    return if (n <= 0) {
        false
    } else {
        (n and (n - 1)) == 0
    }
}

/**
 * leetcode - https://leetcode.com/problems/power-of-two/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 232 ms, faster than 18.42%
 * Memory Usage: 35.4 MB, less than 94.74%
 *
 * Time - O(log(n))
 * Space - O(1)
 *
 * Companies - Google
 */
private fun isPowerOfTwoUsingIteration(n: Int): Boolean {
    var num = n
    while (num % 2 == 0 && num > 0) {
        num /= 2
    }
    return num == 1
}

// TODO-Abhi: Using bitwise operations
private fun main() {
    val input1 = 1
    val input2 = 16
    val input3 = 3
    val input4 = 4
    val input5 = 5
    println(isPowerOfTwo(input1))
    println(isPowerOfTwo(input2))
    println(isPowerOfTwo(input3))
    println(isPowerOfTwo(input4))
    println(isPowerOfTwo(input5))
}
