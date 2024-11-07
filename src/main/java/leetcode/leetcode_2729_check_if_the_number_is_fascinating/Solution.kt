package leetcode.leetcode_2729_check_if_the_number_is_fascinating

/**
 * leetcode - https://leetcode.com/problems/check-if-the-number-is-fascinating/
 *
 * Using string
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 2 ms, faster than 100.00%
 * Memory Usage: 34.2 MB, less than 66.67%
 *
 * Time -
 * Space -
 */
private fun isFascinating(n: Int): Boolean {
    val string = "${n}${n * 2}${n * 3}"
    if (string.length != 9) {
        return false
    }
    val flags = BooleanArray(9) { false }
    string.forEach {
        if (it == '0') {
            return false
        }
        if (flags[it - '1']) {
            return false
        } else {
            flags[it - '1'] = true
        }
    }
    return true
}

private fun main() {

}
