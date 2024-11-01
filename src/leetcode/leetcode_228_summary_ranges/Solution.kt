package leetcode.leetcode_228_summary_ranges

/**
 * leetcode - https://leetcode.com/problems/summary-ranges/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 157 ms, faster than 51.02%
 * Memory Usage: 37.9 MB, less than 17.86%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun summaryRanges(nums: IntArray): List<String> {
    if (nums.isEmpty()) {
        return emptyList()
    }
    val result = mutableListOf<String>()
    var start = nums[0]
    var current = nums[0]
    for (i in 1..nums.lastIndex) {
        if (nums[i] == current + 1) {
            current++
        } else {
            if (start == current) {
                result.add("$start")
            } else {
                result.add("$start->$current")
            }
            start = nums[i]
            current = nums[i]
        }
    }
    if (start == current) {
        result.add("$start")
    } else {
        result.add("$start->$current")
    }
    return result
}

private fun main() {

}
