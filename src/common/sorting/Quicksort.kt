package common.sorting

fun partition(arr: IntArray, low: Int, high: Int): Int {
    // pivot (Element to be placed at right position)
    val pivot = arr[high]

    var i = (low - 1)
    // Index of smaller element and indicates the
    // right position of pivot found so far

    for (j in low until high) {
        // If current element is smaller than the pivot
        if (arr[j] < pivot) {
            // increment index of smaller element
            i++
            arr[i] = arr[j].also { arr[j] = arr[i] }
        }
    }
    arr[i + 1] = arr[high].also { arr[high] = arr[i + 1] }
    return i + 1
}

fun quicksort(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        val pi = partition(arr, low, high)
        quicksort(arr, low, pi - 1)
        quicksort(arr, pi + 1, high)
    }
}

fun quicksortDriver(arr: IntArray) {
    return quicksort(arr, 0, arr.size - 1)
}

fun main() {
    val input = intArrayOf(10, 80, 30, 90, 40, 50, 70)
    quicksortDriver(input)
    input.forEach {
        print("$it ")
    }
}
