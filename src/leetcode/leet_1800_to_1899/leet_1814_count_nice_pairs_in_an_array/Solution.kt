package leetcode.leet_1800_to_1899.leet_1814_count_nice_pairs_in_an_array

/**
 * leetcode - https://leetcode.com/problems/count-nice-pairs-in-an-array/
 *
 * TODO(Abhi) - To revisit
 *
 * Using hashmap and counting
 *
 * Stats
 * Runtime: 465 ms, faster than 80.00%
 * Memory Usage: 59.9 MB, less than 60.00%
 */
private fun countNicePairs(nums: IntArray): Int {
    fun rev(num: Int): Int {
        var temp = num
        var result = 0
        while (temp > 0) {
            result = result * 10 + temp % 10
            temp /= 10
        }
        return result
    }

    val mod = 1e9.toInt() + 7
    val arr = IntArray(nums.size)
    for (i in nums.indices) {
        arr[i] = nums[i] - rev(nums[i])
    }
    val map = mutableMapOf<Int, Int>()
    var result = 0
    arr.forEach { num ->
        result = (result + map.getOrDefault(num, 0)) % mod
        map[num] = map.getOrDefault(num, 0) + 1
    }
    return result
}

private fun main() {

}
