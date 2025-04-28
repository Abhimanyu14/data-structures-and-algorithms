package data_structures.memoization

/**
 * Question - https://youtu.be/oBt53YbR9Kk
 * Check if given sum can be obtained from the set of numbers provided and they can be repeated
 * Result: Return the required combination of elements of the array with least number of elements
 */
fun bestSumRecursive(nums: IntArray, sum: Int): IntArray? {
    if (sum == 0) {
        return intArrayOf()
    }
    if (sum < 0) {
        return null
    }
    var result: IntArray? = null
    for (i in nums.indices) {
        bestSumRecursive(nums, sum - nums[i])?.let { it ->
            intArrayOf(*it, nums[i]).let { newAr ->
                if (newAr.size < result?.size ?: Int.MAX_VALUE) {
                    result = newAr
                }
            }
        }
    }
    return result
}

/**
 * Memoization
 */
fun bestSum(nums: IntArray, sum: Int, memo: HashMap<Int, IntArray?>): IntArray? {
    if (memo.containsKey(sum)) {
        return memo[sum]
    }
    if (sum == 0) {
        return intArrayOf()
    }
    if (sum < 0) {
        return null
    }
    memo[sum] = null
    for (i in nums.indices) {
        bestSum(nums, sum - nums[i], memo)?.let {
            intArrayOf(*it, nums[i]).let { newArr ->
                if (newArr.size < memo[sum]?.size ?: Int.MAX_VALUE) {
                    memo[sum] = newArr
                }
            }
        }
    }
    return memo[sum]
}

private fun main() {
    val input1 = intArrayOf(2, 3)
    val input2 = intArrayOf(5, 3, 4, 7)
    val input3 = intArrayOf(2, 4)
    val input4 = intArrayOf(2, 3, 5)
    val input5 = intArrayOf(7, 14)
    val input6 = intArrayOf(1, 4, 5)

//    println(bestSumRecursive(input1, 7)?.joinToString(", ")) // true
//    println(bestSumRecursive(input2, 7)?.joinToString(", ")) // true
//    println(bestSumRecursive(input3, 7)?.joinToString(", ")) // false
//    println(bestSumRecursive(input4, 8)?.joinToString(", ")) // true
//    println(bestSumRecursive(input5, 300)?.joinToString(", ")) // false
//    println(bestSumRecursive(input6, 8)?.joinToString(", ")) // false

    println(bestSum(input1, 7, hashMapOf())?.joinToString(", ")) // true
    println(bestSum(input2, 7, hashMapOf())?.joinToString(", ")) // true
    println(bestSum(input3, 7, hashMapOf())?.joinToString(", ")) // false
    println(bestSum(input4, 8, hashMapOf())?.joinToString(", ")) // true
    println(bestSum(input5, 300, hashMapOf())?.joinToString(", ")) // false
    println(bestSum(input6, 8, hashMapOf())?.joinToString(", ")) // false
}
