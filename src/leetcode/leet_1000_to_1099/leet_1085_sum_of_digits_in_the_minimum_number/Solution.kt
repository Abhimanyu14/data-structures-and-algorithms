package leetcode.leet_1000_to_1099.leet_1085_sum_of_digits_in_the_minimum_number

/**
 * Using min() and loop
 *
 * Runtime: 266 ms, faster than 100.00%
 * Memory Usage: 37.1 MB, less than 100.00%
 */
private fun sumOfDigits(nums: IntArray): Int {
    var min = nums.min() ?: 0
    var sum = 0
    while (min != 0) {
        sum += min % 10
        min /= 10
    }
    return if (sum % 2 == 0) {
        1
    } else {
        0
    }
}

private fun main() {

}
