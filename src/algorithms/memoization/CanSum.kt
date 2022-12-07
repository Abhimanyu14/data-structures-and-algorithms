package algorithms.memoization

/**
 * Question - https://youtu.be/oBt53YbR9Kk
 * Check if given sum can be obtained from the set of numbers provided and they can be repeated
 * Result: Return a boolean denoting possible or not
 */
fun canSumRecursive(nums: IntArray, sum: Int): Boolean {
    if (sum == 0) {
        return true
    }
    if (sum < 0) {
        return false
    }
    return nums.any {
        canSumRecursive(nums, sum - it)
    }
}

/**
 * Memoization
 */
fun canSum(nums: IntArray, sum: Int, memo: HashMap<Int, Boolean>): Boolean {
    memo[sum]?.let {
        return it
    }
    if (sum == 0) {
        return true
    }
    if (sum < 0) {
        return false
    }
    memo[sum] = nums.any {
        canSum(nums, sum - it, memo)
    }
    return memo[sum]!!
}

fun main() {
    val input1 = intArrayOf(2, 3)
    val input2 = intArrayOf(5, 3, 4, 7)
    val input3 = intArrayOf(2, 4)
    val input4 = intArrayOf(2, 3, 5)
    val input5 = intArrayOf(7, 14)

    println(canSum(input1, 7, hashMapOf())) // true
    println(canSum(input2, 7, hashMapOf())) // true
    println(canSum(input3, 7, hashMapOf())) // false
    println(canSum(input4, 8, hashMapOf())) // true
    println(canSum(input5, 300, hashMapOf())) // false
}
