package leetcode.leetcode_791_custom_sort_string

/**
 * leetcode - https://leetcode.com/problems/custom-sort-string/
 *
 * Data Structure - [IntArray], [StringBuilder]
 * Algorithm - Counting
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 40.91 MB, less than 42.24%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun customSortString(order: String, s: String): String {
    val result = StringBuilder()
    val counter = IntArray(26)
    for (char in s) {
        counter[char - 'a']++
    }
    for (char in order) {
        while (counter[char - 'a'] > 0) {
            result.append(char)
            counter[char - 'a']--
        }
    }
    for (i in 0..25) {
        while (counter[i] > 0) {
            result.append('a' + i)
            counter[i]--
        }
    }
    return result.toString()
}

/**
 * leetcode - https://leetcode.com/problems/custom-sort-string/
 *
 * Data Structure - [Set], [Map]
 * Algorithm - Counting
 *
 * Difficulty -
 *
 * Stats
 * Runtime: 167 ms, faster than 41.75%
 * Memory Usage: 35.1 MB, less than 56.70%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun customSortStringUsingMap(order: String, s: String): String {
    val result = StringBuilder()
    val counter = mutableMapOf<Char, Int>()
    s.forEach {
        counter[it] = counter.getOrDefault(it, 0) + 1
    }
    val chars = counter.keys
    order.forEach {
        result.append("$it".repeat(counter.getOrDefault(it, 0)))
        chars.remove(it)
    }
    chars.forEach {
        result.append("$it".repeat(counter.getOrDefault(it, 0)))
    }
    return result.toString()
}

private fun main() {

}
