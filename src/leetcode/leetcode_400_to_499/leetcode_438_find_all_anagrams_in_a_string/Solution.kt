package leetcode.leetcode_400_to_499.leetcode_438_find_all_anagrams_in_a_string

/**
 * leetcode - https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * Using sliding window
 *
 * Stats
 * Runtime: 340 ms, faster than 48.18%
 * Memory Usage: 39.4 MB, less than 49.64%
 */
private fun findAnagrams(s: String, p: String): List<Int> {
    if (s.length < p.length) {
        return emptyList()
    }

    val pCounter = mutableMapOf<Char, Int>()
    p.forEach {
        pCounter[it] = pCounter.getOrDefault(it, 0) + 1
    }

    val windowCounter = mutableMapOf<Char, Int>()
    val result = mutableListOf<Int>()
    var start = 0
    var end = 0
    while (end < p.length) {
        windowCounter[s[end]] = windowCounter.getOrDefault(s[end], 0) + 1
        end++
    }

    fun isValid(): Boolean {
        for ((key, value) in pCounter) {
            if (windowCounter.getOrDefault(key, 0) != value) {
                return false
            }
        }
        return true
    }

    while (end < s.length) {
        if (isValid()) {
            result.add(start)
        }
        windowCounter[s[end]] = windowCounter.getOrDefault(s[end], 0) + 1
        end++
        windowCounter[s[start]] = windowCounter.getOrDefault(s[start], 0) - 1
        start++
    }
    if (isValid()) {
        result.add(start)
    }

    return result
}

private fun main() {

}
