package leetcode.leetcode_18_4sum

/**
 * leetcode - https://leetcode.com/problems/4sum/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Google, Meta
 */
private fun fourSum(nums: IntArray, target: Int): List<MutableList<Int>> {
    val sortedNums = nums.sorted()
    fun twoSum(target: Long, start: Int): List<MutableList<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        val set = mutableSetOf<Long>()
        for (i in start..<sortedNums.size) {
            if (result.isEmpty() || result[result.lastIndex][1] != sortedNums[i]) {
                if (set.contains(target - sortedNums[i])) {
                    result.add(mutableListOf(target.toInt() - sortedNums[i], sortedNums[i]))
                }
            }
            set.add(sortedNums[i].toLong())
        }
        return result
    }

    fun kSum(target: Long, start: Int, remaining: Int): List<MutableList<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        if (start == sortedNums.size) {
            return result
        }
        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        val averageValue = target / remaining
        // We cannot obtain a sum of target if the smallest value in nums is greater than target / k or
        // if the largest value in nums is smaller than target / k.
        if (sortedNums[start] > averageValue || averageValue > sortedNums[sortedNums.lastIndex]) {
            return result
        }
        if (remaining == 2) {
            return twoSum(target, start)
        }
        for (i in start..sortedNums.lastIndex) {
            if (i == start || sortedNums[i - 1] != sortedNums[i]) {
                for (subset in kSum(target - sortedNums[i], i + 1, remaining - 1)) {
                    result.add(ArrayList(listOf(sortedNums[i])))
                    result[result.size - 1].addAll(subset)
                }
            }
        }
        return result
    }
    return kSum(target.toLong(), 0, 4)
}

private fun main() {

}
