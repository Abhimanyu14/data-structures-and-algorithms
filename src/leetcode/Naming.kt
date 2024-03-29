package leetcode

private fun main() {
    println(formatLeetcodeTitle("1693. Daily Leads and Partners"))
    println(formatLeetcodeTitle("1741. Find Total Time Spent by Each Employee"))
    println(formatLeetcodeTitle("2824. Count Pairs Whose Sum is Less than Target"))
    println(formatLeetcodeTitle("1678. Goal Parser Interpretation"))
    println(formatLeetcodeTitle("2356. Number of Unique Subjects Taught by Each Teacher"))

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
