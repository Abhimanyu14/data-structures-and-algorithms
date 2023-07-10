package leetcode.leet_200_to_299.leet_238_product_of_array_except_self

/**
 * Given an array of n integers, construct a product array of the same size
 * such that the i th element of the product array is equal to the product of
 * all the elements of the original array except for the i th element.
 */
private fun productExceptSelf(arr: IntArray): IntArray {
    if (arr.isEmpty()) {
        return arr
    }
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
