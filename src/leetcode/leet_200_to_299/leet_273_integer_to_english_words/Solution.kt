package leetcode.leet_200_to_299.leet_273_integer_to_english_words

/**
 * leetcode - https://leetcode.com/problems/integer-to-english-words/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 */
private data class NumberWord(
    val value: Int,
    val word: String,
)

// List to store words for numbers
private val numberToWordsList: List<NumberWord> = listOf(
    NumberWord(1000000000, "Billion"),
    NumberWord(1000000, "Million"),
    NumberWord(1000, "Thousand"),
    NumberWord(100, "Hundred"),
    NumberWord(90, "Ninety"),
    NumberWord(80, "Eighty"),
    NumberWord(70, "Seventy"),
    NumberWord(60, "Sixty"),
    NumberWord(50, "Fifty"),
    NumberWord(40, "Forty"),
    NumberWord(30, "Thirty"),
    NumberWord(20, "Twenty"),
    NumberWord(19, "Nineteen"),
    NumberWord(18, "Eighteen"),
    NumberWord(17, "Seventeen"),
    NumberWord(16, "Sixteen"),
    NumberWord(15, "Fifteen"),
    NumberWord(14, "Fourteen"),
    NumberWord(13, "Thirteen"),
    NumberWord(12, "Twelve"),
    NumberWord(11, "Eleven"),
    NumberWord(10, "Ten"),
    NumberWord(9, "Nine"),
    NumberWord(8, "Eight"),
    NumberWord(7, "Seven"),
    NumberWord(6, "Six"),
    NumberWord(5, "Five"),
    NumberWord(4, "Four"),
    NumberWord(3, "Three"),
    NumberWord(2, "Two"),
    NumberWord(1, "One")
)

private fun numberToWords(num: Int): String {
    if (num == 0) {
        return "Zero"
    }

    for (nw in numberToWordsList) {
        // Check if the number is greater than or equal to the current unit
        if (num >= nw.value) {
            // Convert the quotient to words if the current unit is 100 or greater
            val prefix = if ((num >= 100)) {
                numberToWords(num / nw.value) + " "
            } else {
                ""
            }

            // Get the word for the current unit
            val unit = nw.word

            // Convert the remainder to words if it's not zero
            val suffix = if ((num % nw.value == 0)) {
                ""
            } else {
                " " + numberToWords(num % nw.value)
            }

            return prefix + unit + suffix
        }
    }

    return ""
}

private fun main() {

}
