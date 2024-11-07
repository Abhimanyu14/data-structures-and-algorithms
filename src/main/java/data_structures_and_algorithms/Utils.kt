package data_structures_and_algorithms

fun print2DArray(arr: Array<Array<Int>>) {
    print("X   ")
    arr[0].forEachIndexed { index, _ ->
        print("${index.toString().padEnd(3)} ")
    }
    println()

    arr.forEachIndexed { index, arrItem ->
        print("${index.toString().padEnd(3)} ")
        arrItem.forEach {
            print("${it.toString().padEnd(3)} ")
        }
        println()
    }
}
