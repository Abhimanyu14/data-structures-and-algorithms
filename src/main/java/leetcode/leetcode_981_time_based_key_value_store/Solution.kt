package leetcode.leetcode_981_time_based_key_value_store

import java.util.SortedMap

/**
 * leetcode - https://leetcode.com/problems/time-based-key-value-store/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Map], [List]
 * Algorithm - Binary Search
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Google, Meta
 */
private class TimeMap {
    val map = mutableMapOf<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        map.computeIfAbsent(key) { mutableListOf() }.add(Pair(timestamp, value))
    }

    fun get(key: String, timestamp: Int): String {
        val values = map.getOrDefault(key, emptyList())
        var left = 0
        var right = values.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (values[mid].first > timestamp) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return if (left == 0) {
            ""
        } else {
            values[left - 1].second
        }
    }
}


/**
 * leetcode - https://leetcode.com/problems/time-based-key-value-store/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Map], [SortedMap]
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 *
 * Companies - Google, Meta
 */
private class TimeMapUsingLinearSearch {
    val map = mutableMapOf<String, SortedMap<Int, String>>()

    fun set(key: String, value: String, timestamp: Int) {
        map.computeIfAbsent(key) {
            sortedMapOf()
        }[timestamp] = value
    }

    fun get(key: String, timestamp: Int): String {
        var result = ""
        for ((prevTimestamp, value) in (map[key] ?: emptyMap())) {
            if (prevTimestamp <= timestamp) {
                result = value
            } else {
                break
            }
        }
        return result
    }
}

private fun main() {

}
