package leetcode.leetcode_900_to_999.leetcode_974_subarray_sums_divisible_by_k

/**
 * leetcode - https://leetcode.com/problems/subarray-sums-divisible-by-k/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun subarraysDivByK(nums: IntArray, k: Int): Int {
    var result = 0
    var prefixMod = 0

    // There are k mod groups 0...k-1.
    val modGroups = IntArray(k)
    modGroups[0] = 1

    for (num in nums) {
        // Take modulo twice to avoid negative remainders.
        prefixMod = (prefixMod + num % k + k) % k
        // Add the count of subarrays that have the same remainder as the current
        // one to cancel out the remainders.
        result += modGroups[prefixMod]
        modGroups[prefixMod]++
    }

    return result
}

private fun main() {

}
