package leetcode.leetcode_689_maximum_sum_of_3_non_overlapping_subarrays

/**
 * leetcode - https://leetcode.com/classic/problems/maximum-sum-of-3-non-overlapping-subarrays/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Three Pointers
 * Algorithm - Sliding Window
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(N + k)
 * Space - O(1)
 */
private fun maxSumOfThreeSubarrays(nums: IntArray, k: Int): IntArray {
    // Variables to track the best indices for one, two, and three subarray configurations
    var bestSingleStart = 0
    val bestDoubleStart = intArrayOf(0, k)
    val bestTripleStart = intArrayOf(0, k, k * 2)

    // Compute the initial sums for the first three subarrays
    var currentWindowSumSingle = 0
    for (i in 0..<k) {
        currentWindowSumSingle += nums[i]
    }

    var currentWindowSumDouble = 0
    for (i in k..<k * 2) {
        currentWindowSumDouble += nums[i]
    }

    var currentWindowSumTriple = 0
    for (i in k * 2..<k * 3) {
        currentWindowSumTriple += nums[i]
    }

    // Track the best sums found so far
    var bestSingleSum = currentWindowSumSingle
    var bestDoubleSum = currentWindowSumSingle + currentWindowSumDouble
    var bestTripleSum = currentWindowSumSingle + currentWindowSumDouble + currentWindowSumTriple

    // Sliding window pointers for the subarrays
    var singleStartIndex = 1
    var doubleStartIndex = k + 1
    var tripleStartIndex = k * 2 + 1

    // Slide the windows across the array
    while (tripleStartIndex <= nums.size - k) {
        // Update the sums using the sliding window technique
        currentWindowSumSingle = currentWindowSumSingle - nums[singleStartIndex - 1] + nums[singleStartIndex + k - 1]
        currentWindowSumDouble = currentWindowSumDouble - nums[doubleStartIndex - 1] + nums[doubleStartIndex + k - 1]
        currentWindowSumTriple = currentWindowSumTriple - nums[tripleStartIndex - 1] + nums[tripleStartIndex + k - 1]

        // Update the best single subarray start index if a better sum is found
        if (currentWindowSumSingle > bestSingleSum) {
            bestSingleStart = singleStartIndex
            bestSingleSum = currentWindowSumSingle
        }

        // Update the best double subarray start indices if a better sum is found
        if (currentWindowSumDouble + bestSingleSum > bestDoubleSum) {
            bestDoubleStart[0] = bestSingleStart
            bestDoubleStart[1] = doubleStartIndex
            bestDoubleSum = currentWindowSumDouble + bestSingleSum
        }

        // Update the best triple subarray start indices if a better sum is found
        if (currentWindowSumTriple + bestDoubleSum > bestTripleSum) {
            bestTripleStart[0] = bestDoubleStart[0]
            bestTripleStart[1] = bestDoubleStart[1]
            bestTripleStart[2] = tripleStartIndex
            bestTripleSum = currentWindowSumTriple + bestDoubleSum
        }

        // Move the sliding windows forward
        singleStartIndex += 1
        doubleStartIndex += 1
        tripleStartIndex += 1
    }

    // Return the starting indices of the three subarrays with the maximum sum
    return bestTripleStart
}

/**
 * leetcode - https://leetcode.com/classic/problems/maximum-sum-of-3-non-overlapping-subarrays/
 *
 * Data Structure -
 * Algorithm - Recursion
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(2 ^ N)
 * Space - O(N)
 */
private fun maxSumOfThreeSubarraysUsingBruteForce(nums: IntArray, k: Int): IntArray {
    fun pick(index: Int, picked: List<Int>, currentSum: Int): Pair<List<Int>, Int> {
        if (picked.size == 3) {
            return Pair(picked, currentSum)
        }
        if (index + ((3 - picked.size) * k) - 1 > nums.lastIndex) {
            return Pair(listOf(), -1)
        }
        var sum = 0
        for (i in 0..<k) {
            sum += nums[index + i]
        }
        val ifPicked = pick(index + k, picked + index, currentSum + sum)
        val ifNotPicked = pick(index + 1, picked, currentSum)
        return if (ifPicked.second >= ifNotPicked.second) {
            ifPicked
        } else {
            ifNotPicked
        }
    }
    return pick(0, listOf(), 0).first.toIntArray()
}

private fun main() {

}
