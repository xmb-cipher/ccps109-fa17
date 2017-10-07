
/**
 * Write a description of class TwoDeeArrayProblems here.
 *
 * @author  Cipher
 * @version 20171006
 */
public class TwoDeeArrayProblems {
    public double[][] transpose(double[][] a) {
        int row = a.length;
        int col = row > 0 ? a[0].length : 0;
        if (row > 0 && col > 0) {
            double[][] ans = new double[col][row];
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    ans[c][r] = a[r][c];
                }
            }
            return ans;
        }
        else {
            return new double[0][0];
        }
    }
    
    
    public double[] minValues(double[][] a) {
        double[] ans = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            ans[i] = a[i].length > 0 ? a[i][0] : 0;
            for (int j = 1; j < a[i].length; j++) {
                if (a[i][j] < ans[i]) {
                    ans[i] = a[i][j];
                }
            }
        }
        return ans;
    }
    
    
    int[][] zigzag(int rows, int cols, int start) {
        int[][] ans = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < cols; j++) {
                    ans[i][j] = start;
                    start++;
                }
            }
            else {
                for (int j = cols - 1; j >= 0; j--) {
                    ans[i][j] = start;
                    start++;
                }
            }
        }
        return ans;
    }
    
    
    double maximumDistance(double[][] pts) {
        double ans = this.distance(pts[0], pts[1]);
        for (int i = 0; i < pts.length - 1; i++) {
            for (int j = i + 1; j < pts.length; j++) {
                double dist = this.distance(pts[i], pts[j]);
                if (dist > ans) {
                    ans = dist;
                }
            }
        }
        return ans;
    }
    
    
    private double distance(double[] p1, double[] p2) {
        double sum = 0.0;
        for (int i = 0; i < p1.length; i++) {
            sum += (p1[i] - p2[i]) * (p1[i] - p2[i]);
        }
        return Math.sqrt(sum);
    }
}
