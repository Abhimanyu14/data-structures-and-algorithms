package leetcode.leet_2600_to_2699.leet_2678_number_of_senior_citizens

/**
 * leetcode - https://leetcode.com/problems/number-of-senior-citizens/?envType=daily-question&envId=2024-08-01
 *
 * Using count {}
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 207 ms, faster than 10.00%
 * Memory Usage: 37.6 MB, less than 25.00%
 *
 * Time -
 * Space -
 */
private fun countSeniors(details: Array<String>): Int {
    return details.count { it[11].digitToInt() > 6 || (it[11].digitToInt() == 6 && it[12].digitToInt() > 0) }
}

private fun main() {

}
