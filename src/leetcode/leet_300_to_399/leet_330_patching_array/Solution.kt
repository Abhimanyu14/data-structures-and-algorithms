package leetcode.leet_300_to_399.leet_330_patching_array

/**
 * leetcode - https://leetcode.com/problems/patching-array/?envType=daily-question&envId=2024-06-16
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 */


private fun minPatches(nums: IntArray, n: Int): Int {
    var currentMax = 0L
    var currentNumIndex = 0
    var res = 0
    while (currentMax < n) {
        if (currentNumIndex < nums.size && nums[currentNumIndex] <= currentMax + 1) {
            currentMax += nums[currentNumIndex]
            ++currentNumIndex
        } else {
            currentMax += currentMax + 1
            ++res
        }
    }
    return res
}

private fun main() {

}
