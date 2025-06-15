package leetcode.leetcode_3178_find_the_child_who_has_the_ball_after_k_seconds

/**
 * leetcode - https://leetcode.com/problems/find-the-child-who-has-the-ball-after-k-seconds/description/?envType=company&envId=facebook&favoriteSlug=facebook-all
 *
 * Data Structure - NA
 * Algorithm - Pattern
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(1)
 * Space - O(1)
 *
 * Companies - Google, Meta
 */
private fun numberOfChild(n: Int, k: Int): Int {
    val newK = k % (2 * n - 2)
    if (newK < n) {
        return newK
    }
    return 2 * n - 2 - newK
}

private fun main() {

}
