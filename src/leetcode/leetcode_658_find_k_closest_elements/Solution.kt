package leetcode.leetcode_658_find_k_closest_elements

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/find-k-closest-elements/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 *
 */
private fun main() {
    val priorityQueue = PriorityQueue<Pair<Int, Int>> { a, b ->
        if (a.first == b.first) {
            a.second - b.second
        } else {
            a.first - b.first
        }
    }
    priorityQueue.offer(Pair(2, 0))
    priorityQueue.offer(Pair(1, 1))
    priorityQueue.offer(Pair(0, 2))
    priorityQueue.offer(Pair(1, 3))
    priorityQueue.offer(Pair(2, 4))
    println(priorityQueue)
}
