package common.searching

fun binarySearch(arr: IntArray, low: Int, high: Int, element: Int): Int {
    if (high < low) {
        return -1
    }
    val mid = low +  (high - low) / 2
    return when {
        element == arr[mid] -> {
            mid
        }
        element > arr[mid] -> {
            binarySearch(arr, mid + 1, high, element)
        }
        else -> {
            binarySearch(arr, low, mid, element)
        }
    }
}

fun main() {
    val arr = intArrayOf(1, 2, 5, 8)
    val result = binarySearch(arr, 0, arr.size, 5)
    print(result)
}
