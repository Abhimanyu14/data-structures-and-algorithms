package leetcode.leetcode_2593_find_score_of_an_array_after_marking_all_elements

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/?envType=daily-question&envId=2024-12-13
 *
 * Data Structure - PriorityQueue and Set
 * Algorithm - Heapify and Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 369 ms, faster than 100.00%
 * Memory Usage: 68.1 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun findScore(nums: IntArray): Long {
    var result = 0L
    val priorityQueue = PriorityQueue<Pair<Int, Int>> { a, b ->
        if (a.first == b.first) {
            a.second - b.second
        } else {
            a.first - b.first
        }
    }
    for (i in nums.indices) {
        priorityQueue.offer(Pair(nums[i], i))
    }
    val visited = mutableSetOf<Int>()
    var current: Pair<Int, Int>
    while (priorityQueue.isNotEmpty()) {
        current = priorityQueue.poll()
        if (!visited.contains(current.second)) {
            result += current.first
            visited.add(current.second)
            if (current.second > 0) {
                visited.add(current.second - 1)
            }
            if (current.second < nums.lastIndex) {
                visited.add(current.second + 1)
            }
        }
    }
    return result
}

private fun main() {

}
