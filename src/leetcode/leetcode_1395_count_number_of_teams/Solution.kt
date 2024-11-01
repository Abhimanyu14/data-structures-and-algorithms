package leetcode.leetcode_1395_count_number_of_teams

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/count-number-of-teams/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 *
 */
private class Solution {
    fun numTeams(rating: IntArray): Int {
        // Find the maximum rating
        var maxRating = 0
        for (r in rating) {
            maxRating = max(maxRating.toDouble(), r.toDouble()).toInt()
        }

        // Initialize Binary Indexed Trees for left and right sides
        val leftBIT = IntArray(maxRating + 1)
        val rightBIT = IntArray(maxRating + 1)

        // Populate the right BIT with all ratings initially
        for (r in rating) {
            updateBIT(rightBIT, r, 1)
        }

        var teams = 0
        for (currentRating in rating) {
            // Remove current rating from right BIT
            updateBIT(rightBIT, currentRating, -1)

            // Count soldiers with smaller and larger ratings on both sides
            val smallerRatingsLeft = getPrefixSum(leftBIT, currentRating - 1)
            val smallerRatingsRight = getPrefixSum(rightBIT, currentRating - 1)
            val largerRatingsLeft =
                getPrefixSum(leftBIT, maxRating) -
                        getPrefixSum(leftBIT, currentRating)
            val largerRatingsRight =
                getPrefixSum(rightBIT, maxRating) -
                        getPrefixSum(rightBIT, currentRating)

            // Count increasing and decreasing sequences
            teams += (smallerRatingsLeft * largerRatingsRight)
            teams += (largerRatingsLeft * smallerRatingsRight)

            // Add current rating to left BIT
            updateBIT(leftBIT, currentRating, 1)
        }

        return teams
    }

    // Update the Binary Indexed Tree
    private fun updateBIT(BIT: IntArray, index: Int, value: Int) {
        var index = index
        while (index < BIT.size) {
            BIT[index] += value
            index += index and (-index) // Move to the next relevant index in BIT
        }
    }

    // Get the sum of all elements up to the given index in the BIT
    private fun getPrefixSum(BIT: IntArray, index: Int): Int {
        var index = index
        var sum = 0
        while (index > 0) {
            sum += BIT[index]
            index -= index and (-index) // Move to the parent node in BIT
        }
        return sum
    }
}

private fun main() {
}
