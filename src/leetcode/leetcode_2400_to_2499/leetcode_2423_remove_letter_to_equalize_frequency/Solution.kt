package leetcode.leetcode_2400_to_2499.leetcode_2423_remove_letter_to_equalize_frequency

import kotlin.math.abs
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/remove-letter-to-equalize-frequency/
 *
 * Using map and list
 *
 * Stats
 *
 * "abbcc" => true seems like wrong use-case
 */

private fun equalFrequency(word: String): Boolean {
    val frequencyCounter = mutableMapOf<Char, Int>()
    word.forEach {
        frequencyCounter[it] = (frequencyCounter[it] ?: 0) + 1
    }
    val list = frequencyCounter.values.toList()
    if (list.size == 1) {
        return true
    }
    if (list.size == 2) {
        return abs(list[0] - list[1]) == 1
    }
    val minimum = min(list[0], list[1])
    var plusOne = false
    list.forEach {
        if (it != minimum) {
            if (plusOne) {
                return false
            } else {
                if (it == minimum + 1) {
                    plusOne = true
                } else {
                    return false
                }
            }
        }
    }
    return true
}

private fun main() {
    println(equalFrequency("aaaa"))
}
