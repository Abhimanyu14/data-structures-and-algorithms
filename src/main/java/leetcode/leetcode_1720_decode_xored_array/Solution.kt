package leetcode.leetcode_1720_decode_xored_array

/**
 * leetcode - https://leetcode.com/problems/decode-xored-array/
 *
 * Using bitwise operations - XOR
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 18 ms, faster than 33.33%
 * Memory Usage: 40.6 MB, less than 7.69%
 *
 * Time -
 * Space -
 */
private fun decode(encoded: IntArray, first: Int): IntArray {
    val result = IntArray(encoded.size + 1)
    result[0] = first
    for (i in 1..encoded.lastIndex + 1) {
        result[i] = result[i - 1] xor encoded[i - 1]
    }
    return result
}

private fun main() {

}
