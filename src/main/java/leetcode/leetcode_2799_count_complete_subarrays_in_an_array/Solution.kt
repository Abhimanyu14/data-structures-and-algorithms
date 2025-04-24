package leetcode.leetcode_2799_count_complete_subarrays_in_an_array

/**
 * leetcode - https://leetcode.com/problems/count-complete-subarrays-in-an-array/description/?envType=daily-question&envId=2025-04-24
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Set], [Array]
 * Algorithm - Counting
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N^2)
 * Space - O(N)
 *
 * Companies - Amazon
 */
private fun countCompleteSubarrays(nums: IntArray): Int {
    var result = 0
    val set = mutableSetOf<Int>()
    for (num in nums) {
        set.add(num)
    }
    val distinct = set.size
    for (i in nums.indices) {
        set.clear()
        for (j in i..nums.lastIndex) {
            set.add(nums[j])
            if (set.size == distinct) {
                result += (nums.size - j)
                break
            }
        }
    }
    return result
}

private fun main() {

}
