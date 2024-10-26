package leetcode.leet_2300_to_2399.leet_2337_move_pieces_to_obtain_a_string

/**
 * leetcode - https://leetcode.com/problems/move-pieces-to-obtain-a-string/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 *
 */
private fun canChange(start: String, target: String): Boolean {
    val n = target.length
    var left = 0
    var right = 0
    var temp: Int
    while (right < n) {
        if (start[left] == target[right]) {
            left++
            right++
        } else {
            if (target[right] == 'L') {
                temp = left
                while (temp < n && start[temp] == '_') {
                    temp++
                }
                if (temp == n || start[temp] == 'R') {
                    return false
                }
                if (start[temp] == 'L') {
//                    [left] = start[temp].also {
//                        start[temp] = start[left]
//                    }
                    left++
                    right++
                }
            } else if (target[right] == 'R') {
                return false
            } else {
                temp = left
                while (temp < n && start[temp] == 'R') {
                    temp++
                }
                if (temp == n || start[temp] == 'L') {
                    return false
                }
                if (start[temp] == '_') {
//                    start[left] = start[temp].also {
//                        start[temp] = start[left]
//                    }
                    left++
                    right++
                }
            }
        }
    }
    return true
}

private fun main() {

}
