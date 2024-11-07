package geeks_for_geeks.coin_change_dp_7

fun countWays(coins: IntArray, amount: Int): Int {
    // table[i] will be storing the number of solutions for
    // value i. We need n+1 rows as the table is constructed
    // in bottom up manner using the base case (n = 0)
    val table = IntArray(amount + 1)

    // Base case (If given value is 0)
    table[0] = 1

    // Pick all coins one by one and update the table[] values
    // after the index greater than or equal to the value of the
    // picked coin
    coins.forEach { coin ->
        for (j in coin..amount) {
            table[j] += table[j - coin]
        }
    }
    return table[amount]
}

fun main() {
    val coins = intArrayOf(1, 2, 3)
    val amount = 4
    println(countWays(coins, amount))
}

/*
        coins   1   2   3
amount
0               1
1               1
2               1   2
3               1   2   3
4               1   3   4

 */
