package leetcode.leetcode_2784_check_if_array_is_good

/**
 * leetcode - https://leetcode.com/problems/check-if-array-is-good/
 *
 * Data Structure - Set
 * Algorithm -
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 5 ms, faster than 75.00%
 * Memory Usage: 41.5 MB, less than 25.00%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun isGood(nums: IntArray): Boolean {
    val set = mutableSetOf<Int>()
    var lastNumCount = 0
    for (num in nums) {
        set.add(num)
        if (num == nums.size - 1) {
            lastNumCount++
        }
    }
    repeat(nums.size - 2) {
        if (set.contains(it + 1)) {
            set.remove(it + 1)
        } else {
            return false
        }
    }
    return lastNumCount == 2 && set.isEmpty()
}

private fun main() {

}
