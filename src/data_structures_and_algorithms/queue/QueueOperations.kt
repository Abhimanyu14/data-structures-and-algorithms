package data_structures_and_algorithms.queue

/**
 * Use [ArrayDeque] for Queue
 * add => [addLast()]
 * poll => [removeLast()]
 * peek => [last()]
 *
 * Other operations
 * isEmpty(), size, clear()
 */
fun main() {
    val queue = ArrayDeque<Int>()
    println()
    println("Created queue")
    println("Queue: $queue")
    println()

    queue.addLast(35)
    println("Added 35")
    println("Queue: $queue")
    println()

    queue.addLast(73)
    println("Added 73")
    println("Queue: $queue")
    println()

    queue.addLast(52)
    println("Added 52")
    println("Queue: $queue")
    println()

    val removed = queue.removeFirst()
    println("Removed $removed from queue")
    println("Queue: $queue")
    println()

    println("Queue first: ${queue.first()}")
    println("Queue: $queue")
    println()

    println("Is queue empty: ${queue.isEmpty()}")
    println(queue)
    println()

    println("Queue size: ${queue.size}")
    println(queue)
    println()

    queue.clear()
    println("Queue cleared")
    println(queue)
    println()
}
