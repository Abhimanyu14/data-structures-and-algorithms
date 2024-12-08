package leetcode.leetcode_2550_count_collisions_of_monkeys_on_a_polygon

/**
 * leetcode - https://leetcode.com/problems/count-collisions-of-monkeys-on-a-polygon/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Modular Exponentiation
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 34.5 MB, less than 33.33%
 *
 * Time -
 * Space -
 */
private fun monkeyMove(n: Int): Int {
    val mod = 1_000_000_007
    fun modPow(base: Long, exp: Int, mod: Int): Int {
        var result = 1L
        var b = base
        var e = exp
        while (e > 0) {
            if (e % 2 == 1) { // If `e` is odd
                result = (result * b) % mod
            }
            b = (b * b) % mod
            e /= 2
        }
        return result.toInt()
    }

    val power = modPow(2, n, mod) - 2
    return if (power < 0) {
        (power + mod)
    } else {
        power
    }
}

private fun main() {

}
