
/**
 * CardProblems implements Lab02 of CCPS109 in FA2017.
 *
 * @author  Cipher
 * @version 20171001
 */
public class CardProblems
{
    public int getRank(char c) {
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
    
    
    public boolean hasFlush(String hand) {
        char suit = hand.charAt(1);
        for (int i = 3; i < hand.length(); i += 2) {
            if (hand.charAt(i) != suit) {
                return false;
            }
        }
        return true;
    }
    
    
    
    public boolean hasFourOfAKind(String hand) {
        int[] cnt = new int[128];   // each cell defaults to 0
        for (int i = 0; i < hand.length(); i += 2) {
            int rank = (int) hand.charAt(i);
            cnt[rank]++;
            if (cnt[rank] == 4) {
                return true;
            }
        }
        return false;
    }
    
    
    public boolean hasFourCardBadugi(String hand) {
        int[] rankCnt= new int[128];
        for(int i = 0; i < hand.length(); i += 2) {
            int rank = (int) hand.charAt(i);
            rankCnt[rank]++;
            if (rankCnt[rank] > 1) {
                return false;
            }
        }
        
        int[] suitCnt= new int[128];
        for(int i = 1; i < hand.length(); i += 2) {
            int suit = (int) hand.charAt(i);
            suitCnt[suit]++;
            if (suitCnt[suit] > 1) {
                return false;
            }
        }
        
        return true;
    }
}
