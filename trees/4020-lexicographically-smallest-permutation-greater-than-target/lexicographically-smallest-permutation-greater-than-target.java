import java.util.*;

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Try to match target up to prefix length 'prefixLen'
        // and bump character at index 'prefixLen' to something strictly greater.
        for (int prefixLen = n - 1; prefixLen >= 0; prefixLen--) {
            int[] counts = freq.clone();
            boolean possible = true;

            // Try to match target[0 ... prefixLen - 1]
            for (int j = 0; j < prefixLen; j++) {
                int idx = target.charAt(j) - 'a';
                if (counts[idx] > 0) {
                    counts[idx]--;
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) continue;

            // At position prefixLen, pick the smallest char > target[prefixLen]
            int targetCharIdx = target.charAt(prefixLen) - 'a';
            int bumpChar = -1;
            for (int c = targetCharIdx + 1; c < 26; c++) {
                if (counts[c] > 0) {
                    bumpChar = c;
                    break;
                }
            }

            // If a larger character is available, build the answer
            if (bumpChar != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(target, 0, prefixLen);
                sb.append((char) ('a' + bumpChar));
                counts[bumpChar]--;

                // Fill the rest with smallest remaining characters
                for (int c = 0; c < 26; c++) {
                    while (counts[c] > 0) {
                        sb.append((char) ('a' + c));
                        counts[c]--;
                    }
                }
                return sb.toString();
            }
        }

        return "";
    }
}