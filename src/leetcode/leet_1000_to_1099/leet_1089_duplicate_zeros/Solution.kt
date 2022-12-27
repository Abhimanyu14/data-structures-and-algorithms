package leetcode.leet_1000_to_1099.leet_1089_duplicate_zeros

/**
 * leetcode - https://leetcode.com/problems/duplicate-zeros/
 *
 * Using two pointers
 *
 * Stats
 * Runtime: 351 ms, faster than 76.00%
 * Memory Usage: 41.9 MB, less than 47.00%
 */
private fun duplicateZeros(arr: IntArray): Unit {
    var insertPointer = arr.lastIndex
    var i = 0
    var checkPointer = -1
    while (i < arr.size) {
        checkPointer++
        if (arr[checkPointer] == 0) {
            i++
        }
        i++
    }
    if (arr[checkPointer] == 0) {
        if (i > arr.size) {
            arr[insertPointer--] = arr[checkPointer--]
        } else {
            arr[insertPointer--] = 0
            arr[insertPointer--] = 0
            checkPointer--
        }
    }
    while (checkPointer >= 0) {
        if (arr[checkPointer] != 0) {
            arr[insertPointer--] = arr[checkPointer--]
        } else {
            arr[insertPointer--] = 0
            arr[insertPointer--] = 0
            checkPointer--
        }
    }
}

private fun main() {

}
