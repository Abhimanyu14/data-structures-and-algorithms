package leetcode.leet_2400_to_2499.leet_2483_minimum_penalty_for_a_shop

/**
 * leetcode - https://leetcode.com/problems/minimum-penalty-for-a-shop/
 *
 * Using single pass
 *
 * Stats
 * Runtime: 193 ms, faster than 88.89%
 * Memory Usage: 38 MB, less than 88.89%
 */
private fun bestClosingTime(customers: String): Int {
    var currentPenalty = 0
    var hour = 0
    var minPenalty = 0
    customers.forEachIndexed { index, customer ->
        if (customer == 'Y') {
            currentPenalty--
        } else {
            currentPenalty++
        }
        if (currentPenalty < minPenalty) {
            minPenalty = currentPenalty
            hour = index + 1
        }
    }
    return hour
}

/**
 * leetcode - https://leetcode.com/problems/minimum-penalty-for-a-shop/
 *
 * Using two pass
 *
 * Stats
 * Runtime: 222 ms, faster than 44.44%
 * Memory Usage: 37.8 MB, less than 100.00%
 */
private fun bestClosingTimeTwoPass(customers: String): Int {
    var minPenalty = customers.count {
        it == 'Y'
    }
    var minIndex = 0
    var currentPenalty = minPenalty
    customers.forEachIndexed { index, customer ->
        if (customer == 'Y') {
            currentPenalty--
        } else {
            currentPenalty++
        }
        if (currentPenalty < minPenalty) {
            minPenalty = currentPenalty
            minIndex = index + 1
        }
    }
    return minIndex
}

private fun main() {

}
