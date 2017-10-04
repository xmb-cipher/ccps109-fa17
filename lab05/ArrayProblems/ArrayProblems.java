
/**
 * Implementation of Lab05 of CCPS109-FA17.
 *
 * @author  Cipher
 * @version 20171004
 */
public class ArrayProblems {
    public int[] everyOther(int[] a) {
        int len = a.length / 2 + a.length % 2;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = a[i * 2];
        }
        return ans;
    }
    
    
    public int countInversions(int[] a) {
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }
    
    
    public void squeezeLeft(int[] a) {
        int nnz = 0;
        for (int i = 0; i < a.length; i++ ) {
            if (a[i] != 0) {
                a[nnz++] = a[i];
            }
        }
        for (int i = nnz; i < a.length; i++) {
            a[i] = 0;
        }
    }
    
    
    public int[] runDecode(int[] a) {
        int len = 0;
        for (int i = 0; i < a.length; i += 2) {
            len += a[i];
        }
        
        int[] ans = new int[len];
        int k = 0;
        
        for (int i = 0; i < a.length; i += 2) {
            int cnt = a[i];
            int c = a[i + 1];
            for (int j = 0; j < cnt; j++) {
                ans[k++] = c;
            }
        }
        
        return ans;
    }
}
