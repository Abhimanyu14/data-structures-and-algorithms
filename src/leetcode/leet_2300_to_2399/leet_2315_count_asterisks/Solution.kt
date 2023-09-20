package leetcode.leet_2300_to_2399.leet_2315_count_asterisks

/**
 * leetcode - https://leetcode.com/problems/count-asterisks/
 *
 * Using string iteration
 *
 * Stats
 * Runtime: 146 ms, faster than 52.94%
 * Memory Usage: 34.3 MB, less than 35.29%
 */
private fun countAsterisks(s: String): Int {
    var result = 0
    var ignore = false
    s.forEach {
        if (it == '|') {
            ignore = !ignore
        } else if (it == '*' && !ignore) {
            result++
        }
    }
    return result
}

private fun main() {

}
