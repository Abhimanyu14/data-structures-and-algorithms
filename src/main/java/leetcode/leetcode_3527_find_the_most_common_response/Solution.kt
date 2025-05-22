package leetcode.leetcode_3527_find_the_most_common_response

/**
 * leetcode - https://leetcode.com/problems/find-the-most-common-response/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 *
 * Data Structure - [Map], [Set]
 * Algorithm - Counting, Hashing
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun findCommonResponse(responses: List<List<String>>): String {
    var result = ""
    var maxCount = 0
    val counter = mutableMapOf<String, Int>()

    fun getSmallerLexicographicalWord(word1: String, word2: String): String {
        var index = 0
        while (index <= word1.lastIndex && index <= word2.lastIndex) {
            if (word1[index] < word2[index]) {
                return word1
            } else if (word1[index] > word2[index]) {
                return word2
            }
            index++
        }
        return if (word1.length < word2.length) {
            word1
        } else {
            word2
        }
    }

    for (response in responses) {
        val set = mutableSetOf<String>()
        for (word in response) {
            set.add(word)
        }
        for (word in set) {
            counter[word] = counter.getOrDefault(word, 0) + 1
            if (counter.getOrDefault(word, 0) > maxCount) {
                maxCount = counter.getOrDefault(word, 0)
                result = word
            } else if (counter.getOrDefault(word, 0) == maxCount) {
                result = getSmallerLexicographicalWord(result, word)
            }
        }
    }
    return result
}

private fun main() {

}
