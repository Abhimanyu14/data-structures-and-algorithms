package leetcode.leetcode_33_search_in_rotated_sorted_array

/**
 * leetcode - https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 *
 */
private fun search(nums: IntArray, target: Int): Int {
    fun binarySearch(start: Int, end: Int) : Int {
        var low = start
        var high = end
        var mid: Int
        while (low <= high) {
            mid = low + ((high - low) / 2)
            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] < target) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        return -1
    }
    fun driver(start: Int, end: Int): Int {
        if (nums[end] < nums[start]) {
            val mid = end + ((start - end) / 2)
            return if (nums[mid] == target) {
                mid
            } else if (nums[mid] > nums[start]) {
                if (target >= nums[start] && target < nums[mid]) {
                    binarySearch(start, mid - 1)
                } else {
                    driver(mid + 1, end)
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    binarySearch(mid + 1, end)
                } else {
                    driver(start, mid - 1)
                }
            }
        } else {
            return binarySearch(start, end)
        }
    }

    return driver(0, nums.lastIndex)
}

private fun main() {

}
