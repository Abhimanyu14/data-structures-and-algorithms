package course.argorithmic_toolbox.week1

private fun sum(
    a: Int,
    b: Int,
): Int {
    return a + b
}

private fun main() {
    val (a, b) = readLine()!!.split(' ').map { it.toInt() }
    val result = sum(a, b)
    println(result)
}
