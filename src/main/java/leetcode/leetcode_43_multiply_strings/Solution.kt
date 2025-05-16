package leetcode.leetcode_43_multiply_strings

/**
 * leetcode - https://leetcode.com/problems/multiply-strings/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - String Parsing
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun multiply(num1: String, num2: String): String {
    if (num1 == "0" || num2 == "0") {
        return "0"
    }

    val product = IntArray(num1.length + num2.length)

    for (i in num1.lastIndex downTo 0) {
        for (j in num2.lastIndex downTo 0) {
            val sum = num1[i].digitToInt() * num2[j].digitToInt() + product[i + j + 1]
            product[i + j + 1] = sum % 10
            product[i + j] += sum / 10
        }
    }

    // Convert result array to string, skipping leading zeros
    val result = StringBuilder()
    var index = 0
    while (index < product.size && product[index] == 0) {
        index++
    }
    while (index < product.size) {
        result.append(product[index])
        index++
    }
    return result.toString()
}

private fun multiply1(num1: String, num2: String): String {
    if (num1 == "0" || num2 == "0") {
        return "0"
    }
    var result = ""
    val current = StringBuilder()
    var carry: Int
    var temp: Int

    fun multiplyString(x: Int): String {
        current.clear()
        carry = 0
        for (i in num1.lastIndex downTo 0) {
            temp = (x * num1[i].digitToInt()) + carry
            carry = temp / 10
            current.insert(0, temp % 10)
        }
        if (carry > 0) {
            current.insert(0, carry)
        }
        // println("Product $x * $num1: ${productString.toString()}")
        return current.toString()
    }

    fun add(str1: String, offset: Int) {
        val returnValue = StringBuilder()
        for (i in 0..<offset) {
            returnValue.insert(0, result[result.lastIndex - i])
        }
        var index = result.lastIndex - offset
        carry = 0
        var sum = 0
        for (i in str1.lastIndex downTo 0) {
            sum = str1[i].digitToInt() + carry
            if (index >= 0) {
                sum += result[index].digitToInt()
            }
            returnValue.insert(0, sum % 10)
            carry = sum / 10
            index--
        }
        while (index >= 0) {
            sum += result[index].digitToInt() + carry
            carry = sum / 10
            returnValue.insert(0, sum % 10)
            index--
        }
        if (carry > 0) {
            returnValue.insert(0, carry)
        }
        result = returnValue.toString()
        // println("Result: $result")
    }

    for (i in num2.lastIndex downTo 0) {
        add(multiplyString(num2[i].digitToInt()), num2.lastIndex - i)
    }
    return result
}

private fun main() {

}
