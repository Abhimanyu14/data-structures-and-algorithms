package leetcode.leetcode_744_find_smallest_letter_greater_than_target

/**
 * leetcode - https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 *
 * Using binary search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 38.7 MB, less than 46.58%
 *
 * Time -
 * Space -
 */
private fun nextGreatestLetter(letters: CharArray, target: Char): Char {
    var left = 0
    var right = letters.size
    while (left < right) {
        val mid = left + ((right - left) / 2)
        if (letters[mid] > target) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return if (left == letters.size) {
        letters[0]
    } else {
        letters[left]
    }
}

private fun main() {

}
