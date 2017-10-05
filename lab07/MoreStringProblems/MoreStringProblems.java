
/**
 * Write a description of class MoreStringProblems here.
 *
 * @author  Cipher
 * @version 20101004
 */
public class MoreStringProblems {
    public String uniqueCharacters(String text) {
        boolean[] occur = new boolean[Character.MAX_VALUE];
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
             char ch = text.charAt(i);
             int hash = (int) ch;
             if (!occur[hash]) {
                 ans.append(ch);
                 occur[hash] = true;
             }
        }
        return ans.toString();
    }
    
    
    public int countOccurrences(String text, String pattern) {
        int ans = 0;
        int plen = pattern.length();
        for (int i = 0; i < text.length() - plen + 1; i++) {
            boolean match = true;
            for (int j = 0; j < plen; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                ans++;
            }
        }
        return ans;
    }
    
    
    public String cyclicLeftShift(String s, int k) {
        if (s.length() > 1) {
            int shift = k % s.length();
            return s.substring(shift) + s.substring(0, shift);
        }
        else {
            return s;
        }
    }
    
    
    public int parseInt(String s) {
        int ans = 0;
        boolean isNonNegative = s.charAt(0) != '-';
        
        for (int i = isNonNegative ? 0 : 1; i < s.length(); i++) {
            ans = ans * 10 + (s.charAt(i) - '0');
        }
        
        return isNonNegative ? ans : -ans;
    }
}
