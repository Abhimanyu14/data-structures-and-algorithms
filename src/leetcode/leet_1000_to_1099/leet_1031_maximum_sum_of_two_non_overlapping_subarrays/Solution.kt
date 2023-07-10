package leetcode.leet_1000_to_1099.leet_1031_maximum_sum_of_two_non_overlapping_subarrays

fun solution(arr: IntArray, size: Int, start: Int, end: Int): Triple<Int, Int, Int> {
    if (end - start + 1 < size) {
        return Triple(-1, -1, -1)
    }
    var result = 0
    var position = 0
    for (i in start until size) {
        result += arr[i]
    }
    var currentSum = result
    for (i in size until end + 1) {
        currentSum += arr[i] - arr[i - size]
        if (result < currentSum) {
            result = currentSum
            position = i - size + 1
        }
    }
    return Triple(result, position, position + size - 1)
}

fun maxSumTwoNoOverlap(nums: IntArray, firstLen: Int, secondLen: Int): Int {
//    val (firstResult, firstStart, firstEnd) = solution(nums, firstLen, 0, nums.size - 1)
//    val (secondResult, secondStart, secondEnd) = solution(nums, secondLen, 0, nums.size - 1)
//
//    val a1 = firstResult + solution(nums, secondLen, 0, firstStart - 1).first
//    val a2 = firstResult + solution(nums, secondLen, firstEnd + 1, nums.size - 1).first
//    val a3 = secondResult + solution(nums, firstLen, 0, secondStart - 1).first
//    val a4 = secondResult + solution(nums, firstLen, secondEnd + 1, nums.size - 1).first

    var result = Int.MIN_VALUE
    var currentSum = 0
    var sum1 = 0
    var sum2 = 0
    for (i in 0..nums.size + 1) {
        sum1 = nums.copyOfRange(i, i + firstLen).sum()
        for (j in (i + firstLen)..nums.size + 1) {
            sum2 = nums.copyOfRange(i, i + firstLen).sum()
        }
    }
    return 0
}

private fun main() {
    val result = maxSumTwoNoOverlap(intArrayOf(0, 6, 5, 2, 2, 5, 1, 9, 4), 1, 2)
    println(result)
}
