package leetcode.leetcode_1700_to_1799.leetcode_1700_number_of_students_unable_to_eat_lunch

/**
 * leetcode - https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 *
 * Using counter variables
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 140 ms, faster than 87.50%
 * Memory Usage: 34.2 MB, less than 83.33%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun countStudents(students: IntArray, sandwiches: IntArray): Int {
    var oneCount = 0
    students.forEach {
        if (it == 1) {
            oneCount++
        }
    }
    var zeroCount = students.size - oneCount

    sandwiches.forEach {
        if (it == 0) {
            if (zeroCount > 0) {
                zeroCount--
            } else {
                return oneCount + zeroCount
            }
        } else {
            if (oneCount > 0) {
                oneCount--
            } else {
                return oneCount + zeroCount
            }
        }
    }

    return 0
}

private fun main() {

}
