package leetcode.leetcode_3445_maximum_difference_between_even_and_odd_frequency_ii

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-ii/submissions/1660288046/?envType=daily-question&envId=2025-06-11
 *
 * TODO - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(N^2)
 * Space - O(1)
 *
 * Companies -
 */
private fun maxDifference(s: String, k: Int): Int {
    var result = Int.MIN_VALUE

    fun getDifference(counter: IntArray): Int? {
        var maxOdd = Int.MIN_VALUE
        var minEven = Int.MAX_VALUE
        for (i in 0..4) {
            if (counter[i] > 0) {
                if (counter[i] % 2 == 0) {
                    minEven = min(minEven, counter[i])
                } else {
                    maxOdd = max(maxOdd, counter[i])
                }
            }
        }
        return if (minEven == Int.MAX_VALUE || maxOdd == Int.MIN_VALUE) {
            null
        } else {
            maxOdd - minEven
        }
    }

    for (i in 0..(s.lastIndex - k + 1)) {
        val counter = IntArray(5)
        for (j in i..s.lastIndex) {
            counter[s[j] - '0']++
            if (j - i + 1 >= k) {
                getDifference(counter)?.let {
                    result = max(result, it)
                }
            }
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-ii/submissions/1660288046/?envType=daily-question&envId=2025-06-11
 *
 * TODO - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(N^3)
 * Space - O(N)
 *
 * Companies -
 */
private fun maxDifferenceUsingStringGeneration(s: String, k: Int): Int {
    var result = Int.MIN_VALUE

    fun getDifference(substring: String): Int? {
        val counter = IntArray(5)
        for (char in substring) {
            counter[char - '0']++
        }
        var maxOdd = Int.MIN_VALUE
        var minEven = Int.MAX_VALUE
        for (i in 0..4) {
            if (counter[i] > 0) {
                if (counter[i] % 2 == 0) {
                    minEven = min(minEven, counter[i])
                } else {
                    maxOdd = max(maxOdd, counter[i])
                }
            }
        }
        return if (minEven == Int.MAX_VALUE || maxOdd == Int.MIN_VALUE) {
            null
        } else {
            maxOdd - minEven
        }
    }

    for (i in 0..(s.lastIndex - k + 1)) {
        val current = StringBuilder()
        for (j in i..s.lastIndex) {
            current.append(s[j])
            if (current.length >= k) {
                getDifference(current.toString())?.let {
                    result = max(result, it)
                }
            }
        }
    }
    return result
}

private fun main() {

}
