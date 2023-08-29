package leetcode.leet_2400_to_2499.leet_2469_convert_the_temperature

/**
 * leetcode - https://leetcode.com/problems/convert-the-temperature/
 *
 * Using temperature formulae
 *
 * Stats
 * Runtime: 183 ms, faster than 5.05%
 * Memory Usage: 34.3 MB, less than 46.46%
 */
fun convertTemperature(celsius: Double): DoubleArray {
    return doubleArrayOf(celsius + 273.15, celsius * 1.80 + 32.00)
}

private fun main() {

}
