package leetcode.leetcode_400_to_499.leetcode_451_sort_characters_by_frequency

/**
 * Using map, loops, sorting, list, and repeat
 *
 * Stats
 * Runtime: 599 ms, faster than 11.36%
 * Memory Usage: 52.4 MB, less than 18.18%
 */
private fun frequencySortNaive(s: String): String {
    val result = StringBuilder()
    val map = hashMapOf<Char, Int>()
    s.forEach {
        map[it] = 1 + (map[it] ?: 0)
    }
    val countList = map.values.toList().distinct().sortedDescending()
    countList.forEach { count ->
        map.forEach { (key, value) ->
            if (value == count) {
                result.append(key.toString().repeat(count))
            }
        }
    }
    return result.toString()
}

/**
 * Using map, loops, sorting, list, and repeat
 *
 * Stats
 * Runtime: 451 ms, faster than 56.82%
 * Memory Usage: 51.4 MB, less than 25.00%
 */
private fun frequencySort(s: String): String {
    val result = StringBuilder()
    val frequencyMap = hashMapOf<Char, Int>()
    s.forEach {
        frequencyMap[it] = 1 + (frequencyMap[it] ?: 0)
    }
    val countList = frequencyMap.keys.sortedBy { frequencyMap[it] }
    countList.forEach { char ->
        result.append(char.toString().repeat(frequencyMap[char] ?: 0))
    }
    return result.toString()
}

private fun main() {

}
