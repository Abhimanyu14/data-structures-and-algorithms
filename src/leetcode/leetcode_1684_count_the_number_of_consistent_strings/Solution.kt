package leetcode.leetcode_1684_count_the_number_of_consistent_strings

/**
 * leetcode - https://leetcode.com/problems/count-the-number-of-consistent-strings/
 *
 * Using array
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 238 ms, faster than 88.37%
 * Memory Usage: 37.5 MB, less than 86.05%
 *
 * Time -
 * Space -
 */
private fun countConsistentStrings(allowed: String, words: Array<String>): Int {
    var result = 0
    val counter = IntArray(26)
    allowed.forEach {
        counter[it - 'a']++
    }
    var i: Int
    words.forEach { word ->
        i = 0
        while (i < word.length) {
            if (counter[word[i] - 'a'] == 0) {
                break
            }
            i++
        }
        if (i == word.length) {
            result++
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/count-the-number-of-consistent-strings/
 *
 * Using set
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 236 ms, faster than 88.37%
 * Memory Usage: 37.7 MB, less than 79.07%
 *
 * Time -
 * Space -
 */
private fun countConsistentStringsUsingSet(allowed: String, words: Array<String>): Int {
    var result = 0
    val set = mutableSetOf<Char>()
    allowed.forEach {
        set.add(it)
    }
    var i = 0
    words.forEach { word ->
        i = 0
        while (i < word.length) {
            if (!set.contains(word[i])) {
                break
            }
            i++
        }
        if (i == word.length) {
            result++
        }
    }
    return result
}

private fun main() {

}
