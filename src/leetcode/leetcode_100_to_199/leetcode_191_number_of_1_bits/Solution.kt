package leetcode.leetcode_100_to_199.leetcode_191_number_of_1_bits

/**
 * leetcode - https://leetcode.com/problems/number-of-1-bits/
 *
 * Using Hamming weight
 *
 * Stats
 * Runtime: 130 ms, faster than 92.02%
 * Memory Usage: 33.6 MB, less than 53.36%
 */
private fun hammingWeight(n: Int): Int {
    var temp = n
    var result = 0
    while (temp != 0) {
        result++
        temp = temp and temp - 1
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/number-of-1-bits/
 *
 * Using countOneBits()
 *
 * Stats
 * Runtime: 149 ms, faster than 23.11%
 * Memory Usage: 33.4 MB, less than 68.49%
 */
private fun hammingWeightUsingCountOneBits(n:Int):Int {
    return n.countOneBits()
}

private fun main() {

}
