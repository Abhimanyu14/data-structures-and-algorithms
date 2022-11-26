package leetcode.leet_200_to_299.leet_290_word_pattern

/**
 * Using map
 *
 * Stats
 * Runtime: 210 ms, faster than 79.31%
 * Memory Usage: 36.3 MB, less than 39.08%
 */
private fun wordPattern(pattern: String, s: String): Boolean {
    val words = s.trim().split(" ")
    if (pattern.length != words.size) {
        return false
    }
    val map = hashMapOf<Char, String>()
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

fun main() {
    println(wordPattern("abba", "dog cat cat dog"))
    println(wordPattern("abba", "dog cat cat fish"))
    println(wordPattern("aaaa", "dog cat cat dog"))
}
