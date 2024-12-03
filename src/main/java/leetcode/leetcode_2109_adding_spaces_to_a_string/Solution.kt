package leetcode.leetcode_2109_adding_spaces_to_a_string

/**
 * leetcode - https://leetcode.com/problems/adding-spaces-to-a-string/
 *
 * Data Structure - [StringBuilder]
 * Algorithm - Two pointers
 *
 * Using [StringBuilder] with (capacity: Int) constructor
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 25 ms, faster than 33.33%
 * Memory Usage: 74.1 MB, less than 66.67%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun addSpaces(s: String, spaces: IntArray): String {
    val result = StringBuilder(s.length + spaces.size)
    var spacesIndex = 0
    for (i in s.indices) {
        if (spacesIndex < spaces.size && i == spaces[spacesIndex]) {
            result.append(" ")
            spacesIndex++
        }
        result.append(s[i])
    }
    return result.toString()
}

private fun main() {

}
