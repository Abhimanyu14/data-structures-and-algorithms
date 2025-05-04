package leetcode.leetcode_1296_divide_array_in_sets_of_k_consecutive_numbers

/**
 * leetcode - https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [List]
 * Algorithm - Sorting
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Google
 */
private fun isPossibleDivideUsingList(nums: IntArray, k: Int): Boolean {
    if (k == 1) {
        return true
    }
    val sortedNums = nums.sorted()
    val processing = mutableListOf<Pair<Int, Int>>()
    for (i in sortedNums.indices) {
        var index = 0
        while (index <= processing.lastIndex) {
            if (processing[index].first + 1 == sortedNums[i]) {
                if (processing[index].second + 1 == k) {
                    processing.removeAt(index)
                    index--
                } else {
                    processing[index] = Pair(processing[index].first + 1, processing[index].second + 1)
                }
                break
            }
            index++
        }
        if (index == processing.size) {
            processing.add(Pair(sortedNums[i], 1))
        }
    }
    return processing.isEmpty()
}

private fun main() {

}
