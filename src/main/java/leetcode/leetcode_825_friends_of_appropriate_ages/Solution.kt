package leetcode.leetcode_825_friends_of_appropriate_ages

/**
 * leetcode - https://leetcode.com/problems/friends-of-appropriate-ages/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [IntArray]
 * Algorithm - Counting, Iteration
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
    var result = 0
    val counter = IntArray(121)
    for (age in ages) {
        counter[age]++
    }
    for (ageX in 15..counter.lastIndex) {
        if (counter[ageX] == 0) {
            continue
        }
        val minAgeY = (0.5 * ageX + 7).toInt()
        result += counter[ageX] * (counter[ageX] - 1)
        for (yAge in (minAgeY + 1)..<ageX) {
            result += counter[ageX] * counter[yAge]
        }
    }
    return result
}

private fun main() {

}
