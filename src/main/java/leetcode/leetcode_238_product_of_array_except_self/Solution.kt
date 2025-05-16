package leetcode.leetcode_238_product_of_array_except_self

/**
 * leetcode - https://leetcode.com/problems/product-of-array-except-self/
 *
 * Data Structure - [IntArray]
 * Algorithm - Two Pass
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 325 ms, faster than 31.56%
 * Memory Usage: 53.2 MB, less than 5.07%
 *
 * Time -  O(N)
 * Space - O(1) - Output space not considered
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun productExceptSelf(arr: IntArray): IntArray {
    val result = IntArray(arr.size)
    var currentProduct = 1
    for (i in arr.indices) {
        result[i] = currentProduct
        currentProduct *= arr[i]
    }
    currentProduct = 1
    for (i in arr.lastIndex downTo 0) {
        result[i] *= currentProduct
        currentProduct *= arr[i]
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Using two pointers
 *
 * Stats
 *
 *
 * Given an array of n integers, construct a product array of the same size
 * such that the i th element of the product array is equal to the product of
 * all the elements of the original array except for the i th element.
 */
private fun productExceptSelfUsingMap(arr: IntArray): IntArray {
    val zeroCount = arr.count { it == 0 }
    return if (zeroCount > 1) {
        IntArray(arr.size) { 0 }
    } else if (zeroCount == 1) {
        val product = arr.filter { it != 0 }.reduce { acc, i -> acc * i }
        arr.map {
            if (it == 0) {
                product
            } else {
                0
            }
        }.toIntArray()
    } else {
        val product = arr.reduce { acc, i -> acc * i }
        arr.map { (product / it) }.toIntArray()
    }
}

private fun productExceptSelfUsingTwoDirectionalLoops(arr: IntArray): IntArray {
    val result = IntArray(arr.size)
    var s = 1
    for (i in arr.indices) {
        result[i] = s
        s *= arr[i]
    }
    s = 1
    for (i in arr.size - 1 downTo 0) {
        result[i] = result[i] * s
        s *= arr[i]
    }
    return result
}

private fun productExceptSelfUsingPartialProduct(arr: IntArray): IntArray {
    val result = IntArray(arr.size)
    val left = IntArray(arr.size)
    val right = IntArray(arr.size)
    var s = 1
    for (i in arr.indices) {
        left[i] = s
        s *= arr[i]
    }
    s = 1
    for (i in arr.size - 1 downTo 0) {
        right[i] = s
        s *= arr[i]
    }
    for (i in arr.indices) {
        result[i] = left[i] * right[i]
    }
    return result
}

private fun main() {
    val solutionMethod = ::productExceptSelfUsingPartialProduct
    println(solutionMethod(intArrayOf(1, 2, 3, 4)).joinToString(", "))
    println(solutionMethod(intArrayOf(0, 1, 2, 3, 4)).joinToString(", "))
    println(solutionMethod(intArrayOf(0, 1, 2, 0, 4)).joinToString(", "))
    println(solutionMethod(intArrayOf(-1, 2, -3, 4)).joinToString(", "))
    println(solutionMethod(intArrayOf()).joinToString(", "))
}
