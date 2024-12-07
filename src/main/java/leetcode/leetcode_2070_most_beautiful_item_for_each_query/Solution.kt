package leetcode.leetcode_2070_most_beautiful_item_for_each_query

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/most-beautiful-item-for-each-query/?envType=daily-question&envId=2024-11-12
 *
 * Data Structure - [linkedMapOf], [listOf]
 * Algorithm - Binary Search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 115 ms, faster than 100.00%
 * Memory Usage: 126 MB, less than 50.00%
 *
 * Time -
 * Space -
 */
private fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
    val result = IntArray(queries.size)
    val map = sortedMapOf<Int, Int>()
    items.forEach { (price, beauty) ->
        if (!map.contains(price) || map.getOrDefault(price, 0) < beauty) {
            map[price] = beauty
        }
    }
    val list = mutableListOf<Pair<Int, Int>>()
    var maxSoFar = 0
    map.forEach { (price, beauty) ->
        maxSoFar = max(maxSoFar, beauty)
        list.add(Pair(price, maxSoFar))
    }
    queries.forEachIndexed { index, query ->
        if (query < list[0].first) {
            result[index] = 0
        } else {
            var left = 0
            var right = list.size
            var mid = 0
            while (left < right) {
                mid = left + ((right - left) / 2)
                if (list[mid].first > query) {
                    right = mid
                } else {
                    left = mid + 1
                }
            }
            result[index] = list[left - 1].second
        }
    }
    return result
}

private fun main() {

}
