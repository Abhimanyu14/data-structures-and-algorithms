package leetcode.leetcode_3075_maximize_happiness_of_selected_children

import java.util.PriorityQueue
import kotlin.math.max


/**
 * leetcode - https://leetcode.com/problems/maximize-happiness-of-selected-children/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 818 ms, faster than 16.87%
 * Memory Usage: 80.8 MB, less than 16.87%
 *
 * Time -
 * Space -
 */
private fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
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
