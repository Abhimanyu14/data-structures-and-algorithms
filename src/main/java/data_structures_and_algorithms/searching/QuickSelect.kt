package data_structures_and_algorithms.searching

/**
 * To find the k-th smallest element in an array
 */
fun partition(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1
    for (j in low..<high) {
        if (arr[j] < pivot) {
            i++
            arr[i] = arr[j].also { arr[j] = arr[i] }
        }
    }
    arr[i + 1] = arr[high].also { arr[high] = arr[i + 1] }
    return i + 1
}

fun quickSelect(arr: IntArray, low: Int, high: Int, k: Int): Int {
    val partitionIndex = partition(arr, low, high)
    return when {
        partitionIndex == k -> {
            arr[partitionIndex]
        }

        partitionIndex < k -> {
            quickSelect(arr, partitionIndex + 1, high, k)
        }

        else -> {
            quickSelect(arr, low, partitionIndex - 1, k)
        }
    }
}

fun quickSelectDriver(arr: IntArray, k: Int): Int {
    return quickSelect(arr, 0, arr.lastIndex, k - 1)
}

private fun main() {
    val input1 = intArrayOf(7, 10, 4, 3, 20, 15)
    for (i in 1..6) {
        println(quickSelectDriver(input1, i))
    }
}
