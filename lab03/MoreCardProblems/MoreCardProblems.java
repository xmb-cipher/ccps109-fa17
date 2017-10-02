
/**
 * Write a description of class MoreCardProblems here.
 *
 * @author  Cipher
 * @version 20171001
 */
public class MoreCardProblems {
    public int bridgePointCount(String hand) {
        int ans = 0;
        for (int i = 0; i < hand.length(); i += 2 ) {
            if (hand.charAt(i) == 'A') {
                ans += 4;
            }
            else if (hand.charAt(i) == 'K') {
                ans += 3;
            }
            else if (hand.charAt(i) == 'Q') {
                ans += 2;
            }
            else if (hand.charAt(i) == 'J') {
                ans += 1;
            }
        }
        return ans;
    }
    
    
    public int countDeadwood(String hand) {
        int ans = 0;
        for (int i = 0; i < hand.length(); i += 2) {
            char rank = hand.charAt(i);
            if (rank == 'A') {
                ans += 1;
            }
            else if (rank >= '1' && rank <= '9') {
                ans += (int)(rank - '0');
            }
            else {
                ans += 10;
            }
        }
        return ans;
    }
    
    
    public String bridgeHandShape(String hand) {
        int[] cnt = new int[128];
        for (int i = 1; i < hand.length(); i += 2) {
            int suit = (int) hand.charAt(i);
            cnt[suit]++;
        }
        return cnt['s'] + ", " + cnt['h'] + ", " + cnt['d'] + ", " + cnt['c'];
    }
    
    
    public boolean hasFullHouse(String hand) {
        int[] cnt = new int[128];
        for (int i = 0; i < hand.length(); i += 2) {
            int rank = (int) hand.charAt(i);
            cnt[rank]++;
        }
        
        boolean same3 = false;
        boolean same2 = false;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 3) {
                same3 = true;
            }
            if (cnt[i] == 2) {
                same2= true;
            }
        }
        
        return same3 && same2;
    }
}
