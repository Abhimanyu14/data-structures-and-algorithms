package leetcode.leet_2300_to_2399.leet_2300_successful_pairs_of_spells_and_potions

/**
 * leetcode - https://leetcode.com/problems/successful-pairs-of-spells-and-potions/
 *
 * Using sorting and binary search
 *
 * Stats
 * Runtime: 834 ms, faster than 35.56%
 * Memory Usage: 58.5 MB, less than 86.67%
 */
private fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
    val result = IntArray(spells.size)
    val sortedPotions = potions.sorted()

    fun findLastLessThan(spell: Int): Int? {
        var left = 0
        var right = sortedPotions.lastIndex
        var resultIndex: Int? = null
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (sortedPotions[mid].toLong() * spell < success) {
                resultIndex = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return resultIndex
    }

    spells.forEachIndexed { index, spell ->
        result[index] = sortedPotions.lastIndex - (findLastLessThan(spell) ?: -1)
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/successful-pairs-of-spells-and-potions/
 *
 * Using brute force
 *
 * Stats
 * Time Limit Exceeded
 */
private fun successfulPairsUsingBruteForce(spells: IntArray, potions: IntArray, success: Long): IntArray {
    val result = IntArray(spells.size)
    spells.forEachIndexed { index, spell ->
        potions.forEach { potion ->
            val strength = spell.toLong() * potion
            if (strength >= success.toLong()) {
                result[index]++
            }
        }
    }
    return result
}

private fun main() {

}
