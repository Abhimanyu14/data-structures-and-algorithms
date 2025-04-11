package leetcode.leetcode_2843_count_symmetric_integers

/**
 * leetcode - https://leetcode.com/problems/count-symmetric-integers/
 *
 * TODO(Abhi) - To revisit (Can try using Digit DP)
 *
 * Data Structure -
 * Algorithm - Iteration (Brute Force)
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Apple, Google
 */
private fun countSymmetricIntegers(low: Int, high: Int): Int {
    fun isSymmetric(x: Int): Boolean {
        val string = x.toString()
        if (string.length % 2 != 0) {
            return false
        }
        var sum = 0
        var current = x
        repeat(string.length / 2) {
            sum += current % 10
            current /= 10
        }
        repeat(string.length / 2) {
            sum -= current % 10
            current /= 10
        }
        return sum == 0
    }
    var result = 0
    for (i in low..high) {
        if (isSymmetric(i)) {
            result++
        }
    }
    return result
}

private fun main() {

}
