package leetcode.leetcode_3545_minimum_deletions_for_at_most_k_distinct_characters

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/minimum-deletions-for-at-most-k-distinct-characters/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 *
 * Data Structure - [IntArray], [PriorityQueue]
 * Algorithm - Counting, Sorting
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun minDeletion(s: String, k: Int): Int {
    var result = 0
    val counter = IntArray(26)
    for (char in s) {
        counter[char - 'a']++
    }
    val priorityQueue = PriorityQueue<Int>()
    for (i in 0..25) {
        if (counter[i] > 0) {
            priorityQueue.offer(counter[i])
        }
    }
    while (priorityQueue.size > k) {
        result += priorityQueue.poll()
    }
    return result
}

private fun main() {

}
