package leetcode.leetcode_1748_sum_of_unique_elements

/**
 * leetcode - https://leetcode.com/problems/sum-of-unique-elements/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 *
 * Data Structure - [Set]
 * Algorithm - Hashing
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Apple, Google, Meta
 */
private fun sumOfUnique(nums: IntArray): Int {
    val unique = mutableSetOf<Int>()
    val notUnique = mutableSetOf<Int>()
    for (num in nums) {
        if (num !in notUnique) {
            if (num !in unique) {
                unique.add(num)
            } else if (num in unique) {
                unique.remove(num)
                notUnique.add(num)
            }
        }
    }
    return unique.sum()
}

private fun main() {

}
