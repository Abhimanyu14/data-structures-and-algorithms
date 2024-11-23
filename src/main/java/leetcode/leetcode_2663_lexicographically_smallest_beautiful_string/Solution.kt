package leetcode.leetcode_2663_lexicographically_smallest_beautiful_string

/**
 * leetcode - https://leetcode.com/problems/lexicographically-smallest-beautiful-string/
 *
 * TODO(Abhi) - To revisit
 *
 * Source - https://leetcode.com/problems/lexicographically-smallest-beautiful-string/discuss/3468265/Weird-Problem
 *
 * Using
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 15 ms, faster than 80.00%
 * Memory Usage: 40.3 MB, less than 70.00%
 *
 * Time -
 * Space -
 */
private fun smallestBeautifulString(s: String, k: Int): String {
    val chars = s.toCharArray()
    fun isValid(i: Int): Boolean {
        return (i < 1 || chars[i] != chars[i - 1]) && (i < 2 || chars[i] != chars[i - 2])
    }
    for (i in chars.lastIndex downTo 0) {
        chars[i]++
        while (!isValid(i)) {
            chars[i]++
        }
        if (chars[i] < 'a' + k) {
            for (j in i + 1..<chars.size) {
                chars[j] = 'a'
                while (!isValid(j)) {
                    chars[j]++
                }
            }
            return String(chars)
        }
    }
    return ""
}

private fun main() {

}
