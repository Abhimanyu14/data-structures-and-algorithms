package leetcode.leet_1800_to_1899.leet_1856_maximum_subarray_min_product

import java.util.PriorityQueue
import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/maximum-subarray-min-product/
 *
 * TODO(Abhi) - To revisit
 *
 * Using priority queue
 *
 * Stats
 */
private fun maxSumMinProduct(nums: IntArray): Int {
    val priorityQueue = PriorityQueue<Pair<Int, Int>> { p1, p2 ->
        p1.first - p2.first
    }
    var result: Long = Long.MIN_VALUE
    var start = 0
    var end = nums.lastIndex
    var currentSum = 0
    nums.forEachIndexed { index, value ->
        currentSum += value
        priorityQueue.offer(Pair(value, index))
    }
    var temp: Pair<Int, Int>
    while (start <= end) {
        temp = priorityQueue.poll()
    }
    return (result % 1000_000_007).toInt()
}

/**
 * leetcode - https://leetcode.com/problems/maximum-subarray-min-product/
 *
 * Using brute force - O(n^2)
 *
 * Stats
 * Time Limit Exceeded
 */
private fun maxSumMinProductBruteForce(nums: IntArray): Int {
    var result: Long = Long.MIN_VALUE
    var currentSum: Long
    var currentMin: Int
    for (i in nums.indices) {
        currentSum = nums[i].toLong()
        currentMin = nums[i]
        result = max(result, currentSum * currentMin)
        for (j in (i + 1)..nums.lastIndex) {
            currentSum += nums[j]
            currentMin = min(currentMin, nums[j])
            result = max(result, currentSum * currentMin)
        }
    }
    return (result % 1000_000_007).toInt()
}

private fun main() {

}
