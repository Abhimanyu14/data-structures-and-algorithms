package leetcode.leetcode_2423_remove_letter_to_equalize_frequency

/**
 * leetcode - https://leetcode.com/problems/remove-letter-to-equalize-frequency/
 *
 * Using map and list
 *
 * Stats
 * Runtime: 9 ms, faster than 100.00%
 * Memory Usage: 34.9 MB, less than 66.67%
 *
 *
 */
private fun equalFrequency(word: String): Boolean {
    val charCounter = mutableMapOf<Char, Int>()
    word.forEach {
        charCounter[it] = charCounter.getOrDefault(it, 0) + 1
    }
    val frequencyCounter = mutableMapOf<Int, Int>()
    charCounter.forEach { (_, value) ->
        frequencyCounter[value] = frequencyCounter.getOrDefault(value, 0) + 1
    }
    if (frequencyCounter.size == 1) {
        return frequencyCounter.contains(1) || frequencyCounter.containsValue(1)
    }
    if (frequencyCounter.size > 2) {
        return false
    }
    val key1 = frequencyCounter.keys.min()
    val key2 = frequencyCounter.keys.max()
    val value1 = frequencyCounter.getOrDefault(key1, 0)
    val value2 = frequencyCounter.getOrDefault(key2, 0)
    if (key1 == 1 && value1 == 1) {
        return true
    }
    if (key2 == key1 + 1) {
        return value2 == 1
    }
    return false
}

private fun main() {
}
