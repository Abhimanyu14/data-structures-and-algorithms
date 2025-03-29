package geeks_for_geeks.count_pair_with_given_sum

/**
 * link - https://www.geeksforgeeks.org/count-pairs-with-given-sum/
 */
private fun givenSumPairCountNaive(
    arr: IntArray,
    sum: Int,
): Int {
    var result = 0
    arr.forEachIndexed { index, value ->
        for (i in index + 1..arr.lastIndex) {
            if (arr[i] + value == sum) {
                result++
            }
        }
    }
    return result
}

private fun givenSumPairCountHashMap(
    arr: IntArray,
    sum: Int,
): Int {
    var result = 0
    val counterMap = hashMapOf<Int, Int>()
    arr.forEach {
        result += counterMap[sum - it] ?: 0
        counterMap[sum - it] = (counterMap[it] ?: 0) + 1
    }
    return result
}

private fun main() {
    val solutionMethod = ::givenSumPairCountHashMap

//    println(solutionMethod(intArrayOf(1, 5, 7, -1), 6))
//    println(solutionMethod(intArrayOf(1, 5, 7, -1, 5), 6))
    println(solutionMethod(intArrayOf(1, 1, 1, 1), 2))
//    println(
//        solutionMethod(
//            intArrayOf(10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1),
//            11,
//        ),
//    )

    CompClass.sample()
}

class CompClass {

    companion object {
        fun sample() {

        }
    }
}

