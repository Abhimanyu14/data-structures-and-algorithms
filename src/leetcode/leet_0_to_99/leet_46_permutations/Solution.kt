package leetcode.leet_0_to_99.leet_46_permutations

/**
 * leetcode - https://leetcode.com/problems/permutations/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 217 ms, faster than 57.62%
 * Memory Usage: 38.5 MB, less than 26.67%
 */
private fun permute(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    fun getPermutation(currentList: List<Int>, listOfNums: List<Int>) {
        if (currentList.size == nums.size) {
            result.add(currentList)
            return
        }
        for (n in listOfNums) {
            getPermutation(currentList + n, listOfNums - n)
        }
    }
    getPermutation(emptyList<Int>(), nums.toList())
    return result
}

/**
 * leetcode - https://leetcode.com/problems/permutations/
 *
 * Using backtracking
 *
 * Stats
 */
fun permuteUsingBacktracking(nums: IntArray): List<List<Int>> {
    val ans: MutableList<List<Int>> = ArrayList()
    fun backtrack(curr: MutableList<Int>, ans: MutableList<List<Int>>, nums: IntArray) {
        if (curr.size == nums.size) {
            ans.add(ArrayList(curr))
            return
        }
        for (num in nums) {
            if (!curr.contains(num)) {
                curr.add(num)
                backtrack(curr, ans, nums)
                curr.removeAt(curr.size - 1)
            }
        }
    }
    backtrack(ArrayList(), ans, nums)
    return ans
}
