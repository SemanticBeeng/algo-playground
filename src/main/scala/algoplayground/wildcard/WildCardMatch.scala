package algoplayground.wildcard

/**
 * http://www.glassdoor.com/Interview/1-You-have-two-strings-A-test-string-and-a-glob-Test-string-can-have-a-and-b-any-number-of-times-any-location-Glob-QTN_327438.htm
 *
 * You have two strings. A test string and a glob Test
 * string can have a & b, any number of times, any location.
 * Glob can have a, b, ? and *, any number of times, any location.
 * E.g. test= {a,b,a,a,a,a,b,b,b,b,b,b} glob = {a,?, *, b}
 * Now, ? means ANY character, single occurrence.
 * So it's either a or b, one time * means ANY OR NO character,
 * any number of occurrences.
 * E.g. the above glob and test actually match.
 *
 * Problem is:
 * Write an algorithm to match glob with test.
 * You MAY NOT use regular expressions
 */
object WildCardMatch {
  def matchPattern(pattern: String, string: String): Boolean = {

    // Nothing to match
    if (string.isEmpty && pattern.isEmpty)
      return true

    // Match empty string with *
    if (string.isEmpty && pattern.head == '*' && pattern.length == 1)
      return true

    // If string is empty and pattern is not
    if (string.isEmpty && !pattern.isEmpty)
      return false

    // Pattern is over and string is not
    if (!string.isEmpty && pattern.isEmpty)
      return false

    // Math any symbol and continue with leftover
    if (pattern.head == '?')
      return matchPattern(pattern.tail, string.tail)

    // Match non *
    if (pattern.head != '*')
      return (string.head == pattern.head) && matchPattern(pattern.tail, string.tail)

    // We can take and continue or stop
    if (pattern.head == '*')
      return matchPattern(pattern, string.tail) || matchPattern(pattern.tail, string)

    sys.error(s"Should not be here. Pattern: $pattern. String: $string")
  }
}
