package leetcode

private fun main() {
    println(formatLeetcodeTitle("2433. Find The Original Array of Prefix Xor"))
    println(formatLeetcodeTitle("1081. Smallest Subsequence of Distinct Characters"))
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
