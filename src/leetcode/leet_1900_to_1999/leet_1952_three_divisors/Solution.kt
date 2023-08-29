package leetcode.leet_1900_to_1999.leet_1952_three_divisors

/**
 * leetcode - https://leetcode.com/problems/three-divisors/
 *
 * Using arithmetic
 *
 * Stats
 * Runtime: 147 ms, faster than 33.33%
 * Memory Usage: 33.5 MB, less than 33.33%
 */
private fun isThree(n: Int): Boolean {
    var count = 0
    for (i in 1..n) {
        if (n % i == 0) {
            count++
            if (count > 3) {
                return false
            }
        }
    }
    return count == 3
}

private fun main() {

}
