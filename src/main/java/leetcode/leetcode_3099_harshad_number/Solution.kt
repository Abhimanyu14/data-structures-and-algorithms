package leetcode.leetcode_3099_harshad_number

/**
 * leetcode - https://leetcode.com/problems/harshad-number/
 *
 * Data Structure - NA
 * Algorithm - Digit Extraction
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 34 MB, less than 30.77%
 *
 * Time - O(log (N))
 * Space - O(1)
 */
private fun sumOfTheDigitsOfHarshadNumber(x: Int): Int {
    var sumOfDigits = 0
    var temp = x
    while (temp != 0) {
        sumOfDigits += temp % 10
        temp /= 10
    }
    return if (x % sumOfDigits == 0) {
        sumOfDigits
    } else {
        -1
    }
}

private fun main() {

}
