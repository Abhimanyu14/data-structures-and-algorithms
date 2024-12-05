package leetcode.leetcode_507_perfect_number

/**
 * leetcode - https://leetcode.com/problems/perfect-number/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Euclid-Euler
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */

/**
 * leetcode - https://leetcode.com/problems/perfect-number/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 3444 ms, faster than 21.05%
 * Memory Usage: 33.1 MB, less than 84.21%
 *
 * Time -
 * Space -
 */
private fun checkPerfectNumberBruteForce(num: Int): Boolean {
    var sum = 0
    for (i in 1..<num) {
        if (num % i == 0) {
            sum += i
        }
    }
    return sum == num
}

/**
 * leetcode - https://leetcode.com/problems/perfect-number/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1695 ms, faster than 57.89%
 * Memory Usage: 32.7 MB, less than 100.00%
 */
private fun checkPerfectNumberHalfLoop(num: Int): Boolean {
    if (num <= 1) {
        return false
    }
    var sum = 1
    for (i in 2..(num / 2)) {
        if (num % i == 0) {
            sum += i
        }
    }
    return sum == num
}

private fun main() {

}
