package leetcode.leetcode_2818_apply_operations_to_maximize_score

/**
 * leetcode - https://leetcode.com/problems/apply-operations-to-maximize-score/description/?envType=daily-question&envId=2025-03-29
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [BooleanArray]
 * Algorithm - Sieve Of Eratosthenes (Prime number lesser that given number)
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies -
 */

/**
 *
 */
private class Solution {
    private val isPrime = BooleanArray(100_000) { true }

    fun maximumScore(nums: List<Int>, k: Int): Int {
        // TODO(Abhi) - To revisit
        return 0
    }

    private fun sieveOfEratosthenes() {
        isPrime[0] = false
        isPrime[1] = false
        for (i in 2..isPrime.lastIndex) {
            if (isPrime[i]) {
                for (j in (i * i)..isPrime.lastIndex step i) {
                    isPrime[j] = false
                }
            }
        }
    }
}


private fun main() {

}
