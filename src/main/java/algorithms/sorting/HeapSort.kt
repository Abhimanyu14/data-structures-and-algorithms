package algorithms.sorting

/**
 * Time - O(N * log(N))
 * Space - O(log(N))
 */
private fun heapSort(input: IntArray) {
    fun swap(index1: Int, index2: Int) {
        input[index1] = input[index2].also {
            input[index2] = input[index1]
        }
    }

    // Function to heapify a subtree (in top-down order) rooted at index i.
    fun heapify(n: Int, i: Int) {
        // Initialize largest as root 'i'.
        var largest = i
        val left = 2 * i + 1
        val right = 2 * i + 2

        // If left child is larger than root.
        if (left < n && input[left] > input[largest]) {
            largest = left
        }

        // If right child is larger than largest so far.
        if (right < n && input[right] > input[largest]) {
            largest = right
        }

        // If largest is not root swap root with the largest element
        // Recursively heapify the affected subtree (i.e. move down).
        if (largest != i) {
            swap(i, largest)
            heapify(n, largest)
        }
    }

    // Build heap; heapify (top-down) all elements except leaf nodes.
    for (i in ((input.size / 2) - 1) downTo 0) {
        heapify(input.size, i)
    }

    // Traverse elements one by one, to move current root to end, and
    for (i in input.lastIndex downTo 0) {
        swap(0, i)
        // call max heapify on the reduced heap.
        heapify(i, 0)
    }
}

private fun main() {
    val input = intArrayOf(10, 80, 30, 90, 40, 50, 70)
    heapSort(input)
}
