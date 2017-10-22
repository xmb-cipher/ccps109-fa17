
/**
 * Write a description of class MidtermF17 here.
 *
 * @author  Cipher
 * @version 20171022
 */
public class MidtermF17 {
    public boolean addThree(int a, int b, int c, int d) {
        return -a + b + c + d == 0 ||
                a - b + c + d == 0 ||
                a + b - c + d == 0 ||
                a + b + c - d == 0;
    }
    
    
    private int getRank(char c) {
        if (c == 'T') {
            return 10;
        }
        else if (c == 'J') {
            return 11;
        }
        else if (c == 'Q') {
            return 12;
        }
        else if (c == 'K') {
            return 13;
        }
        else if (c == 'A') {
            return 14;
        }
        else {
            return (int)(c - '0');
        }
    }
    
    
    public boolean beats(String c1, String c2, char trump) {
        char suit1 = c1.charAt(1);
        char suit2 = c2.charAt(1);
        int rank1 = this.getRank(c1.charAt(0));
        int rank2 = this.getRank(c2.charAt(0));
        
        if (suit1 == trump) {
            if (suit1 == suit2) {
                return rank1 > rank2;
            }
            else {
                return true;
            }
        }
        else {
            if (suit1 == suit2) {
                return rank1 > rank2;
            }
            else {
                return false;
            }
        }
    }
    
    
    public String winningCard(String trick, char trump) {
        if (trump == ' ') {
            trump = trick.charAt(1);
        }
        String ans = trick.substring(0, 2);
        for (int i = 0; i < trick.length(); i += 2) {
            String candi = trick.substring(i, i + 2);
            if (this.beats(candi, ans, trump)) {
                ans = candi;
            }
        }
        return ans;
    }
    
    
    // Copied from lab07
    private int countOccurrences(String text, String pattern) {
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
    
    
    public int countOccurrences(int number, int pattern) {
        return countOccurrences(String.valueOf(number), String.valueOf(pattern));
    }
}
