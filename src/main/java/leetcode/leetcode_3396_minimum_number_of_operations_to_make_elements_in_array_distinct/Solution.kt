package leetcode.leetcode_3396_minimum_number_of_operations_to_make_elements_in_array_distinct

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/?envType=daily-question&envId=2025-04-08
 *
 * Data Structure - [Set]
 * Algorithm - Iteration and Hashing
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Medium
 */
private fun minimumOperations(nums: IntArray): Int {
    val set = mutableSetOf<Int>()
    for (i in nums.lastIndex downTo 0) {
        if (set.contains(nums[i])) {
            return (i / 3) + 1
        } else {
            set.add(nums[i])
        }
    }
    return 0
}

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/?envType=daily-question&envId=2025-04-08
 *
 * Data Structure - [IntArray], [Set]
 * Algorithm -
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Medium
 */
private fun minimumOperationsUsingArray(nums: IntArray): Int {
    val counter = IntArray(101)
    val duplicates = mutableSetOf<Int>()
    for (num in nums) {
        counter[num]++
        if (counter[num] > 1) {
            duplicates.add(num)
        }
    }
    var result = 0
    var index = 0
    while (duplicates.isNotEmpty()) {
        result++
        if (index + 3 > nums.lastIndex) {
            duplicates.clear()
        } else {
            for (i in 0..2) {
                counter[nums[index]]--
                if (counter[nums[index]] == 1) {
                    duplicates.remove(nums[index])
                }
                index++
            }
        }
    }
    return result
}

private fun main() {

}
