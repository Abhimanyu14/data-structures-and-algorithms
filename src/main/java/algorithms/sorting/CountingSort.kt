package algorithms.sorting

import kotlin.math.max
import kotlin.math.min

/**
 * Time - O(n + k)
 * Space - O(n)
 */
private fun countingSort(arr: IntArray) {
    val counter = mutableMapOf<Int, Int>()
    var minValue = arr[0]
    var maxValue = arr[0]
    for (i in arr.indices) {
        minValue = min(minValue, arr[i])
        maxValue = max(maxValue, arr[i])
        counter[arr[i]] = counter.getOrDefault(arr[i], 0) + 1
    }
    var index = 0
    for (num in minValue..maxValue) {
        for (i in 0..<counter.getOrDefault(num, 0)) {
            arr[index] = num
            index++
        }
    }
}

private fun main() {
    val input = intArrayOf(10, 80, 30, 90, 40, 50, 70)
    countingSort(input)
}
