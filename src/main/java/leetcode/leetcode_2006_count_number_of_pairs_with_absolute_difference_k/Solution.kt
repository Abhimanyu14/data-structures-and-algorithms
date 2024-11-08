package leetcode.leetcode_2006_count_number_of_pairs_with_absolute_difference_k

/**
 * leetcode - https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
 *
 * Using map
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 7 ms, faster than 92.31%
 * Memory Usage: 37.3 MB, less than 80.95%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun countKDifference(nums: IntArray, k: Int): Int {
    var result = 0
    val counter = mutableMapOf<Int, Int>()
    nums.forEach {
        counter[it] = counter.getOrDefault(it, 0) + 1
    }
    counter.forEach { (key, value) ->
        if (counter.contains(key + k)) {
            result += (value * counter.getOrDefault(key + k, 0))
        }
    }
    return result
}

private fun main() {

}
