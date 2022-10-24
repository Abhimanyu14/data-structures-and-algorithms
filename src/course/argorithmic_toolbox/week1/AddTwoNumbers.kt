package course.argorithmic_toolbox.week1

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun main() {
    val (a, b) = readLine()!!.split(' ').map { it.toInt() }
    val result = sum(a, b)
    println(result)
}
