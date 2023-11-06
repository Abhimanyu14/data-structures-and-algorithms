package leetcode

private fun main() {
    println(formatLeetcodeTitle("207. Course Schedule"))
    println(formatLeetcodeTitle("210. Course Schedule II"))
}

private fun formatLeetcodeTitle(@Suppress("SameParameterValue") title: String): String {
    val result = title
        .replace("-", "_")
        .replace("(", "")
        .replace(")", "")
        .replace(".", "")
        .replace("'", "_")
        .replace(" ", "_")
        .lowercase()
    return "leet_$result"
}
