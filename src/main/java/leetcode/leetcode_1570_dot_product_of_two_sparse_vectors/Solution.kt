package leetcode.leetcode_1570_dot_product_of_two_sparse_vectors

/**
 * leetcode - https://leetcode.com/problems/dot-product-of-two-sparse-vectors/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 * Premium Question
 *
 * Data Structure - [Map]
 * Algorithm - Hashing
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private class SparseVector(nums: IntArray) {
    val map = mutableMapOf<Int, Int>()

    init {
        for (i in nums.indices) {
            map[i] = nums[i]
        }
    }

    fun dotProduct(vec: SparseVector): Int {
        var result = 0
        for ((key, value) in map) {
            result += value * (vec.map[key] ?: 0)
        }
        return result
    }
}

private fun main() {

}
