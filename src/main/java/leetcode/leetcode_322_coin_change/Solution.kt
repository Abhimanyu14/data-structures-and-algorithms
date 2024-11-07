package leetcode.leetcode_322_coin_change

// TODO
fun coinChange(coins: IntArray, amount: Int, result: Int): Int {
    if (amount == 0) {
        return result
    }
    if (amount < 0) {
        return Int.MAX_VALUE
    }

    return 0
}

fun coinChangeDriver(coins: IntArray, amount: Int): Int {
    return coinChange(coins, amount, 0)
}

private fun main() {

}
