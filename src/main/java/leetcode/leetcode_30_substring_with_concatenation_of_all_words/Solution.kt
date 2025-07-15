package leetcode.leetcode_30_substring_with_concatenation_of_all_words

/**
 * leetcode - https://leetcode.com/problems/substring-with-concatenation-of-all-words/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [List], [Map]
 * Algorithm -
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun findSubstringUsingSubstrings(s: String, words: Array<String>): List<Int> {
    val result = mutableListOf<Int>()

    val wordCounter = mutableMapOf<String, Int>()
    for (word in words) {
        wordCounter[word] = wordCounter.getOrDefault(word, 0) + 1
    }

    fun isConcatenatedString(start: Int): Boolean {
        val currentCounter = mutableMapOf<String, Int>()
        for (i in words.indices) {
            val currentWord = s.substring(start + (i * words[0].length), start + ((i + 1) * words[0].length))
            currentCounter[currentWord] = currentCounter.getOrDefault(currentWord, 0) + 1
        }
        for ((key, value) in currentCounter) {
            if (wordCounter[key] != value) {
                return false
            }
        }
        return true
    }

    for (i in 0..(s.length - (words.size * words[0].length))) {
        if (isConcatenatedString(i)) {
            result.add(i)
        }
    }
    return result
}

private fun main() {

}
