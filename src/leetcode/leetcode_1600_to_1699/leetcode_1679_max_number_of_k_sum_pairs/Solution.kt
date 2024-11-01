package leetcode.leetcode_1600_to_1699.leetcode_1679_max_number_of_k_sum_pairs

/**
 * leetcode - https://leetcode.com/problems/max-number-of-k-sum-pairs/
 *
 * Using map
 *
 * Stats
 * Runtime: 484 ms, faster than 49.62%
 * Memory Usage: 56.4 MB, less than 49.62%
 */
private fun maxOperations(nums: IntArray, k: Int): Int {
    var result = 0
    val map = mutableMapOf<Int, Int>()
    nums.forEach {
        if (map.getOrDefault(it, 0) > 0) {
            result++
            map[it] = map.getOrDefault(it, 0) - 1
        } else {
            map[k - it] = map.getOrDefault(k - it, 0) + 1
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/max-number-of-k-sum-pairs/
 *
 * Using sorting and two pointer
 *
 * Stats
 * Runtime: 682 ms, faster than 17.56%
 * Memory Usage: 53.9 MB, less than 85.50%
 */
private fun maxOperationsUsingSorting(nums: IntArray, k: Int): Int {
    val sorted = nums.sorted()
    var start = 0
    var end = sorted.lastIndex
    var result = 0
    while (start < end) {
        if (sorted[start] + sorted[end] == k) {
            start++
            end--
            result++
        } else if (sorted[start] + sorted[end] < k) {
            start++
        } else {
            end--
        }
    }
    return result
}

private fun main() {

}
