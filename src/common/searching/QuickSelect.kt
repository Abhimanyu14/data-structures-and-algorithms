package common.searching

/**
 * To find k-th smallest element in a array
 */

fun partition(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1
    for (j in low until high) {
        if (arr[j] < pivot) {
            i++
            arr[i] = arr[j].also { arr[j] = arr[i] }
        }
    }
    arr[i + 1] = arr[high].also { arr[high] = arr[i + 1] }
    return i + 1
}

fun quickSelect(arr: IntArray, low: Int, high: Int, k: Int): Int {
    val pi = partition(arr, low, high)
    return when {
        pi == k -> {
            arr[pi]
        }
        pi < k -> {
            quickSelect(arr, pi + 1, high, k)
        }
        else -> {
            quickSelect(arr, low, pi - 1, k)
        }
    }
}

fun quickSelectDriver(arr: IntArray, k: Int): Int {
    return quickSelect(arr, 0, arr.size - 1, k - 1)
}

fun main() {
    val input1 = intArrayOf(7, 10, 4, 3, 20, 15)
    for (i in 1..6) {
        println(quickSelectDriver(input1, i))
    }
}
