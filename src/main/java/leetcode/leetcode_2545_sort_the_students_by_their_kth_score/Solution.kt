package leetcode.leetcode_2545_sort_the_students_by_their_kth_score

/**
 * leetcode - https://leetcode.com/problems/sort-the-students-by-their-kth-score/
 *
 * Using [sortedByDescending]
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 22 ms, faster than 57.14%
 * Memory Usage: 53.1 MB, less than 62.50%
 *
 * Time -
 * Space -
 */
private fun sortTheStudents(score: Array<IntArray>, k: Int): Array<IntArray> {
    return score.sortedByDescending { it[k] }.toTypedArray()
}

private fun main() {

}
