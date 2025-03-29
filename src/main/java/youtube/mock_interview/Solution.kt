package youtube.mock_interview

/**
 * link - https://www.youtube.com/watch?v=riBWq1DvVb8
 *
 * Given an array of n integers, construct a product array of the same size
 * such that the i th element of the product array is equal to the product of
 * all the elements of the original array except for the i th element.
 */
private fun productExceptSelf(arr: IntArray): IntArray {
    if (arr.isEmpty()) {
        return arr
    }
    val zeroCount = arr.count { it == 0 }
    return if (zeroCount > 1) {
        IntArray(arr.size) { 0 }
    } else if (zeroCount == 1) {
        val product = arr.filter { it != 0 }.reduce { acc, i -> acc * i }
        arr.map {
            if (it == 0) {
                product
            } else {
                0
            }
        }.toIntArray()
    } else {
        val product = arr.reduce { acc, i -> acc * i }
        arr.map { (product / it) }.toIntArray()
    }
}

private fun main() {
    println(productExceptSelf(intArrayOf(1, 2, 3, 4)).joinToString(", "))
    println(productExceptSelf(intArrayOf(0, 1, 2, 3, 4)).joinToString(", "))
    println(productExceptSelf(intArrayOf(0, 1, 2, 0, 4)).joinToString(", "))
    println(productExceptSelf(intArrayOf(-1, 2, -3, 4)).joinToString(", "))
    println(productExceptSelf(intArrayOf()).joinToString(", "))
}
