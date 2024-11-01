package leetcode.leetcode_379_design_phone_directory

/**
 * Using array
 *
 * Stats
 * Runtime: 445 ms, faster than 100.00%
 * Memory Usage: 59.7 MB, less than 87.50%
 */
class PhoneDirectory(maxNumbers: Int) {
    private val directory = IntArray(maxNumbers)

    fun get(): Int {
        var i = 0
        while (i < directory.size) {
            if (directory[i] == 0) {
                directory[i] = 1
                return i
            }
            i++
        }
        return -1
    }

    fun check(number: Int): Boolean {
        return directory[number] == 0
    }

    fun release(number: Int) {
        directory[number] = 0
    }

}

private fun main() {

}
