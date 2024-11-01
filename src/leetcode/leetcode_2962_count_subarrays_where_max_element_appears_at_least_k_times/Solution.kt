package leetcode.leetcode_2962_count_subarrays_where_max_element_appears_at_least_k_times

/**
 * leetcode - https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/
 *
 * Using list and max()
 *
 * Stats
 * Runtime: 598 ms, faster than 100.00%
 * Memory Usage: 67.7 MB, less than 100.00%
 */
private fun countSubarrays(nums: IntArray, k: Int): Long {
    val maxElement = nums.max()
    val indicesOfMaxElement: MutableList<Int> = ArrayList()
    var result = 0L

    for (i in nums.indices) {
        if (nums[i] == maxElement) {
            indicesOfMaxElement.add(i)
        }
        if (indicesOfMaxElement.size >= k) {
            result += (indicesOfMaxElement[indicesOfMaxElement.size - k] + 1)
        }
    }
    return result
}

private fun main() {

}
