package leetcode.editor.cn;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @ClassName EX5_01Knapsack
 * @Description TODO
 * @Author Patrick Star
 * @Date 2020/12/14 1:12 下午
 */
public class EX5_01Knapsack {

    public static void main(String[] args) {
        // 输入物品数 n，背包容量 c，输入 n 个物品的重量、价值
//        int n = 6, c = 15;
//        int[] wt = {0, 2, 1, 3, 4, 6, 7};// 前面的0是填充
//        int[] val = {0, 4, 2, 3, 5, 7, 4};
        /**
         *      5 10
         *      2 2 6 5 4
         *      6 3 6 4 6
         */
        int n = 5, c = 10;
        int[] wt = {0, 2, 2, 6, 5, 4};
        int[] val = {0, 6, 3, 6, 4, 6};
        int res = 0;
        System.out.println("动态规划：");
        res = dpSolution(n, c, wt, val);
        System.out.println(res);
        System.out.println();
//        res = optdpSolution(n, c, wt, val);

        System.out.println("贪心");
        EX5_01Knapsack solution = new EX5_01Knapsack();
        res = solution.greedySolution(n, c, wt, val);
        System.out.println(res);
        System.out.println();

        solution.dfs(n, c, wt, val, 1, 0);
        System.out.println("回溯法：");
        System.out.println(solution.ans);
    }

    // 动态规划
    // 时间复杂度n*c，空间复杂度n*c
    public static int dpSolution(int n, int c, int[] wt, int[] val) {
        // dp[i][w]对于前i个物品，当前背包容量为w的最大价值
        int[][] dp = new int[n + 1][c + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= c; w++) {
                // 当前物品放不进背包
                if (w - wt[i] < 0) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 因为填充了0，wt和val下标就为i，否则就为i-1
                    dp[i][w] = Math.max(dp[i - 1][w - wt[i]] + val[i], dp[i - 1][w]);
                }
            }
        }
        for (int i = 1; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[n][c];
    }

    // 状态压缩的动态规划
    public static int optdpSolution(int n, int c, int[] wt, int[] val) {
        int[] dp = new int[c + 1];
        // i:前i个物品,w:当前背包容量
        for (int i = 1; i <= n; i++) {
            // w要反向，从后往前遍历，每个物品只能用一次，避免之前的结果影响
            for (int w = c; w >= 0; w--) {
                if (w - wt[i] >= 0) {
                    dp[w] = Math.max(dp[w - wt[i]] + val[i], dp[w]);
                }
            }
            System.out.println(Arrays.toString(dp));

        }
        return dp[c];
    }

    class Knapasck {
        int wt;
        int val;
        double k;//单位重量

        public Knapasck(int wt, int val, double k) {
            this.wt = wt;
            this.val = val;
            this.k = k;
        }

        @Override
        public String toString() {
            return "{" +
                    "wt=" + wt +
                    ", val=" + val +
                    ", k=" + k +
                    '}';
        }
    }

    // 贪心
    // 排序nlogn 判断 n
    // 最坏情况，时间复杂度n*c，空间复杂度n*c
    public int greedySolution(int n, int c, int[] wt, int[] val) {

        PriorityQueue<Knapasck> list = new PriorityQueue<>(new Comparator<Knapasck>() {
            @Override
            public int compare(Knapasck o1, Knapasck o2) {
                if (o1.k == o2.k) {
                    return o1.wt - o2.wt;
                } else {
                    if (o2.k > o1.k) {
                        return 1;
                    } else {
                        return -1;
                    }

                }
            }
        });

//        List<Knapasck> list = new LinkedList<>();


        for (int i = 1; i <= n; i++) {
            list.offer(new Knapasck(wt[i], val[i], (double) val[i] / (double) wt[i]));
        }

        System.out.println(list);
        int sum = 0;//背包装的物品的价值
        while (!list.isEmpty()) {
            // 每次取出最大值
            Knapasck item = list.poll();
            if (c - item.wt >= 0) {
                c -= item.wt;
                sum += item.val;
                System.out.println(item);
            }
        }
        return sum;
    }

    public int ans = 0;
    public HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

    // 回溯
    // 使用了一个hashmap保存(i,c)pair对，判断这条分支是否出现，
    // 时间复杂度n*c，空间复杂度n*c
    public void dfs(int n, int c, int[] wt, int[] val, int i, int v) {
        // dfs初始时从第一个开始放物品
        // c 表示还可以放的容量.v 当前背包的价值
        // **边界条件**
        if (i > n) {
            ans = Math.max(v, ans);
            return;
        }
        // **剪枝**
        // 如果 (i,c)对出现过，则跳过
        if (map.containsKey(i)) {
            HashSet<Integer> set = map.get(i);
            if (set.contains(c)) {
                return;
            }
        }
//        这段注释检查剪枝是否完成
//        if(i==5){
//            System.out.println("i: "+i+" c: "+c);
//
//        }
        // 选择将当前物品i加入背包
        if (c - wt[i] >= 0) {
            // **选择**
            v += val[i];
            HashSet<Integer> iset = map.getOrDefault(i, new HashSet<Integer>());
            iset.add(c);
            map.put(i, iset);
            dfs(n, c - wt[i], wt, val, i + 1, v);
            // **撤销选择**
            v -= val[i];
        }
        // 跳过当前i
        dfs(n, c, wt, val, i + 1, v);
    }
}
