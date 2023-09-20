package data_structures_and_algorithms.queue

import java.util.PriorityQueue

/**
 * Use [PriorityQueue] for PriorityQueue
 * add => offer()
 * remove => poll
 * peek => [peak()]
 *
 * Other operations
 * isEmpty(), size, clear()
 */
fun main() {
    val priorityQueue = PriorityQueue<Int>()
    println()
    println("Created queue")
    println("Queue: $priorityQueue")
    println()

    priorityQueue.offer(35)
    println("Added 35")
    println("Queue: $priorityQueue")
    println()

    var removed = priorityQueue.poll()
    println("Removed $removed from queue")
    println("Queue: $priorityQueue")
    println()

    removed = priorityQueue.poll()
    println("Removed $removed from queue")
    println("Queue: $priorityQueue")
    println()

    var peek = priorityQueue.peek()
    println("Peaking $peek in queue")
    println("Queue: $priorityQueue")
    println()

    priorityQueue.offer(73)
    println("Added 73")
    println("Queue: $priorityQueue")
    println()

    priorityQueue.offer(52)
    println("Added 52")
    println("Queue: $priorityQueue")
    println()

    removed = priorityQueue.poll()
    println("Removed $removed from queue")
    println("Queue: $priorityQueue")
    println()

    println("Queue first: ${priorityQueue.first()}")
    println("Queue: $priorityQueue")
    println()

    println("Is queue empty: ${priorityQueue.isEmpty()}")
    println(priorityQueue)
    println()

    println("Queue size: ${priorityQueue.size}")
    println(priorityQueue)
    println()

    priorityQueue.clear()
    println("Queue cleared")
    println(priorityQueue)
    println()
}
