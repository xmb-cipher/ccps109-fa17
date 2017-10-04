
/**
 * Implementation of Lab03 of CCPS109-FA17
 *
 * @author  Cipher
 * @version 20171003
 */
public class StringProblems {
    public String removeDuplicates(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 || c != s.charAt(i - 1)) {
                ans.append(c);
            }
        }
        return ans.toString();
    }
    
    
    public int countWords(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (!Character.isWhitespace(c)){
                if (i == 0 || Character.isWhitespace(s.charAt(i - 1))) {
                    ans++;
                }
            }
        }
        return ans;
    }
    
    
    public String convertToTitleCase(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (!Character.isWhitespace(c) && 
                    (i == 0 || Character.isWhitespace(s.charAt(i - 1)))) {
                ans.append(Character.toTitleCase(c));
            }
            else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
    
    
    public String stretch(String s, int n) {
        if (s.length() > 2){
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i == 0 || i == s.length() - 1) {
                    ans.append(s.charAt(i));
                }
                else {
                    char c = s.charAt(i);
                    for (int j = 0; j < n; j++) {
                        ans.append(c);
                    }
                }
            }
            return ans.toString();
        }
        else {
            return s;
        }
    }
}
