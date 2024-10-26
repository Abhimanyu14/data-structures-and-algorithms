package leetcode.leet_300_to_399.leet_386_lexicographical_numbers


/**
 * leetcode - https://leetcode.com/problems/lexicographical-numbers/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */

private fun lexicalOrder(n: Int): List<Int> {
    val lexicographicalNumbers: MutableList<Int> = ArrayList()
    var currentNumber = 1

    // Generate numbers from 1 to n
    for (i in 0..<n) {
        lexicographicalNumbers.add(currentNumber)

        // If multiplying the current number by 10 is within the limit, do it
        if (currentNumber * 10 <= n) {
            currentNumber *= 10
        } else {
            // Adjust the current number by moving up one digit
            while (currentNumber % 10 == 9 || currentNumber >= n) {
                currentNumber /= 10 // Remove the last digit
            }
            currentNumber += 1 // Increment the number
        }
    }

    return lexicographicalNumbers
}

private fun main() {

}
