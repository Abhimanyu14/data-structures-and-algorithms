package leetcode.leetcode_1431_kids_with_the_greatest_number_of_candies

/**
 * leetcode - https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=EASY
 *
 * Data Structure - Array and List
 * Algorithm - [min]
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 20 ms, faster than 39.38%
 * Memory Usage: 38.5 MB, less than 29.16%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
    val max = candies.max()
    return List(candies.size) {
        candies[it] + extraCandies >= max
    }
}

private fun main() {

}
