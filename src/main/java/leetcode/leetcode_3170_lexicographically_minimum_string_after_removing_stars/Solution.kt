package leetcode.leetcode_3170_lexicographically_minimum_string_after_removing_stars

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/submissions/1656145745/?envType=daily-question&envId=2025-06-07
 *
 * Data Structure - [PriorityQueue], [String], [StringBuilder], [Set]
 * Algorithm - Heapify, Hashing
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(N)
 *
 * Companies -
 */
private fun clearStars(s: String): String {
    val result = StringBuilder()
    val toSkip = mutableSetOf<Int>()
    val priorityQueue = PriorityQueue<Pair<Char, Int>> { a, b ->
        if (a.first == b.first) {
            b.second - a.second
        } else {
            a.first - b.first
        }
    }
    for (i in s.indices) {
        if (s[i] == '*') {
            toSkip.add(i)
            toSkip.add(priorityQueue.poll().second)
        } else {
            priorityQueue.offer(Pair(s[i], i))
        }
    }
    for (i in s.indices) {
        if (!toSkip.contains(i)) {
            result.append(s[i])
        }
    }
    return result.toString()
}

/**
 * leetcode - https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/submissions/1656145745/?envType=daily-question&envId=2025-06-07
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [String], [StringBuilder], [Array], [List], [Set]
 * Algorithm - Counting, Hashing
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N^2)
 * Space - O(N)
 *
 * Companies -
 */
private fun clearStarsUsingCounting(s: String): String {
    val result = StringBuilder()
    val counter = Array(26) {
        mutableListOf<Int>()
    }
    val toSkip = mutableSetOf<Int>()
    fun getNextIndexToDelete(): Int {
        for (i in 0..25) {
            if (counter[i].size > 0) {
                return counter[i].last()
            }
        }
        return -1
    }
    for (i in s.indices) {
        if (s[i] == '*') {
            val indexToDelete = getNextIndexToDelete()
            toSkip.add(i)
            toSkip.add(indexToDelete)
            counter[s[indexToDelete] - 'a'].remove(indexToDelete)
        } else {
            counter[s[i] - 'a'].add(i)
        }
    }
    for (i in s.indices) {
        if (!toSkip.contains(i)) {
            result.append(s[i])
        }
    }
    return result.toString()
}

private fun main() {

}
