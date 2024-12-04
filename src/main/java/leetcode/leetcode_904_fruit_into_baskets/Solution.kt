package leetcode.leetcode_904_fruit_into_baskets

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/fruit-into-baskets/
 *
 * Data Structure - Two Pointers
 * Algorithm - Sliding Window
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 93 ms, faster than 10.00%
 * Memory Usage: 57.5 MB, less than 5.63%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun totalFruit(fruits: IntArray): Int {
    if (fruits.size <= 2) {
        return fruits.size
    }
    var result = 1
    var left = 0
    var right = 0
    val counter = mutableMapOf<Int, Int>()
    counter[fruits[0]] = 1
    while (right < fruits.lastIndex) {
        right++
        if (counter.size == 2 && !counter.contains(fruits[right])) {
            while (counter.size == 2) {
                if (counter.getOrDefault(fruits[left], 0) == 1) {
                    counter.remove(fruits[left])
                } else {
                    counter[fruits[left]] = counter.getOrDefault(fruits[left], 0) - 1
                }
                left++
            }
        }
        counter[fruits[right]] = counter.getOrDefault(fruits[right], 0) + 1
        result = max(result, right - left + 1)
    }
    return result
}

private fun main() {

}
