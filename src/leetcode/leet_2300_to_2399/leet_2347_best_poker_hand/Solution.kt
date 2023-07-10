package leetcode.leet_2300_to_2399.leet_2347_best_poker_hand

/**
 * Using conditional operators, map
 * Kotlin idiomatic - all, values, max(), when, in
 *
 * leetcode - https://leetcode.com/problems/best-poker-hand/
 *
 * Stats
 * Runtime: 172 ms, faster than 71.43%
 * Memory Usage: 35.7 MB, less than 28.57%
 */
private fun bestHand(ranks: IntArray, suits: CharArray): String {
    return if (suits.all { it == suits[0] }) {
        "Flush"
    } else {
        val countMap = mutableMapOf<Int, Int>()
        ranks.forEach {
            countMap[it] = 1 + (countMap[it] ?: 0)
        }
        when (countMap.values.max()) {
            in 3..5 -> "Three of a Kind"
            2 -> "Pair"
            else -> "High Card"
        }
    }
}

/**
 * Using conditional operators, map
 *
 * leetcode - https://leetcode.com/problems/best-poker-hand/
 *
 * Stats
 * Runtime: 178 ms, faster than 71.43%
 * Memory Usage: 36 MB, less than 14.29%
 */
private fun bestHandSimple(ranks: IntArray, suits: CharArray): String {
    var isFlush = true
    for (i in 1..suits.lastIndex) {
        if (suits[i] != suits[0]) {
            isFlush = false
            break
        }
    }
    return if (isFlush) {
        "Flush"
    } else {
        val countMap = mutableMapOf<Int, Int>()
        ranks.forEach {
            countMap[it] = 1 + (countMap[it] ?: 0)
        }
        var max = 1
        countMap.forEach { (key, value) ->
            if (value > max) {
                max = value
            }
        }
        if (max >= 3) {
            "Three of a Kind"
        } else if (max == 2) {
            "Pair"
        } else {
            "High Card"
        }
    }
}

private fun main() {

}
