package leetcode.leetcode_600_to_699.leetcode_633_sum_of_square_numbers

/**
 * leetcode - https://leetcode.com/problems/sum-of-square-numbers/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun judgeSquareSum(c: Int): Boolean {
    var c1 = c
    var i = 2
    while (i * i <= c1) {
        var count = 0
        if (c1 % i == 0) {
            while (c1 % i == 0) {
                count++
                c1 /= i
            }
            if (i % 4 == 3 && count % 2 != 0) return false
        }
        i++
    }
    return c1 % 4 != 3
}

private fun main() {

}
