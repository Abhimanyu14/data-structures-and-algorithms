package geeks_for_geeks.find_maximum_minimum_sum_subarray_size_k

import kotlin.math.max

fun solution(arr: IntArray, size: Int): Int {
    var result = 0
    for (i in 0 until size) {
        result += arr[i]
    }
    var currentSum = result
    for (i in size until arr.size) {
        currentSum += arr[i] - arr[i - size]
        result = max(result, currentSum)
    }
    return result
}

fun main() {
    val result = solution(intArrayOf(100, 200, 300, 400), 2)
    println(result)
}
