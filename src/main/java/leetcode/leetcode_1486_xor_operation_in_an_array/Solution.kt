package leetcode.leetcode_1486_xor_operation_in_an_array

/**
 * leetcode - https://leetcode.com/problems/xor-operation-in-an-array/
 *
 * Data Structure - NA
 * Algorithm - Bitwise operations
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 34 MB, less than 35.29%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun xorOperation(n: Int, start: Int): Int {
    var result = 0
    for (i in 0..<n) {
        result = result xor (start + (2 * i))
    }
    return result
}

private fun main() {

}
