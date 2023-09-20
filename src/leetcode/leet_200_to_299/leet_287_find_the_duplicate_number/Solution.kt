package leetcode.leet_200_to_299.leet_287_find_the_duplicate_number

/**
 * leetcode - https://leetcode.com/problems/find-the-duplicate-number/
 *
 * Using Array as hashmap
 *
 * Stats
 * Runtime: 406 ms, faster than 64.60%
 * Memory Usage: 57.7 MB, less than 17.26%
 */
private fun findDuplicate(nums: IntArray): Int {
    while (nums[0] != nums[nums[0]]) {
        nums[nums[0]] = nums[0].also {
            nums[0] = nums[nums[0]]
        }
    }
    return nums[0]
}

/**
 * leetcode - https://leetcode.com/problems/find-the-duplicate-number/
 *
 * Using Set
 *
 * Stats
 * Runtime: 476 ms, faster than 26.10%
 * Memory Usage: 59.2 MB, less than 5.31%
 */
private fun findDuplicateUsingSet(nums: IntArray): Int {
    val set = mutableSetOf<Int>()
    nums.forEach {
        if (set.contains(it)) {
            return it
        }
        set.add(it)
    }
    return -1
}

private fun main() {

}
