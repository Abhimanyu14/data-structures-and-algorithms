package leetcode.leetcode_200_to_299.leetcode_258_add_digits

/**
 * Digital root
 *
 * Stats
 * Runtime: 258 ms, faster than 59.32%
 * Memory Usage: 34 MB, less than 79.66%
 */
private fun addDigits(num: Int): Int {
    return if (num == 0) {
        0
    } else {
        1 + (num - 1) % 9
    }
}

/**
 * Using loops
 *
 * Stats
 * Runtime: 335 ms, faster than 5.09%
 * Memory Usage: 35.5 MB, less than 6.78%
 */
private fun addDigitsNaive(num: Int): Int {
    var x = num
    var sum = 0
    while (sum < 10) {
        sum += x % 10
        x /= 10
        if (x == 0) {
            x = sum
        }
    }
    return sum
}

private fun main() {

}
