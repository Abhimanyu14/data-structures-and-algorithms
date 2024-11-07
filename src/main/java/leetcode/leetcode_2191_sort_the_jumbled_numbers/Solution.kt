package leetcode.leetcode_2191_sort_the_jumbled_numbers

/**
 * leetcode - https://leetcode.com/problems/sort-the-jumbled-numbers/
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
private fun sortJumbled(mapping: IntArray, nums: IntArray): IntArray {
    val storePairs: MutableList<IntArray> = ArrayList()

    for (i in nums.indices) {
        var mappedValue = 0
        var temp = nums[i]
        var place = 1

        if (temp == 0) {
            storePairs.add(intArrayOf(mapping[0], i))
            continue
        }
        while (temp != 0) {
            mappedValue += place * mapping[temp % 10]
            place *= 10
            temp /= 10
        }
        storePairs.add(intArrayOf(mappedValue, i))
    }

    storePairs.sortWith { a: IntArray, b: IntArray ->
        a[0] - b[0]
    }

    val answer = IntArray(nums.size)
    for (i in storePairs.indices) {
        answer[i] = nums[storePairs[i][1]]
    }

    return answer
}

private fun main() {

}
