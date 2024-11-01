package leetcode.leetcode_1600_to_1699.leetcode_1611_minimum_one_bit_operations_to_make_integers_zero

/**
 * leetcode -
 *
 * TODO(Abhi) - To revisit
 *
 * Using Gray code
 *
 * Stats
 * Runtime: 130 ms, faster than 100.00%
 * Memory Usage: 33.1 MB, less than 100.00%
 */
private fun minimumOneBitOperations(n: Int): Int {
    var ans = n
    ans = ans xor (ans shr 16)
    ans = ans xor (ans shr 8)
    ans = ans xor (ans shr 4)
    ans = ans xor (ans shr 2)
    ans = ans xor (ans shr 1)
    return ans
}

private fun main() {

}
