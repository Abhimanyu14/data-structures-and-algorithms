package leetcode.leetcode_2131_longest_palindrome_by_concatenating_two_letter_words

/**
 * leetcode - https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/description/?envType=daily-question&envId=2025-05-25
 *
 * Data Structure - [IntArray], [Map]
 * Algorithm - Hashing & Counting
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Apple, Google
 */
private fun longestPalindrome(words: Array<String>): Int {
    var result = 0
    val sameCounter = IntArray(26)
    val map = mutableMapOf<String, Int>()
    for (word in words) {
        if (word[0] == word[1]) {
            sameCounter[word[0] - 'a']++
        } else {
            if (map.getOrDefault("${word[1]}${word[0]}", 0) > 0) {
                result += 4
                map["${word[1]}${word[0]}"] = map.getOrDefault("${word[1]}${word[0]}", 0) - 1
            } else {
                map[word] = map.getOrDefault(word, 0) + 1
            }
        }
    }
    var isMidFree = true
    for (i in 0..25) {
        if (sameCounter[i] > 0) {
            if (sameCounter[i] % 2 == 0) {
                result += sameCounter[i] * 2
            } else if (isMidFree) {
                result += sameCounter[i] * 2
                isMidFree = false
            } else {
                result += (sameCounter[i] / 2) * 4
            }
        }
    }
    return result
}

private fun main() {

}
