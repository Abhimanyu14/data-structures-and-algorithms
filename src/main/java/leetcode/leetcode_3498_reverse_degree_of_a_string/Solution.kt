package leetcode.leetcode_3498_reverse_degree_of_a_string

/**
 * leetcode - https://leetcode.com/problems/reverse-degree-of-a-string/description/
 *
 * Data Structure - [String]
 * Algorithm - ASCII, Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun reverseDegree(s: String): Int {
    var result = 0
    for (i in s.indices) {
        result += (i + 1) * (('z' - s[i]) + 1)
    }
    return result
}

private fun main() {

}
