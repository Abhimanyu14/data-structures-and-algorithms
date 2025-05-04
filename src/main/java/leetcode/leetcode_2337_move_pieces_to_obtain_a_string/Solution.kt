package leetcode.leetcode_2337_move_pieces_to_obtain_a_string

/**
 * leetcode - https://leetcode.com/problems/move-pieces-to-obtain-a-string/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
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
 *
 * Companies - Google
 */
private fun canChange(start: String, target: String): Boolean {
    var left = 0
    var right = 0
    for (i in start.indices) {
        when (start[i]) {
            'L' -> {
                left--
            }
            'R' -> {
                if (left > 0) {
                    return false
                }
                right++
            }
            '_' -> {

            }
        }
        when (target[i]) {
            'L' -> {
                if (right > 0) {
                    return false
                }
                left++
            }
            'R' -> {
                right--
            }
            '_' -> {

            }
        }
        if (left < 0) {
            return false
        }
        if (right < 0) {
            return false
        }
    }
    return right == 0 && left == 0
}

private fun canChange1(start: String, target: String): Boolean {
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
