package leetcode.leet_1300_to_1399.leet_1395_count_number_of_teams

import common.maths.combination

// TODO: To complete
fun numTeams(rating: IntArray): Int {
    var result = 0
    var tempArray1: MutableList<Int>
    var tempArray2: MutableList<Int>
    for (i in rating.indices) {
        tempArray1 = mutableListOf()
        tempArray2 = mutableListOf()
        tempArray1.add(rating[i])
        tempArray2.add(rating[i])
        for (j in i + 1 until rating.size) {
            if (rating[j] < tempArray1.last()) {
                tempArray1.add(rating[j])
            }
            if (rating[j] > tempArray2.last()) {
                tempArray2.add(rating[j])
            }
        }
        if (tempArray1.size >= 3) {
            result += combination(tempArray1.size, 3)
        }
        if (tempArray2.size >= 3) {
            result += combination(tempArray2.size, 3)
        }
    }
    return result
}

fun main() {
    val input1 = intArrayOf(2, 5, 3, 4, 1)
    val input2 = intArrayOf(2, 1, 3)
    val input3 = intArrayOf(1, 2, 3, 4)
    println(numTeams(input1))
    println(numTeams(input2))
    println(numTeams(input3))
}
