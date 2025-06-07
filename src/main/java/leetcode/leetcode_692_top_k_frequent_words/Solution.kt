package leetcode.leetcode_692_top_k_frequent_words

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/top-k-frequent-words/description/?envType=company&envId=netflix&favoriteSlug=netflix-all
 *
 * TODO(Abhi) - To optimize
 *
 * Data Structure - [List], [Map], [PriorityQueue],
 * Algorithm - Counting, Heapify, String comparison
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Google, Meta, Microsoft, Netflix
 */
private fun topKFrequent(words: Array<String>, k: Int): List<String> {
    val result = mutableListOf<String>()
    val counter = mutableMapOf<String, Int>()
    for (word in words) {
        counter[word] = counter.getOrDefault(word, 0) + 1
    }
    val priorityQueue = PriorityQueue<Pair<Int, String>> { a, b ->
        if (a.first == b.first) {
            a.second.compareTo(b.second)
        } else {
            b.first - a.first
        }
    }
    for ((key, value) in counter) {
        priorityQueue.offer(Pair(value, key))
    }
    repeat(k) {
        result.add(priorityQueue.poll().second)
    }
    return result
}

private fun main() {

}
