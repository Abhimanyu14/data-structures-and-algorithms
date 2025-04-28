package algorithms.searching.binarysearch

/**
 * Note:
 * 1. Input has to be sorted
 * 2. Use val mid = low + ((high - low) / 2) instead of val mid = (high + low) / 2 to avoid Integer overflow error
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 */
internal fun binarySearch(nums: IntArray, target: Int): Int {
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
    return if (target == nums[left]) {
        left
    } else {
        -1
    }
}

private fun binarySearchRecursive(input: IntArray, target: Int, low: Int = 0, high: Int = input.lastIndex): Int {
    if (high < low) {
        return -1
    }
    val mid = low + ((high - low) / 2)
    return when {
        target == input[mid] -> mid
        target > input[mid] -> binarySearchRecursive(input, target, mid + 1, high)
        else -> binarySearchRecursive(input, target, low, mid - 1)
    }
}

private fun main() {
    val input = intArrayOf(1, 2, 5, 8)
    println("1 at index: ${binarySearch(input, 1)}")
    println("2 at index: ${binarySearch(input, 2)}")
    println("3 at index: ${binarySearch(input, 3)}")
    println("4 at index: ${binarySearch(input, 4)}")
    println("5 at index: ${binarySearch(input, 5)}")
    println("7 at index: ${binarySearch(input, 7)}")
    println("8 at index: ${binarySearch(input, 8)}")
    println("10 at index: ${binarySearch(input, 10)}")
}
