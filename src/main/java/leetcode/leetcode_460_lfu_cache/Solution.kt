package leetcode.leetcode_460_lfu_cache

/**
 * leetcode - https://leetcode.com/problems/lfu-cache/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - 2 Maps
 * Algorithm - Hashing
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 */
private class LFUCache(val capacity: Int) {
    // key: original key, value: frequency and original value.
    private val cache: MutableMap<Int, Pair<Int, Int>> = mutableMapOf()

    // key: frequency, value: All keys that have the same frequency.
    private val frequencyMap: MutableMap<Int, MutableSet<Int>> = mutableMapOf()
    private var minFrequency: Int = 0

    fun get(key: Int): Int {
        val (frequency, value) = cache[key] ?: return -1
        val keysWithFrequency: MutableSet<Int> = frequencyMap.getOrDefault(frequency, mutableSetOf())
        keysWithFrequency.remove(key)
        if (keysWithFrequency.isEmpty()) {
            frequencyMap.remove(frequency)
            if (minFrequency == frequency) {
                minFrequency++
            }
        }
        insert(key, value, frequency + 1)
        return value
    }

    fun put(key: Int, value: Int) {
        val frequencyAndValue = cache[key]
        if (frequencyAndValue != null) {
            cache[key] = Pair(frequencyAndValue.first, value)
            val keysWithFrequency: MutableSet<Int> = frequencyMap.getOrDefault(frequencyAndValue.first, mutableSetOf())
            keysWithFrequency.remove(key)
            if (keysWithFrequency.isEmpty()) {
                frequencyMap.remove(frequencyAndValue.first)
                if (minFrequency == frequencyAndValue.first) {
                    minFrequency++
                }
            }
            insert(key, value, frequencyAndValue.first + 1)
        } else {
            if (capacity == cache.size) {
                val keysWithFrequency: MutableSet<Int> = frequencyMap.getOrDefault(minFrequency, mutableSetOf())
                val keyToDelete = keysWithFrequency.iterator().next()
                cache.remove(keyToDelete)
                keysWithFrequency.remove(keyToDelete)
                if (keysWithFrequency.isEmpty()) {
                    frequencyMap.remove(minFrequency)
                }
            }
            minFrequency = 1
            insert(key, value, 1)
        }
    }

    private fun insert(
        key: Int,
        value: Int,
        frequency: Int,
    ) {
        cache[key] = Pair(frequency, value)
        frequencyMap.computeIfAbsent(frequency) {
            mutableSetOf()
        }.add(key)
    }
}

private fun main() {

}
