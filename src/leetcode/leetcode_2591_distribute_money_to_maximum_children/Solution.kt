package leetcode.leetcode_2591_distribute_money_to_maximum_children

/**
 * leetcode - https://leetcode.com/problems/distribute-money-to-maximum-children/
 *
 * Using maths
 *
 * Stats
 * Runtime: 154 ms, faster than 86.36%
 * Memory Usage: 35 MB, less than 79.55%
 */
private fun distMoney(money: Int, children: Int): Int {
    if (money < children) {
        return -1
    }
    val remaining = money - children
    return if (remaining == children * 7) {
        children
    } else if (remaining > children * 7) {
        children - 1
    } else if (remaining == (((children - 1) * 7) + 3)) {
        (remaining / 7) - 1
    } else {
        remaining / 7
    }
}

private fun main() {

}
