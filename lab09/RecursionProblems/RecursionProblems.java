
/**
 * Write a description of class RecursionProblems here.
 *
 * @author  Cipher
 * @version 20171006
 */
public class RecursionProblems {
    public boolean allEqual(int[] arr, int start, int end) {
        int length = end - start + 1;
        return length < 2 || 
            arr[start] == arr[end] && this.allEqual(arr, start, end - 1);
    }
    
    
    public void arraycopy(double[] src, int start, double[] tgt, int start2, int len) { 
        if (len > 0) {
            tgt[start2] = src[start];
            this.arraycopy(src, start + 1, tgt, start2 + 1, len - 1);
        }
    }
    
    
    public boolean linearSearch(int[] arr, int x, int start, int end) {
        int length = end - start + 1;
        if (length > 0) {
            return arr[start] == x || this.linearSearch(arr, x, start + 1, end);
        }
        else {
            return false;
        }
    }
    
    
    public void reverse(int[] arr, int start, int end) {
        int length = end - start + 1;
        if (length > 2) {
            int t = arr[start];
            arr[start] = arr[end];
            arr[end] = t;
            reverse(arr, start + 1, end - 1);
        }
    }
    
    
    public void parityPartition(int[] arr, int start, int end) {
        int length = end - start + 1;
        if (length > 1) {
            // modulus in java is signed 
            // e.g. -3 % 2 == -1
            if (arr[start] % 2 != 0) {
                this.parityPartition(arr, start + 1, end);
            }
            else {
                int t = arr[end];
                arr[end] = arr[start];
                arr[start] = t;
                this.parityPartition(arr, start, end - 1);
            }
        }
    }
    
    
    public int countRuns(int[] arr, int start, int end) {
        int length = end - start + 1;
        if (length > 1) {
            int ans = this.countRuns(arr, start, end - 1);
            return arr[end] != arr[end - 1] ? ans + 1 : ans;
        }
        else if (length == 1) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
