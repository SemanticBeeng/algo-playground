package algoplayground.kmpmatch;

import java.util.Arrays;

public class KMPStringMatch {

    public static void stringMatch(char[] pattern, char[] text) {
        System.out.println(
                "Find pattern: " + String.copyValueOf(pattern) +
                "; In text: " + String.copyValueOf(text));

        Integer[] lcps = longestCommonPrefixAndSuffix(pattern);
        System.out.println("Longest common prefix and suffix:");
        System.out.println(Arrays.deepToString(lcps));

        // Start position in text
        int start = 0;

        // Index inside pattern
        int idx = 0;

        while (start + idx < text.length) {

            System.out.println("Start = "+start+"; Idx = "+idx);

            // Continue matching
            if (text[start + idx] == pattern[idx]) {
                idx++;
            } else {
                if (idx != 0) {
                    Integer longestCommonPrefix = lcps[idx-1];
                    start = start + idx - longestCommonPrefix;
                    idx = longestCommonPrefix;
                } else { // Matched something
                    idx = 0;
                    start = start + 1;
                }
            }

            // Matched full pattern
            if (idx == pattern.length) {
                System.out.println("Found pattern at start index: " + start);
                System.out.println("Matched @ Start = "+start+"; Idx = "+idx);

                // Get longest common prefix for last matched symbol
                Integer longestCommonPrefix = lcps[idx-1];
                // Start from that value
                start = start + idx - longestCommonPrefix;
                idx = longestCommonPrefix;
            }
        }
    }

    public static Integer[] longestCommonPrefixAndSuffix(char[] text) {
        Integer[] lcp = new Integer[text.length];
        Arrays.fill(lcp, 0);
        lcp[0] = 0;
        lcp[1] = 0;

        Integer len = 0;
        Integer i = 1;

        while (i < text.length) {

            /*System.out.println("Len = " + len +
                    "; I = " + i +
                    "; Text[len] = " + text[len] +
                    "; Text[i] = " + text[i] +
                    "; LCP = " + Arrays.deepToString(lcp));*/

            if (text[i] == text[len]) {
                len++;
                lcp[i] = len;
                i++;
            } else if (len > 0) {
                /*System.out.println("fallback");*/
                len = lcp[len - 1];
            } else {
                /*System.out.println("reset");*/
                lcp[i] = 0;
                i++;
            }
        }

        return lcp;
    }


}
