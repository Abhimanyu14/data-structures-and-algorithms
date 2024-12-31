package data_structures_and_algorithms.sorting

import kotlin.math.abs
import kotlin.math.max

/**
 * Time - O(d * (n+b))
 * Space - O(n+b)
 */
// Bucket sort function for each place value digit.
private fun bucketSort(input: IntArray, placeValue: Int) {
    val buckets = ArrayList<MutableList<Int>>(10)
    for (digit in 0..9) {
        buckets.add(digit, ArrayList())
    }
    
    // Store the respective number based on its digit.
    for (num in input) {
        var digit = (abs(num) / placeValue)
        digit %= 10
        buckets[digit].add(num)
    }

    // Overwrite 'arr' in sorted order of current place digits.
    var index = 0
    for (digit in 0..9) {
        for (num in buckets[digit]) {
            input[index] = num
            index++
        }
    }
}

// Radix sort function.
private fun radixSort(input: IntArray) {
    // Find the absolute maximum element to find max number of digits.
    var maxElement = input[0]
    for (num in input) {
        maxElement = max(abs(num), maxElement)
    }
    var maxDigits = 0
    while (maxElement > 0) {
        maxDigits += 1
        maxElement /= 10
    }

    // Radix sort, the least significant digit place to most significant.
    var placeValue = 1
    for (digit in 0..<maxDigits) {
        bucketSort(input, placeValue)
        placeValue *= 10
    }

    // Separate out negatives and reverse them.
    val negatives = ArrayList<Int>()
    val positives = ArrayList<Int>()
    for (num in input) {
        if (num < 0) {
            negatives.add(num)
        } else {
            positives.add(num)
        }
    }
    negatives.reverse()

    // Final 'answer' will be 'negative' elements, then 'positive' elements.
    var index = 0
    for (num in negatives) {
        input[index] = num
        index++
    }
    for (num in positives) {
        input[index] = num
        index++
    }
}

private fun main() {
    val input = intArrayOf(10, 80, 30, 90, 40, 50, 70)
    radixSort(input)
}
