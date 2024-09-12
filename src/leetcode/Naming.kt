package leetcode

private fun main() {
    println(formatLeetcodeTitle("1684. Count the Number of Consistent Strings"))

    // println(formatHackerrankTitle("Is This a Binary Search Tree?"))
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
        .filter { it.isLetter() || it.isDigit() || it == '_' }
    return "leet_$result"
}

private fun formatHackerrankTitle(@Suppress("SameParameterValue") title: String): String {
    return title
        .replace("-", "_")
        .replace("(", "")
        .replace(")", "")
        .replace(".", "")
        .replace("'", "_")
        .replace(" ", "_")
        .lowercase()
        .filter { it.isLetter() || it == '_' }
}
