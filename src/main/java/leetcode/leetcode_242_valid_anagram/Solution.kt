package leetcode.leetcode_242_valid_anagram

/**
 * leetcode - https://leetcode.com/problems/valid-anagram/
 *
 * Data Structure - Array
 * Algorithm - Counting
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 345 ms, faster than 52.65%
 * Memory Usage: 38.7 MB, less than 82.49%
 *
 * Time - O(N)
 * Space - O(26)
 */
private fun isAnagramUsingArray(s: String, t: String): Boolean {
    val counter = IntArray(26)
    t.forEach { counter[it - 'a']++ }
    s.forEach { counter[it - 'a']-- }
    return counter.all { it == 0 }
}

/**
 * leetcode - https://leetcode.com/problems/valid-anagram/
 *
 * Data Structure - Map
 * Algorithm - Counting
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 329 ms, faster than 59.68%
 * Memory Usage: 42.1 MB, less than 56.22%
 *
 * Time - O(N)
 * Space - O(26)
 */
private fun isAnagram(s: String, t: String): Boolean {
    val map = mutableMapOf<Char, Int>()
    s.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }
    t.forEach {
        if (map.containsKey(it)) {
            if (map[it] == 1) {
                map.remove(it)
            } else {
                map[it] = map.getOrDefault(it, 0) - 1
            }
        } else {
            return false
        }
    }
    return map.isEmpty()
}

private fun main() {

}
