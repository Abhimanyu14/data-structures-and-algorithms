package leetcode.leetcode_941_valid_mountain_array

/**
 * leetcode - https://leetcode.com/problems/valid-mountain-array/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 238 ms, faster than 45.10%
 * Memory Usage: 42.4 MB, less than 5.19%
 *
 * Time -
 * Space -
 */
private fun validMountainArray(arr: IntArray): Boolean {
    if (arr.size < 3) {
        return false
    }
    if (arr[1] - arr[0] <= 0) {
        return false
    }
    var isSlopeDown = false
    for (i in 2..arr.lastIndex) {
        if (isSlopeDown) {
            if (arr[i - 1] - arr[i] <= 0) {
                return false
            }
        } else {
            if (arr[i] == arr[i - 1]) {
                return false
            } else if (arr[i] < arr[i - 1]) {
                isSlopeDown = true
            }
        }
    }
    return isSlopeDown
}

private fun main() {

}
