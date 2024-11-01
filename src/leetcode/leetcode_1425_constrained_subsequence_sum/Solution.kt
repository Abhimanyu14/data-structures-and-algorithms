package leetcode.leetcode_1425_constrained_subsequence_sum

import java.util.PriorityQueue
import kotlin.math.max


/**
 * leetcode - https://leetcode.com/problems/constrained-subsequence-sum/
 *
 * TODO(Abhi) - To revisit
 *
 * Using priority queue
 *
 * Stats
 * Runtime: 656 ms, faster than 100.00%
 * Memory Usage: 59.7 MB, less than 100.00%
 */
private fun constrainedSubsetSum(nums: IntArray, k: Int): Int {
    val priorityQueue = PriorityQueue { a: IntArray, b: IntArray ->
        b[0] - a[0]
    }
    priorityQueue.add(intArrayOf(nums[0], 0))
    var result = nums[0]
    for (i in 1..nums.lastIndex) {
        while (i - priorityQueue.peek()[1] > k) {
            priorityQueue.remove()
        }
        val curr = max(0, priorityQueue.peek()[0]) + nums[i]
        result = max(result, curr)
        priorityQueue.add(intArrayOf(curr, i))
    }
    return result
}

private fun main() {

}
