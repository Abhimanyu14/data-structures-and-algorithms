package algorithms.sorting

/**
 * Time - O(N * log(N))
 * Space - O(N)
 */
private fun mergeSort(input: IntArray, left: Int, right: Int, swapArray: IntArray) {
    if (left >= right) {
        return
    }

    // Function to merge two sub-arrays in sorted order.
    fun merge(left: Int, mid: Int, right: Int) {
        val partition1StartIndex = left
        val partition2StartIndex = mid + 1
        val partition1Size = mid - left + 1
        val partition2Size = right - (mid + 1) + 1
        for (i in 0..<partition1Size) {
            swapArray[partition1StartIndex + i] = input[partition1StartIndex + i]
        }
        for (i in 0..<partition2Size) {
            swapArray[partition2StartIndex + i] = input[partition2StartIndex + i]
        }
        var partition1Pointer = 0
        var partition2Pointer = 0
        var current = left
        while (partition1Pointer < partition1Size && partition2Pointer < partition2Size) {
            if (swapArray[partition1StartIndex + partition1Pointer] <= swapArray[partition2StartIndex + partition2Pointer]) {
                input[current] = swapArray[partition1StartIndex + partition1Pointer]
                partition1Pointer++
            } else {
                input[current] = swapArray[partition2StartIndex + partition2Pointer]
                partition2Pointer++
            }
            current++
        }
        while (partition1Pointer < partition1Size) {
            input[current] = swapArray[partition1StartIndex + partition1Pointer]
            partition1Pointer++
            current++
        }
        while (partition2Pointer < partition2Size) {
            input[current] = swapArray[partition2StartIndex + partition2Pointer]
            partition2Pointer++
            current++
        }
    }

    val mid = left + ((right - left) / 2)
    mergeSort(input, left, mid, swapArray)
    mergeSort(input, mid + 1, right, swapArray)
    merge(left, mid, right)
}

private fun main() {
    val input = intArrayOf(10, 80, 30, 90, 40, 50, 70)
    mergeSort(input, 0, input.lastIndex, IntArray(input.size))
}
