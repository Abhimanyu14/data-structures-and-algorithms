package leetcode.leet_100_to_199.leet_136_single_number

/**
 * Using XOR
 * Source - https://leetcode.com/problems/single-number/discuss/1343068/Kotlin-3-ways-faster-than-99.7
 *
 * Stats
 * Runtime: 379 ms, faster than 74.09%
 * Memory Usage: 48 MB, less than 73.90%
 */
fun singleNumber(nums: IntArray): Int {
    var result = 0
    nums.forEach {
        result = result xor it
    }
    return result
}

/**
 * Using Set
 *
 * Stats
 * Runtime: 682 ms, faster than 8.57%
 * Memory Usage: 56 MB, less than 5.90%
 */
fun singleNumberUsingSet(nums: IntArray): Int {
    val set = HashSet<Int>()
    nums.forEach {
        if (set.contains(it)) {
            set.remove(it)
        } else {
            set.add(it)
        }
    }
    return set.elementAt(0)
}

fun main() {
    println(singleNumber(intArrayOf(2, 2, 1)))
    println(singleNumber(intArrayOf(4, 1, 2, 1, 2)))
    println(singleNumber(intArrayOf(1)))
    println(singleNumber(intArrayOf(1, 3, 1)))
}
