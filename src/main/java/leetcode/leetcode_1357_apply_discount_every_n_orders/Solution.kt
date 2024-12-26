package leetcode.leetcode_1357_apply_discount_every_n_orders

/**
 * leetcode - https://leetcode.com/problems/apply-discount-every-n-orders/
 *
 * Data Structure - Map
 * Algorithm - Hashing and Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 236 ms, faster than 100.00%
 * Memory Usage: 92.7 MB, less than 100.00%
 *
 * Time - O(N)
 * Space - O(N)
 */
private class Cashier(val n: Int, val discount: Int, val products: IntArray, val prices: IntArray) {
    var count = 0
    val priceMap = mutableMapOf<Int, Int>()

    init {
        for (i in products.indices) {
            priceMap[products[i]] = prices[i]
        }
    }

    fun getBill(product: IntArray, amount: IntArray): Double {
        count++
        var bill = 0.0
        for (i in product.indices) {
            bill += (amount[i] * priceMap[product[i]]!!)
        }
        if (count % n == 0) {
            bill = (bill * (100 - discount)) / 100
        }
        return bill
    }
}


private fun main() {

}
