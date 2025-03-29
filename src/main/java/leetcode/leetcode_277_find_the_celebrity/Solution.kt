package leetcode.leetcode_277_find_the_celebrity

private fun knows(i: Int, j: Int): Boolean {
    return true
}

/**
 * leetcode - https://leetcode.com/problems/find-the-celebrity/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Logical deduction
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime - 69.57%
 * Memory - 56.52%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun findCelebrity(n: Int): Int {
    var celebrity = 0
    for (i in 1..<n) {
        if (knows(celebrity, i)) {
            celebrity = i
        }
    }
    for (i in 0..<n) {
        if (celebrity != i && (!knows(i, celebrity) || knows(celebrity, i))) {
            return -1
        }
    }
    return celebrity
}

private fun main() {

}
