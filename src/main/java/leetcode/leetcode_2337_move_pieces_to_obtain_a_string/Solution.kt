package leetcode.leetcode_2337_move_pieces_to_obtain_a_string

/**
 * leetcode - https://leetcode.com/problems/move-pieces-to-obtain-a-string/
 *
 * Data Structure - Two Pointers
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 18 ms, faster than 100.00%
 * Memory Usage: 39.6 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun canChange(start: String, target: String): Boolean {
    var leftCount = 0
    var rightCount = 0
    for (i in start.indices) {
        if (target[i] == 'L') {
            if (rightCount > 0) {
                return false
            }
            leftCount--
        } else if (target[i] == 'R') {
            if (leftCount < 0) {
                return false
            }
            rightCount--
        }

        if (start[i] == 'L') {
            if (rightCount > 0) {
                return false
            }
            leftCount++
        } else if (start[i] == 'R') {
            if (leftCount < 0) {
                return false
            }
            rightCount++
        }

        if ((leftCount > 0) || (rightCount < 0)) {
            return false
        }
    }
    return !(leftCount != 0 || rightCount != 0)
}

private fun main() {

}
