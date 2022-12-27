package leetcode.leet_300_to_399.leet_383_ransom_note

/**
 * leetcode - https://leetcode.com/problems/ransom-note/
 *
 * Using map
 *
 * Stats
 * Runtime: 579 ms, faster than 17.19%
 * Memory Usage: 53.7 MB, less than 24.22%
 */
private fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val map = mutableMapOf<Char, Int>()
    for (s in magazine) {
        map[s] = 1 + map.getOrDefault(s, 0)
    }
    for (s in ransomNote) {
        if (!map.contains(s) || map.getOrDefault(s, 0) == 0) {
            return false
        }
        map[s] = map.getOrDefault(s, 0) - 1
    }
    return true
}

private fun main() {

}
