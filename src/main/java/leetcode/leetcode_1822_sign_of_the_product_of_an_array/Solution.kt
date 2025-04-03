package leetcode.leetcode_1822_sign_of_the_product_of_an_array

/**
 * leetcode - https://leetcode.com/problems/sign-of-the-product-of-an-array/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 *
 * Data Structure - NA
 * Algorithm - Iteration & Maths
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun arraySign(nums: IntArray): Int {
    var count = 0
    for (num in nums) {
        if (num == 0) {
            return 0
        }
        if (num < 0) {
            count++
        }
    }
    return if (count % 2 == 0) {
        1
    } else {
        -1
    }
}

private fun main() {

}
