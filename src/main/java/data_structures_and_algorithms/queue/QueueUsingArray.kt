package data_structures_and_algorithms.queue

class QueueUsingArray(
    private val maxSize: Int,
) {
    private val queue = IntArray(maxSize)
    var start = -1
    var size = 0

    fun offer(x: Int): Boolean {
        return when (size) {
            maxSize -> {
                false
            }

            0 -> {
                start = 0
                queue[0] = x
                size++
                true
            }

            else -> {
                queue[(start + size) % maxSize] = x
                size++
                true
            }
        }
    }

    fun poll(): Int? {
        return when (size) {
            0 -> {
                null
            }

            1 -> {
                val toRemove = queue[start]
                start = -1
                size = 0
                toRemove
            }

            else -> {
                val toRemove = queue[start]
                start = (start + 1) % maxSize
                size--
                return toRemove
            }
        }
    }

    fun peek(): Int {
        return queue[start]
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun clear() {
        start = -1
        size = 0
    }

    override fun toString(): String {
        val result = StringBuilder()
        result.append('[')
        if (start != -1) {
            result.append(queue[start])
        }
        if (start + size < maxSize) {
            for (i in start + 1..<start + size) {
                result.append(", ${queue[i]}")
            }
        } else {
            for (i in start + 1..<maxSize) {
                result.append(", ${queue[i]}")
            }
            for (i in 0..<((start + size) % maxSize)) {
                result.append(", ${queue[i]}")
            }
        }
        result.append(']')
        return result.toString()
    }
}
