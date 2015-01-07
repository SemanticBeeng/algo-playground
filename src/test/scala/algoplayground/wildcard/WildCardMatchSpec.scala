package algoplayground.wildcard

import org.scalatest.FlatSpec

class WildCardMatchSpec extends FlatSpec {

  "WildCard Match" should "properly match strings" in {
    assert(WildCardMatch.matchPattern("a?*b", "abaaaaaaabbbbb"))  // Yes
    assert(WildCardMatch.matchPattern("g*ks", "geeks"))           // Yes
    assert(WildCardMatch.matchPattern("ge?ks*", "geeksforgeeks")) // Yes
    assert(!WildCardMatch.matchPattern("g*k", "gee"))             // No because 'k' is not in second
    assert(!WildCardMatch.matchPattern("*pqrs", "pqrst"))         // No because 't' is not in first
    assert(WildCardMatch.matchPattern("abc*bcd", "abcdhghgbcd"))  // Yes
    assert(!WildCardMatch.matchPattern("abc*c?d", "abcd"))        // No because second must have 2 instances of 'c'
    assert(WildCardMatch.matchPattern("*c*d", "abcd"))            // Yes
    assert(WildCardMatch.matchPattern("*?c*d", "abcd"))           // Yes
  }

}
