package leetcode.leet_300_to_399.leet_388_longest_absolute_file_path

import kotlin.math.max

/**
 * leetcode -
 *
 * TODO(Abhi) - To complete
 *
 * Using
 *
 * Stats
 * Runtime: 153 ms, faster than 100.00%
 * Memory Usage: 38.3 MB, less than 31.25%
 */
private fun lengthLongestPath(input: String): Int {
    var longestPath = 0
    val stack = ArrayDeque<Int>()

    var isFile = false
    var pathLength = 0
    var currentLength = 0
    var i = 0
    while (i < input.length) {
        if (input[i] == '\n') {
            if (isFile) {
                longestPath = max(longestPath, pathLength + currentLength)
            } else {
                stack.addLast(currentLength + 1)
                pathLength += currentLength + 1
            }
            i++
            isFile = false
            currentLength = 0

            var level = 1
            while (input[i] == '\t') {
                level++
                i++
            }
            while (stack.size >= level) {
                pathLength -= stack.removeLast()
            }
        } else if (input[i] == '.') {
            isFile = true
            currentLength++
            i++
        } else {
            currentLength++
            i++
        }
    }
    if (isFile) {
        longestPath = max(longestPath, pathLength + currentLength)
    }
    return longestPath
}

private fun main() {

}
