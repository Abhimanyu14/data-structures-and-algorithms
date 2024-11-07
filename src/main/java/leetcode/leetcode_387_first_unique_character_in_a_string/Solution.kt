package leetcode.leetcode_387_first_unique_character_in_a_string

/**
 * Using LinkedHashmap
 *
 * Stats
 * Runtime: 622 ms, faster than 16.19%
 * Memory Usage: 63.9 MB, less than 34.89%
 */
private fun firstUniqChar(s: String): Int {
    val linkedHashMap = linkedMapOf<Char, Int>()
    s.forEach { char ->
        linkedHashMap[char] = (linkedHashMap[char] ?: 0) + 1
    }
    for ((key, value) in linkedHashMap.asIterable()) {
        if (value == 1) {
            return s.indexOfFirst {
                it == key
            }
        }
    }
    return -1
}


private fun main() {
    println(firstUniqChar("leetcode"))
    println(firstUniqChar("loveleetcode"))
    println(firstUniqChar("aabb"))
}
