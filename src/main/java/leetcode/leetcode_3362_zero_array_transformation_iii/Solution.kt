package leetcode.leetcode_3362_zero_array_transformation_iii

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/zero-array-transformation-iii/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [PriorityQueue] (Max Heap), [IntArray]
 * Algorithm - Sorting, Heap and Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * N: nums.size
 * Q: queries.size
 * Time - O(Q * log(Q) + N * log(N))
 * Space - O(N)
 *
 * Companies - Google
 */
private fun maxRemoval(nums: IntArray, queries: Array<IntArray>): Int {
    // Sort by query start
    val sortedQueries = queries.sortedBy {
        it[0]
    }
    // Sort by query end
    val priorityQueue = PriorityQueue<IntArray> { a, b ->
        b[1] - a[1]
    }
    val prefixSum = IntArray(nums.size + 1)
    var currentSum = 0
    var queriesUsed = 0
    var queriesIndex = 0
    for (i in nums.indices) {
        // Add queries that start at ith index to the priority queue
        while (queriesIndex <= sortedQueries.lastIndex && sortedQueries[queriesIndex][0] == i) {
            priorityQueue.offer(sortedQueries[queriesIndex])
            queriesIndex++
        }
        currentSum += prefixSum[i]
        // Pick the query that ends at the last
        while (currentSum < nums[i] && priorityQueue.isNotEmpty()) {
            val currentQuery = priorityQueue.poll()
            if (currentQuery[1] < i) {
                return -1
            }
            queriesUsed++
            currentSum++
            prefixSum[currentQuery[1] + 1]--
        }
        if (currentSum < nums[i]) {
            return -1
        }
    }
    return sortedQueries.size - queriesUsed
}

/**
 * leetcode - https://leetcode.com/problems/zero-array-transformation-iii/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - PriorityQueue
 * Algorithm - Sorting and Heap iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 311 ms, faster than 23.08%
 * Memory Usage: 116.3 MB, less than 7.69%
 *
 * Time -
 * Space -
 */
private fun maxRemoval1(nums: IntArray, queries: Array<IntArray>): Int {
    var result = 0
    val startQueue = PriorityQueue<IntArray> { a, b ->
        a[0] - b[0] // Sort by start time in ascending
    }
    val availableQueue = PriorityQueue<IntArray> { a, b ->
        b[1] - a[1] // Sort by end time in descending
    }
    val inProgressQueue = PriorityQueue<IntArray> { a, b ->
        a[1] - b[1] // Sort by end time in ascending
    }
    queries.forEach {
        startQueue.offer(it)
    }
    var currentSum = 0
    for (i in nums.indices) {
        while (inProgressQueue.isNotEmpty() && inProgressQueue.first()[1] == i - 1) {
            inProgressQueue.poll()
            currentSum--
        }
        while (startQueue.isNotEmpty() && startQueue.first()[0] == i) {
            availableQueue.offer(startQueue.poll())
        }
        while (availableQueue.isNotEmpty() && currentSum < nums[i]) {
            val current = availableQueue.poll()
            if (current[1] >= i) {
                currentSum++
                inProgressQueue.offer(current)
                result++
            }
        }
        if (currentSum < nums[i]) {
            return -1
        }
    }
    return queries.size - result
}

private fun main() {

}
