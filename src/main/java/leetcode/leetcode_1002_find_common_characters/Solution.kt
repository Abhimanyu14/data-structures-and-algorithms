package leetcode.leetcode_1002_find_common_characters

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/find-common-characters/
 *
 * Data Structure - List and Map
 * Algorithm -
 *
 * Stats
 * Runtime: 289 ms, faster than 7.14%
 * Memory Usage: 40 MB, less than 7.14%
 */
private fun commonChars(words: Array<String>): List<String> {
    val map = mutableMapOf<Char, Int>()
    words[0].forEach {
        map[it] = (map[it] ?: 0) + 1
    }
    for (i in 1..words.lastIndex) {
        val wordCounts = mutableMapOf<Char, Int>()
        words[i].forEach { char ->
            wordCounts[char] = (wordCounts[char] ?: 0) + 1
        }
        val keysToRemove = map.keys.filterNot { wordCounts.containsKey(it) }
        keysToRemove.forEach { key ->
            map.remove(key)
        }

        map.forEach { (key, value) ->
            map[key] = min(value, wordCounts[key] ?: 0)
        }
    }
    return map.flatMap { (key, value) ->
        List(value) { key.toString() }
    }
}

private fun main() {

}
