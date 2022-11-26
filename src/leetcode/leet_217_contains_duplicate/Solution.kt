package leetcode.leet_217_contains_duplicate

/**
 * Using hashset
 *
 * Stats
 * Runtime: Runtime: 679 ms, faster than 80.36%
 * Memory Usage: 69.3 MB, less than 79.46%
 */
private fun containsDuplicate(nums: IntArray): Boolean {
    val hashSet = hashSetOf<Int>()
    for (i in nums.indices) {
        if (hashSet.contains(nums[i])) {
            return true
        }
        hashSet.add(nums[i])
    }
    return false
}

private fun main() {
    println(containsDuplicate(intArrayOf(1, 2, 3, 1)))
    println(containsDuplicate(intArrayOf(1, 2, 3, 4)))
    println(containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4)))
}
