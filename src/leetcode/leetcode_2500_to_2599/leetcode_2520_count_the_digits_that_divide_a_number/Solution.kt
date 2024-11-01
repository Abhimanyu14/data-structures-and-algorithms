package leetcode.leetcode_2500_to_2599.leetcode_2520_count_the_digits_that_divide_a_number

/**
 * leetcode - https://leetcode.com/problems/count-the-digits-that-divide-a-number/
 *
 * Using arithmetic
 *
 * Stats
 * Runtime: 110 ms, faster than 96.55%
 * Memory Usage: 33.1 MB, less than 6.90%
 */
private fun countDigits(num: Int): Int {
    var result = 0
    var n = num
    var digit: Int
    while (n != 0) {
        digit = n % 10
        if (digit != 0 && (num % digit == 0)) {
            result++
        }
        n /= 10
    }
    return result
}

private fun main() {

}
