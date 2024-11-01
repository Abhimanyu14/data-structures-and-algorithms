package leetcode.leetcode_1400_to_1499.leetcode_1442_count_triplets_that_can_form_two_arrays_of_equal_xor


/**
 * leetcode - https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/solution/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun countTriplets(arr: IntArray): Int {
    var count = 0
    var prefix = 0

    // Maps to store counts and totals of XOR values encountered
    val countMap: MutableMap<Int, Int> = HashMap()
    countMap[0] = 1
    val totalMap: MutableMap<Int, Int> = HashMap()

    // Iterating through the array
    for (i in arr.indices) {
        // Calculating XOR prefix
        prefix = prefix xor arr[i]

        // Calculating contribution of current element to the result
        count += countMap.getOrDefault(prefix, 0) * i - totalMap.getOrDefault(prefix, 0)

        // Updating total count of current XOR value
        totalMap[prefix] = totalMap.getOrDefault(prefix, 0) + i + 1
        countMap[prefix] = countMap.getOrDefault(prefix, 0) + 1
    }

    return count
}

private fun main() {

}
