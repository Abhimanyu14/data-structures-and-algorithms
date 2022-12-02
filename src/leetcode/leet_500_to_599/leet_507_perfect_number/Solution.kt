package leetcode.leet_500_to_599.leet_507_perfect_number

/**
 * Using loop
 *
 * Stats
 * Runtime: 3444 ms, faster than 21.05%
 * Memory Usage: 33.1 MB, less than 84.21%
 */
private fun checkPerfectNumberBruteForce(num: Int): Boolean {
    var sum = 0
    for (i in 1 until num) {
        if (num % i == 0) {
            sum += i
        }
    }
    return sum == num
}

/**
 * Using loop till n/2
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

/**
 * TODO-Abhi: Using Euclid-Euler
 */

private fun main() {

}
