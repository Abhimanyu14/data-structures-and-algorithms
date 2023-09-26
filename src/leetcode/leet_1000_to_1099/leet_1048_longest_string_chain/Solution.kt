package leetcode.leet_1000_to_1099.leet_1048_longest_string_chain

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/longest-string-chain/
 *
 * Using brute force - map
 *
 * Stats
 * Runtime: 233 ms, faster than 100.00%
 * Memory Usage: 39.2 MB, less than 54.55%
 */
private fun longestStrChain(words: Array<String>): Int {
    // w2 is longer word - w2.size = w1.size + 1
    fun isPredecessor(w1: String, w2: String): Boolean {
        var p1 = 0
        var p2 = 0
        var diff = 0
        while (p2 < w2.length) {
            if (w1[p1] != w2[p2]) {
                diff++
            } else {
                p1++
            }
            p2++
        }
        return diff <= 1
    }

    val lengthBuckets = mutableMapOf<Int, MutableSet<String>>()
    val chainCounter = mutableMapOf<String, Int>()
    words.forEach {
        lengthBuckets.computeIfAbsent(it.length) {
            mutableSetOf()
        }.add(it)
        chainCounter[it] = 1
    }
    var result = 1
    for (i in 1..15) {
        lengthBuckets[i]?.forEach { w1 ->
            lengthBuckets[i + 1]?.forEach { w2 ->
                if (isPredecessor(w1, w2)) {
                    chainCounter[w2] = max(chainCounter[w2] ?: 0, (chainCounter[w1] ?: 0) + 1)
                    result = max(result, chainCounter[w2] ?: 0)
                }
            }
        }
    }
    return result
}

private fun main() {

}
