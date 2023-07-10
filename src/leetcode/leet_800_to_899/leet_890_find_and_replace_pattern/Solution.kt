package leetcode.leet_800_to_899.leet_890_find_and_replace_pattern

/**
 * leetcode -
 *
 * Using map
 *
 * Stats
 * Runtime: 163 ms, faster than 100.00%
 * Memory Usage: 35.6 MB, less than 88.89%
 */
private fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
    val map = mutableMapOf<Char, Char>()
    val result = mutableListOf<String>()
    var flag: Boolean
    words.forEach { word ->
        map.clear()
        flag = true
        for (i in word.indices) {
            if (map.containsKey(word[i])) {
                if (map[word[i]] != pattern[i]) {
                    flag = false
                    break
                }
            } else {
                if (map.containsValue(pattern[i])) {
                    flag = false
                    break
                } else {
                    map[word[i]] = pattern[i]
                }
            }
        }
        if (flag) {
            result.add(word)
        }
    }
    return result
}

private fun main() {

}
