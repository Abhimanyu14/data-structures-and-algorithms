package leetcode.leetcode_800_to_899.leetcode_846_hand_of_straights

import java.util.TreeMap

/**
 * leetcode - https://leetcode.com/problems/hand-of-straights/?envType=daily-question&envId=2024-06-06
 *
 * Using TreeMap
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 367 ms, faster than 35.48%
 * Memory Usage: 40.6 MB, less than 51.61%
 *
 * Time -
 * Space -
 */
private fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
    if (hand.size % groupSize != 0) {
        return false
    }

    val map = TreeMap<Int, Int>()
    hand.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }
    map.forEach { (key, value) ->
        if (value != 0) {
            repeat(groupSize) {
                if (!map.containsKey(key + it)) {
                    return false
                }
                map[key + it] = map.getOrDefault(key + it, 0) - value
                if (map.getOrDefault(key + it, 0) < 0) {
                    return false
                }
            }
        }
    }
    return true
}

private fun main() {

}
