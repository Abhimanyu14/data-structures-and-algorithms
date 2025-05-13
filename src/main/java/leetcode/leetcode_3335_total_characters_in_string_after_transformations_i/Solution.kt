package leetcode.leetcode_3335_total_characters_in_string_after_transformations_i

/**
 * leetcode - https://leetcode.com/problems/total-characters-in-string-after-transformations-i/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private const val MOD = 1000000007
private fun lengthAfterTransformations(s: String, t: Int): Int {
    var counter = IntArray(26)
    for (char in s.toCharArray()) {
        counter[char - 'a']++
    }
    for (round in 0..<t) {
        val next = IntArray(26)
        next[0] = counter[25]
        next[1] = (counter[25] + counter[0]) % MOD
        for (i in 2..25) {
            next[i] = counter[i - 1]
        }
        counter = next
    }
    var result = 0
    for (i in 0..25) {
        result = (result + counter[i]) % MOD
    }
    return result
}

private fun main() {

}
