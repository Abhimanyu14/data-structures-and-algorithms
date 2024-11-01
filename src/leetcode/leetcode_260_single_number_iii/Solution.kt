package leetcode.leetcode_260_single_number_iii

/**
 * leetcode - https://leetcode.com/problems/single-number-iii/submissions/
 *
 * Using set
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 205 ms, faster than 45.95%
 * Memory Usage: 38.2 MB, less than 37.84%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun singleNumber(nums: IntArray): IntArray {
    val set = mutableSetOf<Int>()
    nums.forEach {
        if (set.contains(it)) {
            set.remove(it)
        } else {
            set.add(it)
        }
    }
    return set.toIntArray()
}

private fun main() {

}
