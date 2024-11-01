package leetcode.leetcode_700_to_799.leetcode_791_custom_sort_string

/**
 * leetcode - https://leetcode.com/problems/custom-sort-string/
 *
 * Using set and map
 *
 * Stats
 * Runtime: 167 ms, faster than 41.75%
 * Memory Usage: 35.1 MB, less than 56.70%
 */
private fun customSortString(order: String, s: String): String {
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
