package leetcode.leet_0_to_99.leet_35_search_insert_position

/**
 * Using binary search, loops
 *
 * Stats
 * Runtime: 192 ms, faster than 94.78%
 * Memory Usage: 37.7 MB, less than 73.79%
 */
private fun searchInsert(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.lastIndex
    while (low <= high) {
        val mid = ((high + low) / 2)
        if (nums[mid] == target) {
            return mid
        }
        if (target > nums[mid]) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    return low
}

private fun main() {
    println(searchInsert(intArrayOf(1, 3, 5, 6), 5))
    println(searchInsert(intArrayOf(1, 3, 5, 6), 2))
    println(searchInsert(intArrayOf(1, 3, 5, 6), 7))
}
