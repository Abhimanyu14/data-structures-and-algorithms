package leetcode.leetcode_1000_to_1099.leetcode_1095_find_in_mountain_array

/**
 * leetcode - https://leetcode.com/problems/find-in-mountain-array/
 *
 * TODO(Abhi) - To revisit
 *
 * Using binary search
 *
 * Stats
 * Runtime: 167 ms, faster than 83.33%
 * Memory Usage: 37.7 MB, less than 8.33%
 */
private fun findInMountainArray(target: Int, mountainArr: MountainArray): Int {
    // Save the length of the mountain array
    val length: Int = mountainArr.length()

    // 1. Find the index of the peak element
    var low = 1
    var high = length - 2
    while (low != high) {
        val testIndex = low + high shr 1
        val curr: Int = mountainArr.get(testIndex)
        val next: Int = mountainArr.get(testIndex + 1)
        if (curr < next) {
            if (curr == target) {
                return testIndex
            }
            if (next == target) {
                return testIndex + 1
            }
            low = testIndex + 1
        } else {
            high = testIndex
        }
    }
    val peakIndex = low

    // 2. Search in the strictly increasing part of the array
    // If found, will be returned in the loop itself.
    low = 0
    high = peakIndex
    while (low <= high) {
        val testIndex = low + high shr 1
        val curr: Int = mountainArr.get(testIndex)
        if (curr == target) {
            return testIndex
        } else if (curr < target) {
            low = testIndex + 1
        } else {
            high = testIndex - 1
        }
    }

    // 3. Search in the strictly decreasing part of the array
    // If found, will be returned in the loop itself.
    low = peakIndex + 1
    high = length - 1
    while (low <= high) {
        val testIndex = low + high shr 1
        val curr: Int = mountainArr.get(testIndex)
        if (curr == target) {
            return testIndex
        } else if (curr > target) {
            low = testIndex + 1
        } else {
            high = testIndex - 1
        }
    }

    // Target is not present in the mountain array
    return -1
}

private fun main() {

}

private class MountainArray {
    fun get(index: Int): Int {
        return 0
    }

    fun length(): Int {
        return 0
    }
}
