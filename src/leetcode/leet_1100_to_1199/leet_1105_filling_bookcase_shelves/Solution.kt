package leetcode.leet_1100_to_1199.leet_1105_filling_bookcase_shelves

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/filling-bookcase-shelves/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun minHeightShelves(books: Array<IntArray>, shelfWidth: Int): Int {
    // dp[i] = minimum height of bookcase containing all books up to and
    // excluding book i
    val dp = IntArray(books.size + 1)

    // base cases
    dp[0] = 0
    dp[1] = books[0][1]

    for (i in 2..books.size) {
        // new shelf built to hold current book
        var remainingShelfWidth = shelfWidth - books[i - 1][0]
        var maxHeight = books[i - 1][1]
        dp[i] = books[i - 1][1] + dp[i - 1]

        var j = i - 1
        // calculate the height when previous books are added onto a new shelf
        while (j > 0 && remainingShelfWidth - books[j - 1][0] >= 0) {
            maxHeight = max(maxHeight.toDouble(), books[j - 1][1].toDouble()).toInt()
            remainingShelfWidth -= books[j - 1][0]
            dp[i] = min(dp[i].toDouble(), (maxHeight + dp[j - 1]).toDouble()).toInt()
            j--
        }
    }

    return dp[books.size]
}

private fun main() {

}
