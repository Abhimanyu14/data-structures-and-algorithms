package data_structures_and_algorithms.stack

/**
 * Use [ArrayDeque] for Stack
 * push => [addLast()]
 * pop => [removeLast()]
 * peek => [last()]
 *
 * Other operations
 * isEmpty(), size, clear()
 */
fun main() {
    val stack = ArrayDeque<Int>()
    println()
    println("Created stack")
    println("Stack: $stack")
    println()

    stack.addLast(35)
    println("Pushed 35")
    println("Stack: $stack")
    println()

    stack.addLast(73)
    println("Pushed 73")
    println("Stack: $stack")
    println()

    stack.addLast(52)
    println("Pushed 52")
    println("Stack: $stack")
    println()

    val popped = stack.removeLast()
    println("Popped $popped from stack")
    println("Stack: $stack")
    println()

    println("Stack top: ${stack.last()}")
    println("Stack: $stack")
    println()

    println("Is stack empty: ${stack.isEmpty()}")
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
