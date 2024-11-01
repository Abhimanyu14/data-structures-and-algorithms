package leetcode.leetcode_200_to_299.leetcode_229_majority_element_ii

/**
 * leetcode - https://leetcode.com/problems/majority-element-ii/
 *
 * Using map - counter
 *
 * Stats
 * Runtime: 237 ms, faster than 48.28%
 * Memory Usage: 39.8 MB, less than 79.31%
 */
private fun majorityElement(nums: IntArray): List<Int> {
    val counter = mutableMapOf<Int, Int>()
    nums.forEach {
        counter[it] = counter.getOrDefault(it, 0) + 1
    }
    val result = mutableListOf<Int>()
    counter.forEach { (key, value) ->
        if (value > (nums.size / 3)) {
            result.add(key)
        }
    }
    return result
}

private fun main() {

}
