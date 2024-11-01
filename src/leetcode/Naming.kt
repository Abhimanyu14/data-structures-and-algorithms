package leetcode

import java.io.File
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

private fun main() {
    // println(formatLeetcodeTitle("1020. Number of Enclaves"))

    // println(formatHackerrankTitle("Is This a Binary Search Tree?"))

    createDir()
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

@Serializable
private data class Question(
    val frontendQuestionId: String,
    val title: String,
    val titleSlug: String,
)

private fun createDir() {
    val rootDir = File("./src/leetcode")
    val jsonString = File("$rootDir/leetcode_questions.json").readText()
    val questions = Json.decodeFromString<List<Question>>(jsonString)
    fun getDirectoryName(question: Question): String {
        return "leetcode_${question.frontendQuestionId}_${question.titleSlug.replace("-", "_")}"
    }

    val allDirectoryNames: List<String> = questions.map { question ->
        getDirectoryName(question)
    }
    val existingDirectoryNames = rootDir.walkTopDown()
        .filter {
            it.isDirectory
        }
        .map {
            it.name
        }.toList()
    val existingDirectoryNamesSet = existingDirectoryNames.toSet()

    allDirectoryNames.filter {
        !existingDirectoryNamesSet.contains(it)
    }.forEach {
        val directory = File("$rootDir/$it")
        if (directory.mkdir()) {
            val file = File("$rootDir/$it/Solution.kt")
            file.createNewFile()
            file.writeText(solutionFileContent().replace("package leetcode","package leetcode.$it"))
        }
    }
}

private fun solutionFileContent(): String {
    return """
        package leetcode

        /**
         * leetcode -
         *
         * TODO(Abhi) - To revisit
         *
         * Using
         *
         * Difficulty -
         *
         * Stats
         *
         * Time -
         * Space -
         */
        private fun main() {

        }

    """.trimIndent()
}