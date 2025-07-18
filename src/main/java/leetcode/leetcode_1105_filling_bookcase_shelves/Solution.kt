package leetcode.leetcode_1105_filling_bookcase_shelves

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/filling-bookcase-shelves/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [IntArray]
 * Algorithm - Dynamic Programming - Tabulation
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N ^ 2)
 * Space - O(N)
 *
 * Companies - Amazon, Google
 */
private fun minHeightShelves(books: Array<IntArray>, shelfWidth: Int): Int {
    val dp = IntArray(books.size + 1)
    dp[0] = 0
    dp[1] = books[0][1]
    for (bookIndex in 2..books.size) {
        var remainingShelfWidth = shelfWidth - books[bookIndex - 1][0]
        var maxHeight = books[bookIndex - 1][1]
        dp[bookIndex] = maxHeight + dp[bookIndex - 1]
        var previousBookIndex = bookIndex - 1
        while (previousBookIndex > 0 && remainingShelfWidth - books[previousBookIndex - 1][0] >= 0) {
            maxHeight = max(maxHeight, books[previousBookIndex - 1][1])
            dp[bookIndex] = min(dp[bookIndex], (maxHeight + dp[previousBookIndex - 1]))
            remainingShelfWidth -= books[previousBookIndex - 1][0]
            previousBookIndex--
        }
    }
    return dp[books.size]
}
