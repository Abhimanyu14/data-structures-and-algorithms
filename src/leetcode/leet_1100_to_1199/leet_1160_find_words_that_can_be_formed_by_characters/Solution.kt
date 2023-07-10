package leetcode.leet_1100_to_1199.leet_1160_find_words_that_can_be_formed_by_characters

/**
 * leetcode - https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 *
 * Using map - char counter
 *
 * Stats
 * Runtime: 404 ms, faster than 66.67%
 * Memory Usage: 37.6 MB, less than 75.00%
 */
private fun countCharacters(words: Array<String>, chars: String): Int {
    val charCounter = mutableMapOf<Char, Int>()
    val wordMap = mutableMapOf<Char, Int>()
    var flag: Boolean
    chars.forEach {
        charCounter[it] = (charCounter[it] ?: 0) + 1
    }
    var result = 0
    words.forEach { word ->
        flag = true
        wordMap.clear()
        word.forEach {
            wordMap[it] = (wordMap[it] ?: 0) + 1
        }
        wordMap.forEach { (key, value) ->
            if (!charCounter.contains(key) || (charCounter[key] ?: 0) < value) {
                flag = false
            }
        }
        if (flag) {
            result += word.length
        }
    }
    return result
}

private fun main() {

}
