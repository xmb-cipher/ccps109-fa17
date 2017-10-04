
/**
 * Implementation of Lab06 of CCPS109-FA17.
 *
 * @author  Cipher
 * @version 20171004
 */
public class ArrayShapeProblems {
    int countUpsteps(int[] a) {
        int ans = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] < a[i]) {
                ans++;
            }
        }
        return ans;
    }
    
    
    boolean sameStepShape(int[] a, int[] b) {
        boolean ans = true;
        for (int i = 1; i < a.length && ans; i++) {
            boolean isUpstep = a[i - 1] < a[i] && b[i - 1] < b[i];
            boolean isDownstep = a[i - 1] > a[i] && b[i - 1] > b[i];
            boolean isPlateau = a[i - 1] == a[i] && b[i - 1] == b[i];
            ans &= isUpstep || isDownstep || isPlateau;
        }
        return ans;
    }
    
    
    boolean isSawtooth(int[] a) {
        if (a.length > 1 && a[0] == a[1]) {
            return false;
        }
        
        for (int i = 2; i < a.length; i++) {
            // it takes more cycles but less code-typing
            if ((a[i - 2] - a[i - 1]) * (a[i - 1] - a[i]) >= 0) {
                return false;
            }
        }
        return true;
    }
    
    
    boolean isMountain(int[] a)  {
        boolean up = true;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] == a[i]) {
                return false;
            }
            
            if (up) {
                if (a[i - 1] > a[i]) {
                    up = false;
                }
            }
            else {
                if (a[i - 1] < a[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
