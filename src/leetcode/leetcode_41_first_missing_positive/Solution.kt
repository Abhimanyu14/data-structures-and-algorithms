package leetcode.leetcode_41_first_missing_positive

/**
 * leetcode - https://leetcode.com/problems/first-missing-positive/
 *
 * Using Input modification - cycle sort
 *
 * Stats
 * Runtime: 308 ms, faster than 94.62%
 * Memory Usage: 51.5 MB, less than 69.23%
 *
 * Time - O(N)
 * Space = O(N) - Auxiliary = O(1)
 */
private fun firstMissingPositive(nums: IntArray): Int {
    var i = 0
    while (i < nums.size) {
        if (nums[i] in 1..nums.size && nums[nums[i] - 1] != nums[i]) {
            nums[nums[i] - 1] = nums[i].also {
                nums[i] = nums[nums[i] - 1]
            }
        } else {
            i++
        }
    }
    i = 0
    while (i < nums.size) {
        if (nums[i] != i + 1) {
            return i + 1
        }
        i++
    }
    return nums.size + 1
}

/**
 * leetcode - https://leetcode.com/problems/first-missing-positive/
 *
 * Using Set
 *
 * Stats
 * Runtime: 1351 ms, faster than 48.69%
 * Memory Usage: 139 MB, less than 57.07%
 *
 * Time - O(N)
 * Space = O(N)
 */
private fun firstMissingPositiveUsingSet(nums: IntArray): Int {
    var result = 1
    val set = nums.toSet()
    while (set.contains(result)) {
        result++
    }
    return result
}

private fun main() {
    println(firstMissingPositive(intArrayOf(1, 2, 0)))
    println(firstMissingPositive(intArrayOf(3, 4, -1, 1)))
    println(firstMissingPositive(intArrayOf(7, 8, 9, 11, 12)))
}
