package leetcode.leetcode_2309_greatest_english_letter_in_upper_and_lower_case

/**
 * leetcode - https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/
 *
 * Data Structure - Set
 * Algorithm - Hashing
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 22 ms, faster than 20.00%
 * Memory Usage: 38.7 MB, less than 40.00%
 *
 * Time - O(1)
 * Space - O(N)
 */
private fun greatestLetter(s: String): String {
    s.contains("")
    val set = s.toSet()
    for (i in 0..25) {
        if (set.contains('Z' - i) && set.contains('z' - i)) {
            return ('Z' - i).toString()
        }
    }
    return ""
}

private fun main() {

}
