package leetcode.leetcode_137_single_number_ii

/**
 * leetcode - https://leetcode.com/problems/single-number-ii/
 *
 * Using bit manipulation
 *
 * Stats
 * Runtime: 186 ms, faster than 64.00%
 * Memory Usage: 37.9 MB, less than 14.00%
 */
private fun singleNumber(nums: IntArray): Int {
    var result = 0
    for (bit in 0..31) {
        var bitSum = 0
        for (num in nums) {
            // Compute the bit of num, and add it to bitSum
            bitSum += (num shr bit) and 1
        }
        // Compute the bit of loner and place it
        val lonerBit = bitSum % 3
        result = result or (lonerBit shl bit)
    }
    return result
}

private fun main() {

}
