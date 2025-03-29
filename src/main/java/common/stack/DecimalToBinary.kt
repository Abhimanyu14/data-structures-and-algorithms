package common.stack

import java.util.Stack

fun decimalToBinary(decimal: Int): String {
    var n = decimal
    val stack = Stack<Int>()
    while (n > 0) {
        stack.push(n % 2)
        n /= 2
    }
    var result = ""
    while (!stack.isEmpty()) {
        result += stack.pop()
    }
    return result
}

private fun main() {
    val result = decimalToBinary(25)
    print(result)
}
