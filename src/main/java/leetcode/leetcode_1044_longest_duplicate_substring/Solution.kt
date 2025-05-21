package leetcode.leetcode_1044_longest_duplicate_substring

/**
 * TODO(Abhi) - To revisit using Rabin Karp
 *
 */
/**
 * leetcode - https://leetcode.com/problems/longest-duplicate-substring/description/?envType=company&envId=google&favoriteSlug=google-three-months
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Set]
 * Algorithm -
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun longestDupSubstringUsingBruteForce(s: String): String {
    var length = s.length
    val seen = mutableSetOf<String>()
    for (i in s.indices) {
        length--
        seen.clear()
        for (j in 0..(s.length - length)) {
            val subString = s.substring(j, j + length)
            if (seen.contains(subString)) {
                return subString
            }
            seen.add(subString)
        }
    }
    return ""
}

private fun main() {

}
