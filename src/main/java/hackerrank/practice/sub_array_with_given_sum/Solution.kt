package hackerrank.practice.sub_array_with_given_sum

fun bruteForceSolution(arr: Array<Int>, sum: Int): Pair<Int, Int> {
    val map: MutableMap<Pair<Int, Int>, Int> = HashMap()
    val resultMap: MutableMap<Int, Pair<Int, Int>> = HashMap()
    for (i in arr.indices) {
        for (j in i..<arr.size) {
            if (i == j) {
                map[Pair(i, j)] = arr[j]
            } else {
                map[Pair(i, j)] = map[Pair(i, j - 1)]?.plus(arr[j])!!
            }
            resultMap[map[Pair(i, j)]!!] = Pair(i, j)
        }
    }
    return resultMap[sum] ?: Pair(-1, -1)
}

fun solution(arr: Array<Int>, sum: Int): Pair<Int, Int> {
    var currentSum = arr[0]
    var start = 0
    var end = 0
    while (end < arr.size) {
        when {
            currentSum == sum -> {
                return Pair(start, end)
            }

            currentSum < sum -> {
                end++
                currentSum += arr[end]
            }

            start == end -> {
                start++
                end++
                currentSum = arr[start]
            }

            else -> {
                currentSum -= arr[start]
                start++
            }
        }
    }
    return Pair(-1, -1)
}

fun subArrayWithGivenSum(arr: Array<Int>, sum: Int): Pair<Int, Int> {
    return solution(arr, sum)
}

private fun main() {
    val result = subArrayWithGivenSum(arrayOf(1, 4, 20, 3, 10, 5), 33)
    println(result)
}
