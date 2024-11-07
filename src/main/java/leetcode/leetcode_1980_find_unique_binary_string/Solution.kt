package leetcode.leetcode_1980_find_unique_binary_string

import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/find-unique-binary-string/
 *
 * Using binary conversion and set
 *
 * Stats
 * Runtime: 178 ms, faster than 81.82%
 * Memory Usage: 36.1 MB, less than 100.00%
 */
private fun findDifferentBinaryString(nums: Array<String>): String {
    fun binaryStringToInt(s: String): Int {
        var multiplier = 1
        var result = 0
        var i = s.lastIndex
        while (i >= 0) {
            if (s[i] == '1') {
                result += multiplier
            }
            multiplier *= 2
            i--
        }
        return result
    }

    fun intToBinaryString(num: Int, digits: Int): String {
        val result = StringBuilder()
        var temp = num
        while (temp != 0) {
            result.append(temp % 2)
            temp /= 2
        }
        while (result.length < digits) {
            result.append('0')
        }
        return result.toString().reversed()
    }

    val set = mutableSetOf<Int>()
    nums.forEach {
        set.add(binaryStringToInt(it))
    }
    val maxNum = (2.0).pow(nums[0].length).toInt() - 1
    for (i in 0..maxNum) {
        if (!set.contains(i)) {
            return intToBinaryString(i, nums[0].length)
        }
    }
    return ""
}

private fun main() {

}
