package leetcode.leet_200_to_299.leet_264_ugly_number_ii

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/ugly-number-ii/?envType=daily-question&envId=2024-08-18
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private     fun nthUglyNumber(n: Int): Int {
    if (n <= 6) {
        return n
    }
    val pq = PriorityQueue<Long>()
    val set = mutableSetOf<Long>()
    val primes = listOf(2L, 3L, 5L)
    repeat(5) {
        pq.offer(it + 1L)
        set.add(it + 1L)
    }
    repeat(n - 1) {
        val temp = pq.poll()
        primes.forEach {
            val next = temp * it
            if (!set.contains(next)) {
                set.add(next)
                pq.offer(next)
            }
        }
    }
    return pq.poll().toInt()
}

private fun main() {

}
