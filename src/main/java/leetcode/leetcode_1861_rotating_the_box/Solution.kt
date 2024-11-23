package leetcode.leetcode_1861_rotating_the_box

/**
 * leetcode - https://leetcode.com/problems/rotating-the-box/
 *
 * Using iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 784 ms, faster than 40.00%
 * Memory Usage: 87.1 MB, less than 52.94%
 *
 * Time - O(M * N)
 * Space - O(M * N)
 */
private fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
    val result = Array(box[0].size) { CharArray(box.size) { '.' } }
    for (i in box.indices) {
        var current = box[0].lastIndex
        for (j in box[0].lastIndex downTo 0) {
            if (box[i][j] == '*') {
                result[j][box.lastIndex - i] = '*'
                current = j - 1
            } else if (box[i][j] == '#') {
                result[current][box.lastIndex - i] = '#'
                current--
            }
        }
    }
    return result
}

private fun main() {

}
