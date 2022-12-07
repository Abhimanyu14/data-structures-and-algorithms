package data_structures.stack

import java.util.Stack

fun main() {
    val stack = Stack<Int>()
    println("Created stack")
    println("Stack: $stack")
    println()

    stack.push(35)
    println("Pushed 35")
    println("Stack: $stack")
    println()

    stack.push(73)
    println("Pushed 73")
    println("Stack: $stack")
    println()

    stack.push(52)
    println("Pushed 52")
    println("Stack: $stack")
    println()

    stack.pop()
    println("Popped from stack")
    println("Stack: $stack")
    println()

    println("Stack top: ${stack.peek()}")
    println("Stack: $stack")
    println()

    println("Is stack empty: ${stack.empty()}")
    println(stack)
    println()

    println("Stack size: ${stack.size}")
    println(stack)
    println()

    stack.clear()
    println("Stack cleared")
    println(stack)
    println()
}
