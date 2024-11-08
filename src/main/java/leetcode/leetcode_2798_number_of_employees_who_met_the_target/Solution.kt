package leetcode.leetcode_2798_number_of_employees_who_met_the_target

/**
 * leetcode - https://leetcode.com/problems/number-of-employees-who-met-the-target/
 *
 * Using [count]
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 42.2 MB, less than 6.25%
 *
 * Time -
 * Space -
 */
private fun numberOfEmployeesWhoMetTarget(hours: IntArray, target: Int): Int {
    return hours.count {
        it >= target
    }
}

private fun main() {

}
