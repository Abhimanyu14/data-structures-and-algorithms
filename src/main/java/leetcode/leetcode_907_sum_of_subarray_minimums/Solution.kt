package leetcode.leetcode_907_sum_of_subarray_minimums

import java.util.PriorityQueue
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/sum-of-subarray-minimums/
 *
 * TODO(Abhi) - To revisit
 *
 * Using brute force
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 *
 * Companies - Microsoft
 */
private fun sumSubarrayMins(arr: IntArray): Int {
    var result = 0
    val priorityQueue = PriorityQueue<Pair<Int, Int>> { a, b ->
        a.first - b.first
    }
    for (i in arr.indices) {
        priorityQueue.offer(Pair(arr[i], i))
    }
    while (priorityQueue.isNotEmpty()) {
        val (num, index) = priorityQueue.poll()
        var x = 0
        var y = 0
        var temp = index
        while (temp > 0 && arr[temp - 1] <= num) {
            temp--
            x++
        }
        temp = index
        while (temp < arr.lastIndex && arr[temp + 1] <= num) {
            temp++
            y++
        }
        result += (1 + x + y + (x * y)) * num
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/sum-of-subarray-minimums/
 *
 * TODO(Abhi) - To revisit
 *
 * Using brute force
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 *
 * Companies - Microsoft
 */
private fun sumSubarrayMinsUsingIteration(arr: IntArray): Int {
    var result = 0
    val map = mutableMapOf<Pair<Int, Int>, Int>()
    arr.forEachIndexed { index, num ->
        map[Pair(index, index)] = num
        result += num
    }
    for (i in 2..arr.size) {
        for (j in 0..(arr.lastIndex - i + 1)) {
            val temp = min(map.getOrDefault(Pair(j, j + i - 2), 0), arr[j + i - 1])
            map[Pair(j, j + i - 1)] = temp
            result += temp
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/sum-of-subarray-minimums/
 *
 * Using brute force
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 */
private fun sumSubarrayMinsUsingBruteForce(arr: IntArray): Int {
    var result = 0
    val map = mutableMapOf<Pair<Int, Int>, Int>()
    arr.forEachIndexed { index, num ->
        map[Pair(index, index)] = num
        result += num
    }
    for (i in 2..arr.size) {
        for (j in 0..(arr.lastIndex - i + 1)) {
            val temp = min(map.getOrDefault(Pair(j, j + i - 2), 0), arr[j + i - 1])
            map[Pair(j, j + i - 1)] = temp
            result += temp
        }
    }
    return result
}

private fun main() {

}
