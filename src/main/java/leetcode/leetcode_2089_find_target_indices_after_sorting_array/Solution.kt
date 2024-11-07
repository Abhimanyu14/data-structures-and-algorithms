package leetcode.leetcode_2089_find_target_indices_after_sorting_array

/**
 * leetcode - https://leetcode.com/problems/find-target-indices-after-sorting-array/
 *
 * Using
 *
 * Stats
 * Runtime: 183 ms, faster than 100.00%
 * Memory Usage: 38.3 MB, less than 90.48%
 */
private fun targetIndices(nums: IntArray, target: Int): List<Int> {
    var lessCount = 0
    var count = 0
    nums.forEach {
        if (it == target) {
            count++
        } else if (it < target) {
            lessCount++
        }
    }
    val result = mutableListOf<Int>()
    for (i in lessCount until (lessCount + count)) {
        result.add(i)
    }
    return result
}

private fun main() {

}
