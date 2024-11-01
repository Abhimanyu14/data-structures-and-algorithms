package leetcode.leetcode_200_to_299.leetcode_277_find_the_celebrity

fun knows(i: Int, j: Int): Boolean {
    return true
}

/**
 * leetcode - https://leetcode.com/problems/find-the-celebrity/
 * Using logical deduction
 *
 * Stats
 * Runtime - 69.57%
 * Memory - 56.52%
 */
private fun findCelebrity(n: Int): Int {
    var celebrity = 0
    for (i in 1 until n) {
        if (knows(celebrity, i)) {
            celebrity = i
        }
    }
    for (i in 0 until n) {
        if (celebrity != i && (!knows(i, celebrity) || knows(celebrity, i))) {
            return -1
        }
    }
    return celebrity
}

private fun main() {

}
