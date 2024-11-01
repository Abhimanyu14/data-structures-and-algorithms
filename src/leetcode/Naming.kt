package leetcode

import java.io.File

private fun main() {
    // println(formatLeetcodeTitle("1020. Number of Enclaves"))

    // println(formatHackerrankTitle("Is This a Binary Search Tree?"))
    rename()
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
    return "leetcode_$result"
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

private fun rename() {
    // Define the root directory of the project
    val rootDir = File("./src/leetcode")

    rootDir.walkTopDown()
        .filter {
            it.isDirectory && it.name.startsWith("leet_")
            // it.isFile && it.extension == "kt"
        } // Filter for Kotlin files only
        .forEach { dir ->
            val newDirName = dir.name.replaceFirst("leet_", "leetcode_")
            val newDir = File(dir.parentFile, newDirName)
            if (dir.renameTo(newDir)) {
                println("Renamed directory: ${dir.path} -> ${newDir.path}")
            } else {
                println("Failed to rename directory: ${dir.path}")
            }
        }

    // Step 2: Update all Kotlin files to reflect new package names
    rootDir.walkTopDown()
        .filter {
            it.isFile && it.extension == "kt"
        } // Filter for Kotlin files
        .forEach { file ->
            val content = file.readText()
            val updatedContent = content.replace("leetcode_", "leetcode_")
            if (content != updatedContent) {
                file.writeText(updatedContent)
                println("Updated package in file: ${file.path}")
            }
        }
}
