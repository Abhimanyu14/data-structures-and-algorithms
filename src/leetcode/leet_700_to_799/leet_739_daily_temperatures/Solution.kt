package leetcode.leet_700_to_799.leet_739_daily_temperatures

/**
 * leetcode - https://leetcode.com/problems/daily-temperatures/
 *
 * Using brute force
 *
 * Stats
 * Time Limit Exceeded
 */
private fun dailyTemperaturesBruteForce(temperatures: IntArray): IntArray {
    for (i in temperatures.indices) {
        var count = 1
        for (j in i + 1..temperatures.lastIndex) {
            if (temperatures[j] > temperatures[i]) {
                temperatures[i] = count
                break
            } else {
                count++
                if (i + count == temperatures.size) {
                    temperatures[i] = 0
                }
            }
        }
    }
    temperatures[temperatures.lastIndex] = 0
    return temperatures
}

/**
 * leetcode - https://leetcode.com/problems/daily-temperatures/
 *
 * Using Monotonic Stack
 *
 * Stats
 * Time Limit Exceeded
 */
private fun dailyTemperaturesUsingMonotonicStack(temperatures: IntArray): IntArray {
    val stack = ArrayDeque<Int>()
    val answer = IntArray(temperatures.size)
    temperatures.forEachIndexed { index, temp ->
        while (stack.isNotEmpty() && temp > temperatures[stack.last()]) {
            answer[stack.last()] = index - stack.last()
            stack.removeLast()
        }
        stack.addLast(index)
    }
    return answer
}

/**
 * leetcode - https://leetcode.com/problems/daily-temperatures/
 *
 * Using Array
 *
 * Stats
 * Runtime: 702 ms, faster than 98.96%
 * Memory Usage: 51.1 MB, less than 94.79%
 */
private fun dailyTemperatures(temperatures: IntArray): IntArray {
    val answer = IntArray(temperatures.size)
    var hottest = 0
    for (currDay in temperatures.lastIndex - 1 downTo 0) {
        val currentTemp = temperatures[currDay]
        if (currentTemp >= hottest) {
            hottest = currentTemp
            continue
        }
        var days = 1
        while (temperatures[currDay + days] <= currentTemp) {
            days += answer[currDay + days]
        }
        answer[currDay] = days
    }
    return answer
}

private fun main() {

}
