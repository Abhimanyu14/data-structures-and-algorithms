package leetcode.leetcode_347_top_k_frequent_elements

import java.util.PriorityQueue
import java.util.TreeMap

/**
 * leetcode - https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Data Structure - [Map], [PriorityQueue]
 * Algorithm - Counting, MinHeap
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 28 ms, faster than 72.44%
 * Memory Usage: 41.3 MB, less than 79.97%
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val counter = mutableMapOf<Int, Int>()
    for (num in nums) {
        counter[num] = counter.getOrDefault(num, 0) + 1
    }
    val minHeap = PriorityQueue<Pair<Int, Int>> { a, b ->
        a.first - b.first
    }
    for ((key, value) in counter) {
        minHeap.offer(Pair(value, key))
        if (minHeap.size > k) {
            minHeap.poll()
        }
    }
    val result = mutableListOf<Int>()
    while (minHeap.isNotEmpty()) {
        result.add(minHeap.poll().second)
    }
    return result.toIntArray()
}

/**
 * leetcode - https://leetcode.com/problems/top-k-frequent-elements/
 * ms/top-k-frequent-elements/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Map]
 * Algorithm - Counting, MinHeap
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 28 ms, faster than 72.44%
 * Memory Usage: 41.3 MB, less than 79.97%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun topKFrequentUsingFunctional(nums: IntArray, k: Int): IntArray {
    val frequencyCounter = mutableMapOf<Int, Int>()
    nums.forEach {
        frequencyCounter[it] = frequencyCounter.getOrDefault(it, 0) + 1
    }
    val list = mutableListOf<IntArray>()
    frequencyCounter.forEach { (num, frequency) ->
        list.add(intArrayOf(frequency, num))
    }
    list.sortByDescending {
        it[0]
    }
    return list
        .take(k)
        .map {
            it[1]
        }
        .toIntArray()
}

/**
 * leetcode - https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Data Structure - Map and TreeMap
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 65 ms, faster than 5.51%
 * Memory Usage: 41.3 MB, less than 79.97%
 *
 * Time -
 * Space -
 */
private fun topKFrequentUsingTreemap(nums: IntArray, k: Int): IntArray {
    val frequencyCounter = mutableMapOf<Int, Int>()
    nums.forEach {
        frequencyCounter[it] = frequencyCounter.getOrDefault(it, 0) + 1
    }
    val treeMap = TreeMap<Int, MutableList<Int>>()
    frequencyCounter.forEach { (key, value) ->
        treeMap.computeIfAbsent(value) { mutableListOf() }.add(key)
    }
    val result = mutableListOf<Int>()
    for (entry in treeMap.entries.reversed()) {
        for (item in entry.value) {
            result.add(item)
            if (result.size == k) {
                return result.toIntArray()
            }
        }
    }
    return intArrayOf()
}

private fun main() {

}
