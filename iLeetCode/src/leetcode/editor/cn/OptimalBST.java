package leetcode.editor.cn;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * @ClassName OptimalBST
 * @Description TODO
 * @Author Patrick Star
 * @Date 2020/12/10 4:04 下午
 */
public class OptimalBST {
    public static void main(String[] args) {
        int n = 7;
        double[][] e = new double[n + 2][n +1];
        double[][] root = new double[n + 1][n+1];
        double[][] w = new double[n + 2][n + 1];
        double[] p = {0, 0.04, 0.06, 0.08, 0.02, 0.10, 0.12, 0.14};
        double[] q = {0.06, 0.06, 0.06, 0.06, 0.05, 0.05, 0.05, 0.05};
        for (int i = 1; i <= n+1; i++) {
            e[i][i - 1] = q[i - 1];
            w[i][i - 1] = q[i - 1];
        }
        // l是 [i...j] 的长度
        for (int l = 1; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                // 找一个r,作为当前子树[i...j]的根，这里i<=r<=j
                e[i][j] = Double.MAX_VALUE;
                w[i][j] = w[i][j - 1] + p[j] + q[j];
                // 找这个r
                for (int r = i; r <= j; r++) {
                    double t = e[i][r - 1] + e[r + 1][j] + w[i][j];
                    if (t < e[i][j]) {
                        e[i][j] =   Math.floor(t*100)/100;
                        root[i][j] = r;
                    }
                }
            }
        }
        System.out.println("   0    1    2    3    4    5    6     7");
        for(int i=1;i<=n;i++){
            System.out.print(i+" ");
            System.out.println(Arrays.toString(root[i]));
        }
        System.out.println("==================");
        System.out.println("    0     1     2     3     4     5     6      7");

        for(int i=1;i<=n+1;i++) {
            System.out.print(i+" ");

            System.out.println(Arrays.toString(e[i]));
        }


    }
}
