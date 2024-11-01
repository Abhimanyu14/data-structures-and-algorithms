package leetcode.leetcode_200_to_299.leetcode_268_missing_number

/**
 * Using set difference (Poor)
 *
 * Stats
 * Runtime: 639 ms, faster than 8.14%
 * Memory Usage: 63.6 MB, less than 5.03%
 */
private fun missingNumberUsingSet(nums: IntArray): Int {
    return ((0..nums.size) - nums.toSet()).first()
}

/**
 * Using XOR
 *
 * Stats
 * Runtime: 480 ms, faster than 29.59%
 * Memory Usage: 48.1 MB, less than 81.80%
 */
private fun missingNumberUsingXor(nums: IntArray): Int {
    var result = 0
    (1..nums.size).forEach {
        result = result xor it
    }
    nums.forEach {
        result = result xor it
    }
    return result
}

/**
 * Using mathematical formula - Gauss Summation
 * Details - https://letstalkscience.ca/educational-resources/backgrounders/gauss-summation
 * Source - https://leetcode.com/problems/missing-number/discuss/2219070/Kotlin-solution-bruteforce
 *
 * Stats
 * Runtime: 432 ms, faster than 49.70%
 * Memory Usage: 52.4 MB, less than 31.51%
 */
private fun missingNumber(nums: IntArray): Int {
    return ((nums.size * (nums.size + 1)) / 2) - nums.sum()
}

private fun main() {
    println(missingNumber(intArrayOf(3, 0, 1)))
    println(missingNumber(intArrayOf(0, 1)))
    println(missingNumber(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)))
}
