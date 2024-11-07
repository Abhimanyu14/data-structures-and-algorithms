package leetcode.leetcode_2009_minimum_number_of_operations_to_make_array_continuous

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/
 *
 * TODO(Abhi) - To revisit
 *
 * Using sliding window
 *
 * Stats
 * Runtime: 675 ms, faster than 100.00%
 * Memory Usage: 61.1 MB, less than 100.00%
 */
fun minOperations(nums: IntArray): Int {
    val newNums = nums.toSet().toIntArray().sortedArray()
    var ans = nums.size
    var j = 0
    for (i in newNums.indices) {
        while (j < newNums.size && newNums[j] < newNums[i] + nums.size) {
            j++
        }
        val count = j - i
        ans = min(ans.toDouble(), (nums.size - count).toDouble()).toInt()
    }
    return ans
}

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/
 *
 * TODO(Abhi) - To revisit
 *
 * Using binary search
 *
 * Stats
 * Runtime: 675 ms, faster than 100.00%
 * Memory Usage: 61.1 MB, less than 100.00%
 */
fun minOperationsBinarySearch(nums: IntArray): Int {
    val newNums = nums.toSet().toIntArray().sortedArray()
    fun binarySearch(target: Int): Int {
        var left = 0
        var right = newNums.size
        while (left < right) {
            val mid = (left + right) / 2
            if (target < newNums[mid]) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    var ans = nums.size
    newNums.forEachIndexed { index, newNum ->
        ans = min(ans, (nums.size - (binarySearch(newNum + nums.lastIndex) - index)))
    }
    return ans
}

private fun main() {

}
