package geeks_for_geeks.find_minimum_difference_pair

import kotlin.math.abs

/**
 * link - https://www.geeksforgeeks.org/find-minimum-difference-pair/
 */
fun bruteForceSolution(arr: IntArray): Int {
    var result = Int.MAX_VALUE
    for (i in arr.indices) {
        for (j in i + 1..<arr.size) {
            result = minOf(abs(arr[i] - arr[j]), result)
        }
    }
    return result
}

fun solutionUsingSorting(arr: IntArray): Int {
    val sorted = arr.sortedArray()
    var result = abs(sorted[0] - sorted[1])
    for (i in 2..<sorted.size) {
        result = minOf(result, abs(sorted[i] - sorted[i - 1]))
    }
    return result
}

fun main() {
    val input1 = intArrayOf(1, 5, 3, 19, 18, 25)
    val input2 = intArrayOf(30, 5, 20, 9)
    val input3 = intArrayOf(1, 19, -4, 31, 38, 25, 100)
    println(bruteForceSolution(input1))
    println(bruteForceSolution(input2))
    println(bruteForceSolution(input3))
    println()
    println(solutionUsingSorting(input1))
    println(solutionUsingSorting(input2))
    println(solutionUsingSorting(input3))
}
