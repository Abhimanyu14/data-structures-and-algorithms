package leetcode.leetcode_2109_adding_spaces_to_a_string

/**
 * leetcode - https://leetcode.com/problems/adding-spaces-to-a-string/
 *
 * Using two pointers
 *
 * Stats
 * Runtime: 561 ms, faster than 61.90%
 * Memory Usage: 76.9 MB, less than 23.81%
 */
private fun addSpaces(s: String, spaces: IntArray): String {
    val result = StringBuilder()
    var spacesIndex = 0
    if (spaces[spacesIndex] == 0) {
        result.append(" ")
        spacesIndex++
    }
    var index = 0
    while (index < s.length && spacesIndex < spaces.size) {
        val nextSpaceIndex = spaces[spacesIndex]
        while (index < nextSpaceIndex) {
            result.append(s[index])
            index++
        }
        result.append(" ")
        spacesIndex++
    }
    while (index < s.length) {
        result.append(s[index])
        index++
    }
    return result.toString()
}

private fun main() {

}
