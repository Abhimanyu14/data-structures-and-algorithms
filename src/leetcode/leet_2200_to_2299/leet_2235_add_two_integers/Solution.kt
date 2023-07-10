package leetcode.leet_2200_to_2299.leet_2235_add_two_integers

/**
 * leetcode - https://leetcode.com/problems/add-two-integers/
 *
 * Using addition operator
 *
 * Stats
 * Runtime: 197 ms, faster than 65.75%
 * Memory Usage: 33.5 MB, less than 59.93%
 */
private fun sumNative(num1: Int, num2: Int): Int {
    return num1 + num2
}

/**
 * leetcode - https://leetcode.com/problems/add-two-integers/
 *
 * Using Bitwise operations
 * TODO-Abhi: revisit
 *
 * Stats
 * Runtime: 201 ms, faster than 61.64%
 * Memory Usage: 34 MB, less than 18.49%
 */
private fun sum(num1: Int, num2: Int): Int {
    if (num2 == 0) return num1
    return sum(num1 xor num2, (num1 and num2) shl 1)
}

private fun main() {
    println(sum(12, 5))
    println(sum(-10, 4))
}
