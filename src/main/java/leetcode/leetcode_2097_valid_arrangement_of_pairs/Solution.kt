package leetcode.leetcode_2097_valid_arrangement_of_pairs

/**
 * leetcode - https://leetcode.com/problems/valid-arrangement-of-pairs/?envType=daily-question&envId=2024-11-30
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun validArrangement(pairs: Array<IntArray>): Array<IntArray> {
    val result = Array(pairs.size) { intArrayOf() }
    val counter = mutableMapOf<Int, Int>()
    val hashByEnd = mutableMapOf<Int, MutableList<IntArray>>()
    pairs.forEach { (start, end) ->
        hashByEnd.computeIfAbsent(end) {
            mutableListOf()
        }.add(intArrayOf(start, end))
        if (counter.getOrDefault(start, 0) == 1) {
            counter.remove(start)
        } else {
            counter[start] = counter.getOrDefault(start, 0) - 1
        }
        if (counter.getOrDefault(end, 0) == -1) {
            counter.remove(end)
        } else {
            counter[end] = counter.getOrDefault(end, 0) + 1
        }
    }
    var lastNum: Int = -1
    if (counter.isEmpty()) {
        lastNum = pairs.first()[1]
    } else {
        for ((key, value) in counter) {
            if (value == 1) {
                lastNum = key
                break
            }
        }
    }
    for (i in pairs.lastIndex downTo 0) {
        if (hashByEnd[lastNum]?.size == 1) {
            val toAdd = hashByEnd[lastNum]!!.first()
            hashByEnd.remove(lastNum)
            result[i] = toAdd
            lastNum = toAdd[0]
        } else {
            var toAdd: IntArray = intArrayOf()
            for (pair in hashByEnd[lastNum].orEmpty()) {
                if (hashByEnd.contains(pair[0])) {
                    toAdd = pair
                    break
                }
            }
            hashByEnd[lastNum]?.remove(toAdd)
            result[i] = toAdd
            lastNum = toAdd[0]
        }
    }
    return result
}

private fun main() {

}
