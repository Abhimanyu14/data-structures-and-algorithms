package leetcode.leetcode_1726_tuple_with_same_product

/**
 * leetcode - https://leetcode.com/problems/tuple-with-same-product/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Map]
 * Algorithm - Counting, Hashing and Maths (Permutations & Combinations)
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N ^ 2)
 * Space - O(N ^ 2)
 *
 * Companies - Meta
 */
private fun tupleSameProduct(nums: IntArray): Int {
    val productPairs = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        for (j in (i + 1)..nums.lastIndex) {
            val product = nums[i] * nums[j]
            productPairs[product] = productPairs.getOrDefault(product, 0) + 1
        }
    }
    var result = 0
    for ((_, value) in productPairs) {
        result += ((value) * (value - 1))
    }
    return result * 4
}

private fun main() {

}
