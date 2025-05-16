package leetcode.leetcode_2390_removing_stars_from_a_string

/**
 * leetcode - https://leetcode.com/problems/removing-stars-from-a-string/description/
 *
 * Data Structure - [StringBuilder]
 * Algorithm - Stack using StringBuilder
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Google, Microsoft
 */
private fun removeStars(s: String): String {
    val result = StringBuilder()
    for (i in s.indices) {
        if (s[i] == '*') {
            result.deleteCharAt(result.lastIndex)
        } else {
            result.append(s[i])
        }
    }
    return result.toString()
}

private fun main() {

}
