package data_structures_and_algorithms.memoization

/**
 * Question - https://youtu.be/oBt53YbR9Kk
 * Check if given sum can be obtained from the set of numbers provided and they can be repeated
 * Result: Return the required combination of elements of the array
 */
fun howSumRecursive(nums: IntArray, sum: Int): IntArray? {
    if (sum == 0) {
        return intArrayOf()
    }
    if (sum < 0) {
        return null
    }
    for (i in nums.indices) {
        howSumRecursive(nums, sum - nums[i])?.let {
            return intArrayOf(*it, nums[i])
        }
    }
    return null
}

/**
 * Memoization
 */
fun howSum(nums: IntArray, sum: Int, memo: HashMap<Int, IntArray?>): IntArray? {
    if (memo.containsKey(sum)) {
        return memo[sum]
    }
    if (sum == 0) {
        return intArrayOf()
    }
    if (sum < 0) {
        return null
    }
    for (i in nums.indices) {
        howSum(nums, sum - nums[i], memo)?.let {
            memo[sum] = intArrayOf(*it, nums[i])
            return memo[sum]
        }
    }
    memo[sum] = null
    return memo[sum]
}

private fun main() {
    val input1 = intArrayOf(2, 3)
    val input2 = intArrayOf(5, 3, 4, 7)
    val input3 = intArrayOf(2, 4)
    val input4 = intArrayOf(2, 3, 5)
    val input5 = intArrayOf(7, 14)

    println(howSum(input1, 7, hashMapOf())?.joinToString(", ")) // true
    println(howSum(input2, 7, hashMapOf())?.joinToString(", ")) // true
    println(howSum(input3, 7, hashMapOf())?.joinToString(", ")) // false
    println(howSum(input4, 8, hashMapOf())?.joinToString(", ")) // true
    println(howSum(input5, 300, hashMapOf())?.joinToString(", ")) // false
}
