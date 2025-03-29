package geeks_for_geeks.find_triplets_array_whose_sum_equal_zero

/**
 * link - https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/
 */
private fun zeroSumTripletsNaive(intArray: IntArray) {
    for (i in intArray.indices) {
        for (j in i + 1..intArray.lastIndex) {
            for (k in j + 1..intArray.lastIndex) {
                if (intArray[i] + intArray[j] + intArray[k] == 0) {
                    println("(${intArray[i]}, ${intArray[j]}, ${intArray[k]})")
                }
            }
        }
    }
    println()
}

private fun main() {
    zeroSumTripletsNaive(intArrayOf(0, -1, 2, -3, 1))
    zeroSumTripletsNaive(intArrayOf(1, -2, 1, 0, 5))
}
