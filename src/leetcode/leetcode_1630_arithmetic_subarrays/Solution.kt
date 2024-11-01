package leetcode.leetcode_1630_arithmetic_subarrays

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/arithmetic-subarrays/
 *
 * Using mathematics and set
 *
 * Stats
 * Runtime: 340 ms, faster than 92.86%
 * Memory Usage: 39.5 MB, less than 100.00%
 */
private fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean?> {
    fun check(left: Int, right: Int): Boolean {
        var minElement = Int.MAX_VALUE
        var maxElement = Int.MIN_VALUE
        val set = mutableSetOf<Int>()
        for (i in left..right) {
            minElement = min(minElement, nums[i])
            maxElement = max(maxElement, nums[i])
            set.add(nums[i])
        }
        if ((maxElement - minElement) % (right - left) != 0) {
            return false
        }
        val diff = (maxElement - minElement) / (right - left)
        var curr = minElement + diff
        while (curr < maxElement) {
            if (!set.contains(curr)) {
                return false
            }
            curr += diff
        }
        return true
    }

    val result = mutableListOf<Boolean>()
    repeat(l.size) {
        result.add(check(l[it], r[it]))
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/arithmetic-subarrays/
 *
 * Using mathematics and set
 *
 * Stats
 * Runtime: 325 ms, faster than 92.86%
 * Memory Usage: 39.4 MB, less than 100.00%
 */
private fun checkArithmeticSubarraysWithNewArray(nums: IntArray, l: IntArray, r: IntArray): List<Boolean?> {
    fun check(arr: IntArray): Boolean {
        var minElement = Int.MAX_VALUE
        var maxElement = Int.MIN_VALUE
        val set = mutableSetOf<Int>()
        arr.forEach { num ->
            minElement = min(minElement, num)
            maxElement = max(maxElement, num)
            set.add(num)
        }
        if ((maxElement - minElement) % (arr.size - 1) != 0) {
            return false
        }
        val diff = (maxElement - minElement) / (arr.size - 1)
        var curr = minElement + diff
        while (curr < maxElement) {
            if (!set.contains(curr)) {
                return false
            }
            curr += diff
        }
        return true
    }

    val result = mutableListOf<Boolean>()
    for (i in l.indices) {
        val arr = IntArray(r[i] - l[i] + 1)
        for (j in arr.indices) {
            arr[j] = nums[l[i] + j]
        }
        result.add(check(arr))
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/arithmetic-subarrays/
 *
 * Using sorting
 *
 * Stats
 * Runtime: 351 ms, faster than 92.86%
 * Memory Usage: 43 MB, less than 7.14%
 */
private fun checkArithmeticSubarraysUsingSorting(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
    fun isArithmetic(left: Int, right: Int): Boolean {
        val subArray = nums.sliceArray(left..right)
        if (subArray.size <= 1) {
            return false
        }
        subArray.sort()
        val diff = subArray[1] - subArray[0]
        for (i in 2..subArray.lastIndex) {
            if (subArray[i] - subArray[i - 1] != diff) {
                return false
            }
        }
        return true
    }

    return buildList {
        repeat(l.size) {
            add(isArithmetic(l[it], r[it]))
        }
    }
}

private fun main() {

}
