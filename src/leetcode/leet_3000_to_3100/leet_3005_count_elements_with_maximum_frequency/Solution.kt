package leetcode.leet_3000_to_3100.leet_3005_count_elements_with_maximum_frequency

/**
 * leetcode - https://leetcode.com/problems/count-elements-with-maximum-frequency/
 *
 * Using single pass
 *
 * Stats
 * Runtime: 174 ms, faster than 68.33%
 * Memory Usage: 35.1 MB, less than 89.17%
 */
private fun maxFrequencyElements(nums: IntArray): Int {
    var maxCount = 0
    var maxFrequency = 0
    val counter = mutableMapOf<Int, Int>()
    nums.forEach { num ->
        counter[num] = counter.getOrDefault(num, 0) + 1
        counter[num]?.let {
            if (it > maxFrequency) {
                maxFrequency = it
                maxCount = 1
            } else if (it == maxFrequency) {
                maxCount++
            }
        }
    }
    return maxCount * maxFrequency
}

/**
 * leetcode - https://leetcode.com/problems/count-elements-with-maximum-frequency/
 *
 * Using map
 *
 * Stats
 * Runtime: 164 ms, faster than 83.33%
 * Memory Usage: 35.4 MB, less than 72.50%
 */
private fun maxFrequencyElementsUsingMap(nums: IntArray): Int {
    var maxCount = 0
    val counter = mutableMapOf<Int, Int>()
    nums.forEach {
        counter[it] = counter.getOrDefault(it, 0) + 1
        counter[it]?.let {
            if (it > maxCount) {
                maxCount = it
            }
        }
    }
    var result = 0
    counter.forEach { (_, value) ->
        if (value == maxCount) {
            result++
        }
    }
    return result * maxCount
}

private fun main() {

}
