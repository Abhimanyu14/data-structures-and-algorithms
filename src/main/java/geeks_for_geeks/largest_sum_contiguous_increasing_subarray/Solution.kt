package geeks_for_geeks.largest_sum_contiguous_increasing_subarray

/**
 * link - https://www.geeksforgeeks.org/largest-sum-contiguous-increasing-subarray/
 */
fun solution(arr: IntArray): Int {
    var result = Int.MIN_VALUE
    var currentMax = arr[0]
    for (i in 1..<arr.size) {
        if (arr[i] < arr[i - 1]) {
            currentMax = 0
        }
        currentMax += arr[i]
        if (result < currentMax) {
            result = currentMax
        }
    }
    return result
}

fun main() {
    val result = solution(intArrayOf(2, 1, 4, 7, 3, 6))
    println(result)
}
