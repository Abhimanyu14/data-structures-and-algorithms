package leetcode.leetcode_362_design_hit_counter

/**
 * leetcode - https://leetcode.com/problems/design-hit-counter/description/
 * Premium Question
 *
 * Data Structure - [ArrayDeque] (Queue)
 * Algorithm - Queueing and Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Google
 */
private class HitCounter() {
    private val queue = ArrayDeque<Int>()

    fun hit(timestamp: Int) {
        queue.addLast(timestamp)
    }

    fun getHits(timestamp: Int): Int {
        while (queue.isNotEmpty() && queue.first() <= timestamp - 300) {
            queue.removeFirst()
        }
        return queue.size
    }
}

private fun main() {

}
