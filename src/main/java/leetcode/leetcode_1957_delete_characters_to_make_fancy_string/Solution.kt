package leetcode.leetcode_1957_delete_characters_to_make_fancy_string

/**
 * leetcode - https://leetcode.com/problems/delete-characters-to-make-fancy-string/?envType=daily-question&envId=2024-11-01
 *
 * Data Structure - [StringBuilder]
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Google, Microsoft
 */
private fun makeFancyString(s: String): String {
    val result = StringBuilder()
    var prev = s[0]
    var prevCount = 1
    result.append(s[0])
    for (i in 1..<s.length) {
        if (s[i] == prev) {
            prevCount++
        } else {
            prevCount = 1
            prev = s[i]
        }
        if (prevCount < 3) {
            result.append(s[i])
        }
    }
    return result.toString()
}

private fun main() {

}
