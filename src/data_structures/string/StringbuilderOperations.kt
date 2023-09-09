package data_structures.string

fun main() {
    val stringBuilder = StringBuilder()

    stringBuilder.append('a')
    stringBuilder.append("bc")
    stringBuilder.append(12)
    stringBuilder.insert(1, 'x')
    stringBuilder.append(12.0)
    stringBuilder.append(12L)
    stringBuilder.append(true)
    println(stringBuilder.toString())
    stringBuilder.append(false)
    println(stringBuilder.toString())
    stringBuilder.append("abc")
    stringBuilder.removeRange(stringBuilder.lastIndex - 3, stringBuilder.length)
    println(stringBuilder.toString())
    stringBuilder.clear()
    println(stringBuilder.toString())
    println(stringBuilder.length)
}
