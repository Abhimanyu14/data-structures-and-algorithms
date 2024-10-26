package leetcode.leet_2800_to_2899.leet_2839_check_if_strings_can_be_made_equal_with_operations_i

/**
 * leetcode - https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/
 *
 * TODO(Abhi) - To revisit
 *
 * Using conditionals
 *
 * Stats
 * Runtime: 174 ms, faster than 51.43%
 * Memory Usage: 35.2 MB, less than 91.43%
 */
private fun canBeEqual(s1: String, s2: String): Boolean {
    return ((s1[0] == s2[0] && s1[2] == s2[2]) || (s1[0] == s2[2] && s1[2] == s2[0])) &&
            ((s1[1] == s2[1] && s1[3] == s2[3]) || (s1[1] == s2[3] && s1[3] == s2[1]))
}

private fun main() {

}
