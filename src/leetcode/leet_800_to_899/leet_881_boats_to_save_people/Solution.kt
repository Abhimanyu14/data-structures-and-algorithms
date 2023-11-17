package leetcode.leet_800_to_899.leet_881_boats_to_save_people

/**
 * leetcode - https://leetcode.com/problems/boats-to-save-people/
 *
 * Using sorting and two pointers - greedy
 *
 * Stats
 * Runtime: 396 ms, faster than 81.25%
 * Memory Usage: 46.2 MB, less than 81.25%
 */
private fun numRescueBoats(people: IntArray, limit: Int): Int {
    people.sort()
    var start = 0
    var end = people.lastIndex
    var result = 0
    while (start <= end) {
        if (people[start] + people[end] <= limit) {
            start++
            end--
        } else {
            end--
        }
        result++
    }
    return result
}

private fun main() {

}
