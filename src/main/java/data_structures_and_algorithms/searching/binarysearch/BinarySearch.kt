package data_structures_and_algorithms.searching.binarysearch

/**
 * Note:
 * 1. Input has to be sorted
 * 2. Use val mid = low + ((high - low) / 2) instead of val mid = (high + low) / 2 to avoid Integer overflow error
 */
private fun binarySearchIterative(input: IntArray, target: Int): Int {
    var low = 0
    var high = input.lastIndex
    while (low <= high) {
        val mid = low + ((high - low) / 2)
        if (target == input[mid]) {
            return mid
        } else if (target < input[mid]) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return -1
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

private fun binarySearch(input: IntArray, target: Int): Int {
    return binarySearchIterative(input, target)
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
