package leetcode.leet_0_to_99.leet_3_longest_substring_without_repeating_characters

/**
 * leetcode - https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Stats
 */
fun lengthOfLongestSubstring(s: String): Int {
    var result = 0
    var i = 0
    val arrayDeque = ArrayDeque<Char>()
    while (i != s.length) {
        while (arrayDeque.contains(s[i])) {
            arrayDeque.removeFirst()
        }
        arrayDeque.add(s[i])
        result = maxOf(result, arrayDeque.size)
        i++
    }
    return result
}

private fun main() {
    val input = "pwwkew"
    val input2 = "bbbbb"
    val input3 = "abcabcbb"
    println(lengthOfLongestSubstring(""))
}
