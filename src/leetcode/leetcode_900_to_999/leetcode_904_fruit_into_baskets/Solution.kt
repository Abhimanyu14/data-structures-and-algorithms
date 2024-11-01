package leetcode.leetcode_900_to_999.leetcode_904_fruit_into_baskets

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/fruit-into-baskets/
 *
 * Using sliding window - two pointers
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 545 ms, faster than 6.10%
 * Memory Usage: 55.9 MB, less than 8.54%
 *
 * Time -
 * Space -
 */
private fun totalFruit(fruits: IntArray): Int {
    if (fruits.size <= 2) {
        return fruits.size
    }
    var left = 0
    var right = 0
    var result = 1
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
