package leetcode.leet_900_to_999.leet_929_unique_email_addresses

/**
 * Using hashset
 *
 * Stats
 * Runtime: 610 ms, faster than 48.61%
 * Memory Usage: 59.8 MB, less than 54.17%
 */
private fun numUniqueEmails(emails: Array<String>): Int {
    val hashset = mutableSetOf<String>()
    emails.forEach {
        hashset.add(cleanMailId(it))
    }
    return hashset.size
}

private fun cleanMailId(mail: String): String {
    val split = mail.split('@')
    val localName = split.first().split('+').first().replace(".", "")
    val domainName = split[1]
    return "$localName@$domainName"
}

private fun main() {

}
