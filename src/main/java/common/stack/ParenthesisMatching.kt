package common.stack

import java.util.Stack

fun parenthesisMatching(input: String) {
    val stack = Stack<Char>()
    input.forEach {
        if (it == '(') {
            stack.push(it)
        } else if (it == ')') {
            if (stack.empty()) {
                println("Closing parenthesis is not matched")
                return
            }
            stack.pop()
        }
    }
    if (!stack.isEmpty()) {
        println("Opening parenthesis is not matched")
    } else {
        println("Parentheses matched")
    }
}

fun main() {
    parenthesisMatching("(A+B()))")
}
