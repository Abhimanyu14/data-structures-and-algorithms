package geeks_for_geeks.largest_sum_contiguous_subarray

/**
 * link - https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
fun solution(arr: IntArray): Int {
    var result = Int.MIN_VALUE
    var currentMax = 0
    arr.forEach {
        currentMax += it
        if (result < currentMax) {
            result = currentMax
        }
        if (currentMax < 0) {
            currentMax = 0
        }
    }
    return result
}

fun main() {
    val result = solution(intArrayOf(-2, -3, 4, -1, -2, 1, 5, -3))
    println(result)
}
