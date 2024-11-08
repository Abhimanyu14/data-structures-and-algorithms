package leetcode.leetcode_709_to_lower_case

/**
 * leetcode - https://leetcode.com/problems/to-lower-case/
 *
 * Using build in method [lowercase]
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 34.7 MB, less than 26.92%
 *
 * Time -
 * Space -
 */
private fun toLowerCase(s: String): String {
    val diffValue = ('a' - 'A')
    val result = StringBuilder()
    s.forEach {
        if (it in 'A'..'Z') {
            result.append(it + diffValue)
        } else {
            result.append(it)
        }
    }
    return result.toString()
}

/**
 * leetcode - https://leetcode.com/problems/to-lower-case/
 *
 * Using build in method [lowercase]
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 34.4 MB, less than 30.77%
 *
 * Time -
 * Space -
 */
private fun toLowerCaseUsingLowercase(s: String): String {
    return s.lowercase()
}

private fun main() {

}
