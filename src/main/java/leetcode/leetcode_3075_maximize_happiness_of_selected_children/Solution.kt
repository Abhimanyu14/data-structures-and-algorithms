package leetcode.leetcode_3075_maximize_happiness_of_selected_children

import java.util.PriorityQueue
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximize-happiness-of-selected-children/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Array
 * Algorithm - Sorting
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(N)
 *
 * Companies - Amazon
 */
private fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
    var result = 0L
    val sorted = happiness.sortedArrayDescending()
    for (i in 0..<k) {
        result += max(0, sorted[i] - i)
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/maximize-happiness-of-selected-children/
 *
 * Data Structure - PriorityQueue
 * Algorithm - Heapify
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N * log(N) + K * log(K))
 * Space - O(N)
 *
 * Companies - Amazon
 */
private fun maximumHappinessSumUsingPriorityQueue(happiness: IntArray, k: Int): Long {
    var result = 0L
    val priorityQueue = PriorityQueue<Int>(k) { a, b ->
        b - a
    }
    happiness.forEach {
        priorityQueue.offer(it)
    }
    var i = k
    while (i > 0) {
        val toAdd = max(0, priorityQueue.poll() - (k - i))
        if (toAdd == 0) {
            break
        }
        result += toAdd
        i--
    }
    return result
}

private fun main() {

}
