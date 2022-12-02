package leetcode.leet_400_to_499.leet_485_max_consecutive_ones

/**
 * Using loop
 *
 * Stats
 * Runtime: 478 ms, faster than 77.02%
 * Memory Usage: 66.2 MB, less than 71.43%
 */
private fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var result = 0
    var counter = 0
    nums.forEach {
        if (it == 1) {
            counter++
        } else {
            if (counter > result) {
                result = counter
            }
            counter = 0
        }
    }
    if (counter > result) {
        result = counter
    }

    return result
}

private fun main() {

}
