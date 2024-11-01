package leetcode.leetcode_2400_to_2499.leetcode_2404_most_frequent_even_element

import java.util.TreeMap

/**
 * Using treemap
 *
 * leetcode - https://leetcode.com/problems/most-frequent-even-element/
 *
 * Stats
 * Runtime: 423 ms, faster than 60.00%
 * Memory Usage: 43.3 MB, less than 50.00%
 *
 * Note: Use treemap as we have to return the smallest in case of tie
 */
private fun mostFrequentEven(nums: IntArray): Int {
    val map = TreeMap<Int, Int>()
    nums.forEach {
        if (it % 2 == 0) {
            map[it] = map.getOrDefault(it, 0) + 1
        }
    }
    return map.maxByOrNull { it.value }?.key ?: -1
}

/**
 * leetcode - https://leetcode.com/problems/most-frequent-even-element/
 *
 * Using sort
 *
 * Stats
 * Runtime: 387 ms, faster than 80.00%
 * Memory Usage: 39.2 MB, less than 70.00%
 */
private fun mostFrequentEvenUsingSort(nums: IntArray): Int {
    val sorted = nums.filter { it % 2 == 0 }.sorted()
    if (sorted.isEmpty()) {
        return -1
    }
    var candidate = sorted[0]
    var count = 1

    var result = candidate
    var maxCount = 1

    for (i in 1..sorted.lastIndex) {
        if (sorted[i] == candidate) {
            count++
            if (count > maxCount) {
                maxCount = count
                result = candidate
            }
        } else {
            count = 1
            candidate = sorted[i]
        }
    }
    return result
}

private fun main() {

}
