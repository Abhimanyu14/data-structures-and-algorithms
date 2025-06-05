package leetcode.leetcode_825_friends_of_appropriate_ages

/**
 * leetcode - https://leetcode.com/problems/friends-of-appropriate-ages/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta, Microsoft
 */
private fun numFriendRequests(ages: IntArray): Int {
    val sortedAges = ages.filter { it >= 15 }.sorted()
    fun findIndex(age: Int): Int {
        var left = 0
        var right = sortedAges.lastIndex
        while (left < right) {
            val mid = left + (right - left) / 2
            if (sortedAges[mid].toDouble() > age * 0.5 + 8) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    var result = 0
    for (i in sortedAges.indices) {
        result += (i - findIndex(sortedAges[i]) - 1)
    }
    return result
}

private fun main() {

}
