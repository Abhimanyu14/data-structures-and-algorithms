package data_structures_and_algorithms.searching.binarysearch

/**
 * Lower Bound - Smallest index where input[outputIndex] >= target
 * Note:
 * 1. If target > last item in array, output will be the size of the array
 */
private fun lowerBounds(input: IntArray, target: Int): Int {
    var low = 0
    var high = input.lastIndex
    var result = input.size
    while (low <= high) {
        val mid = low + ((high - low) / 2)
        if (input[mid] >= target) {
            high = mid - 1
            result = mid
        } else {
            low = mid + 1
        }
    }
    return result
}

/**
 * Upper Bound - Largest index where input[outputIndex] <= target
 * Note:
 * 1. If target > last item in array, output will be the size of the array
 */
private fun upperBounds(input: IntArray, target: Int): Int {
    var low = 0
    var high = input.lastIndex
    var result = -1
    while (low <= high) {
        val mid = low + ((high - low) / 2)
        if (input[mid] <= target) {
            low = mid + 1
            result = mid
        } else {
            high = mid - 1
        }
    }
    return result
}

private fun main() {
    val input = intArrayOf(1, 1, 2, 2, 2, 3, 4, 5, 5, 5, 6)
    for (i in 0..7) {
        print("${lowerBounds(input, i)}, ")
    }
    println()
    for (i in 0..7) {
        print("${upperBounds(input, i)}, ")
    }
}
