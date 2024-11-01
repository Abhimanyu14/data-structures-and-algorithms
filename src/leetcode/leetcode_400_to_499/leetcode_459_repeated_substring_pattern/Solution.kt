package leetcode.leetcode_400_to_499.leetcode_459_repeated_substring_pattern

/**
 * leetcode - https://leetcode.com/problems/repeated-substring-pattern/
 *
 * Using string functions - length, repeat(), substring()
 *
 * Stats
 * Runtime: 266 ms, faster than 44.19%
 * Memory Usage: 38.7 MB, less than 19.36%
 */
private fun repeatedSubstringPattern(s: String): Boolean {
    for (i in 1..(s.length/2)) {
        if ((s.length % i == 0) && s.substring(0 , i).repeat(s.length / i) == s) {
            return true
        }
    }
    return false
}

/**
 * leetcode - https://leetcode.com/problems/repeated-substring-pattern/
 *
 * Using string concatenation
 *
 * Stats
 * Runtime: 243 ms, faster than 65.83%
 * Memory Usage: 37.8 MB, less than 41.46%
 */
private fun repeatedSubstringPatternUsingStringConcatenation(s: String): Boolean {
    return (s + s).substring(1, (s.length * 2) - 1).contains(s)
}

private fun main() {

}
