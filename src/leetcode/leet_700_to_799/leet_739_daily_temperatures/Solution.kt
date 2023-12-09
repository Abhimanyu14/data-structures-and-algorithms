package leetcode.leet_700_to_799.leet_739_daily_temperatures

/**
 * leetcode - https://leetcode.com/problems/daily-temperatures/
 *
 * TODO(Abhi) - To revisit
 *
 * Using Array
 *
 * Stats
 * Runtime: 563 ms, faster than 95.77%
 * Memory Usage: 52.1 MB, less than 85.02%
 */
private fun dailyTemperatures(temperatures: IntArray): IntArray {
    val answer = IntArray(temperatures.size)
    var hottestTemperature = 0
    for (currDay in temperatures.indices.reversed()) {
        // There is no hotter day on the right side and so the value will remain 0
        if (temperatures[currDay] >= hottestTemperature) {
            hottestTemperature = temperatures[currDay]
        } else {
            var nextCount = 1
            while (temperatures[currDay + nextCount] <= temperatures[currDay]) {
                nextCount += answer[currDay + nextCount]
            }
            answer[currDay] = nextCount
        }
    }
    return answer
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

private fun main() {

}
