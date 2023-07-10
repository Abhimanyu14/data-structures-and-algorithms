package leetcode.leet_200_to_299.leet_290_word_pattern

/**
 * leetcode - https://leetcode.com/problems/word-pattern/
 *
 * Using map - containsKey(), containsValue()
 *
 * Stats
 * Runtime: 170 ms, faster than 81.13%
 * Memory Usage: 35.9 MB, less than 73.58%
 */
private fun wordPattern(pattern: String, s: String): Boolean {
    val words = s.trim().split(" ")
    if (pattern.length != words.size) {
        return false
    }
    val map = mutableMapOf<Char, String>()
    pattern.forEachIndexed { index, c ->
        if (map.containsKey(c) || map.containsValue(words[index])) {
            if (map[c] != words[index]) {
                return false
            }
        } else {
            map[c] = words[index]
        }
    }
    return true
}

private fun main() {
    println(wordPattern("abba", "dog cat cat dog"))
    println(wordPattern("abba", "dog cat cat fish"))
    println(wordPattern("aaaa", "dog cat cat dog"))
}
