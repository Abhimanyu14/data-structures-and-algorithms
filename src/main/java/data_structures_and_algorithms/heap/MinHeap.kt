package data_structures_and_algorithms.heap

/**
 * Parent : (index - 1) / 2
 * Left : (index * 2) + 1
 * Right : (index * 2) + 2
 */

fun main() {
    var capacity = 10
    var size = 0
    var items = IntArray(capacity)

    fun getParentIndex(index: Int) = (index - 1) / 2
    fun getLeftChildIndex(index: Int) = (index * 2) + 1
    fun getRightChildIndex(index: Int) = (index * 2) + 2

    fun hasParent(index: Int) = getParentIndex(index) >= 0
    fun hasLeftChild(index: Int) = getLeftChildIndex(index) < size
    fun hasRightChild(index: Int) = getRightChildIndex(index) < size

    fun parent(index: Int) = items[getParentIndex(index)]
    fun leftChild(index: Int) = items[getLeftChildIndex(index)]
    fun rightChild(index: Int) = items[getRightChildIndex(index)]

    fun swap(index1: Int, index2: Int) {
        items[index1] = items[index2].also {
            items[index2] = items[index1]
        }
    }

    fun ensureExtraCapacity() {
        if (size == capacity) {
            capacity *= 2
            items = items.copyOf(capacity)
        }
    }

    fun heapifyUp() {
        var index = size - 1
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index)
            index = getParentIndex(index)
        }
    }

    fun heapifyDown() {
        var index = 0
        while (hasLeftChild(index)) {
            var smallerChildIndex = getLeftChildIndex(index)
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index)
            }
            if (items[index] < items[smallerChildIndex]) {
                break
            } else {
                swap(index, smallerChildIndex)
            }
            index = smallerChildIndex
        }
    }

    fun peek(): Int {
        if (size == 0) {
            throw IllegalStateException()
        }
        return items[0]
    }

    fun poll(): Int {
        if (size == 0) {
            throw IllegalStateException()
        }
        val result = items[0]
        items[0] = items[size - 1]
        size--
        heapifyDown()
        return result
    }

    fun add(item: Int) {
        ensureExtraCapacity()
        items[size] = item
        size++
        heapifyUp()
    }
}
