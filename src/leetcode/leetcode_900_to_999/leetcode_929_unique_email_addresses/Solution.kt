package leetcode.leetcode_900_to_999.leetcode_929_unique_email_addresses

/**
 * Using set
 *
 * leetcode - https://leetcode.com/problems/unique-email-addresses/
 *
 * Stats
 * Runtime: 610 ms, faster than 48.61%
 * Memory Usage: 59.8 MB, less than 54.17%
 */
private fun numUniqueEmails(emails: Array<String>): Int {
    fun cleanMailId(mail: String): String {
        val split = mail.split('@')
        val localName = split.first().split('+').first().replace(".", "")
        val domainName = split[1]
        return "$localName@$domainName"
    }
    val set = mutableSetOf<String>()
    emails.forEach {
        set.add(cleanMailId(it))
    }
    return set.size
}

private fun main() {

}
