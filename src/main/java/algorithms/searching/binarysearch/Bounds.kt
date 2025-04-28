package algorithms.searching.binarysearch

/**
 * Lower Bound - Index of Smallest number >= target
 * // TODO(Abhi): Test this
 *
 * Note:
 * 1. If target > last item in array, output will be the size of the array
 */
private fun lowerBounds(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.lastIndex
    while (left < right) {
        val mid = left + ((right - left) / 2)
        if (nums[mid] >= target) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

/**
 * Upper Bound - Index of Largest number <= target
 * // TODO(Abhi): Fix this
 *
 * Note:
 * 1. If target < first item in array, output will be the 0
 */
private fun upperBounds(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.lastIndex
    while (left < right) {
        val mid = left + ((right - left) / 2)
        if (nums[mid] <= target) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
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
