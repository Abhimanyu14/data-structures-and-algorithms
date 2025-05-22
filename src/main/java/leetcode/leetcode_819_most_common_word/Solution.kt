package leetcode.leetcode_819_most_common_word

/**
 * leetcode - https://leetcode.com/problems/most-common-word/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 *
 * Data Structure - [Set], [StringBuilder], [Map]
 * Algorithm - Counting, Hashing, String Building and Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun mostCommonWord(paragraph: String, banned: Array<String>): String {
    val bannedSet = banned.toSet()
    var index = 0
    fun getNextWord(): String? {
        if (index >= paragraph.lastIndex) {
            return null
        }
        val word = StringBuilder()
        while (index <= paragraph.lastIndex && paragraph[index].isLetter()) {
            word.append(paragraph[index].lowercase())
            index++
        }
        while (index <= paragraph.lastIndex && !paragraph[index].isLetter()) {
            index++
        }
        return word.toString()
    }

    val counter = mutableMapOf<String, Int>()
    var maxCount = 0
    var result = ""
    var currentWord = getNextWord()
    while (currentWord != null) {
        if (!bannedSet.contains(currentWord)) {
            counter[currentWord] = counter.getOrDefault(currentWord, 0) + 1
            if (counter.getOrDefault(currentWord, 0) > maxCount) {
                result = currentWord
                maxCount = counter.getOrDefault(currentWord, 0)
            }
        }
        currentWord = getNextWord()
    }
    return result
}

private fun main() {

}
