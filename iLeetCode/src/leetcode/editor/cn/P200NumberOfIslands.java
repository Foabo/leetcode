//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


package leetcode.editor.cn;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

//Java：岛屿数量
public class P200NumberOfIslands {
    public static char[][] getFileInput(String pathName) throws Exception {
        FileInputStream inputStream = null;
        Scanner sc = null;
        List<char[]> list = new ArrayList<>();
        System.out.println(pathName);
        inputStream = new FileInputStream(pathName);
        sc = new Scanner(inputStream, "utf-8");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            int s = 0;
            char c[] = line.toCharArray();
            list.add(c);
        }

        char[][] array = new char[list.size()][list.get(0).length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                array[i][j] = list.get(i)[j];
            }
        }
        inputStream.close();
        sc.close();
        return array;
    }

    public static void print(char[][] cc) {
        for (char c[] : cc) {
            for (char c1 : c) {
                System.out.print(c1);
            }
            System.out.println();

        }
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new P200NumberOfIslands().new Solution();
        File f = new File("");

        String filename = f.getAbsolutePath() + "/src/leetcode/editor/cn/data/P200.txt";
        char cc[][] = P200NumberOfIslands.getFileInput(filename);
        P200NumberOfIslands.print(cc);
        System.out.println(solution.numIslands(cc));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        //并查集
        class UnionFind {

            int count = 0;
            int[] parent;
            int[] rank;

            public UnionFind(char[][] grid) {
                count = 0;
                int m = grid.length;
                int n = grid[0].length;
                //二维变一维
                parent = new int[m * n];
                rank = new int[m * n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] == '1') {
                            //赋初值，即每个parent[i]等于他本身
                            parent[i * n + j] = i * n + j;
                            ++count;

                        }
                        rank[i * n + j] = 0;
                    }
                }

            }

            public int find(int i) {
                if (parent[i] != i) {
                    parent[i] = find(parent[i]);
                }
                return parent[i];
            }

            public void union(int x, int y) {
                int rootx = find(x);
                int rooty = find(y);
                if (rootx != rooty) {
                    if (rank[rootx] > rank[rooty]) {
                        parent[rooty] = rootx;
                    } else if (rank[rootx] < rooty) {
                        parent[rootx] = rooty;
                    } else {
                        parent[rooty] = rootx;
                        //以rootx为根节点的数目加一
                        rank[rootx] += 1;
                    }
                    --count;
                }
            }

            public int getCount() {
                return count;
            }


        }

        //并查集
        public int numIsland3(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int nr = grid.length;
            int nc = grid[0].length;
            UnionFind uf = new UnionFind(grid);
            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == '1') {
                        grid[r][c] = '0';
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            uf.union(r * nc + c, (r - 1) * nc + c);
                        }
                        if (r + 1 < nr && grid[r + 1][c] == '1') {
                            uf.union(r * nc + c, (r + 1) * nc + c);
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            uf.union(r * nc + c, r * nc + c - 1);
                        }
                        if (c + 1 < nc && grid[r][c + 1] == '1') {
                            uf.union(r * nc + c, r * nc + c + 1);
                        }

                    }
                }
            }
            return uf.getCount();
        }


        //广度优先搜索
        public int numIsland2(char[][] grid) {
            //边界判定
            if (grid.length == 0 || grid == null) {
                return 0;
            }

            int nr = grid.length;
            int nc = grid[0].length;
            //用一个遍历num_island保存bfs次数
            int num_island = 0;

            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == '1') {
                        ++num_island;
                        grid[r][c] = '0';
                        Queue<Integer> neighbors = new LinkedList<>();
                        //r*nc+c是当前节点的位置,之后还原为row  column
                        neighbors.add(r * nc + c);
                        while (!neighbors.isEmpty()) {
                            int id = neighbors.remove();
                            int row = id / nc;
                            int col = id % nc;
                            //上
                            if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                                neighbors.offer((row - 1) * nc + col);
                                grid[row - 1][col] = '0';
                            }
                            //下
                            if (row + 1 < nr && grid[row + 1][col] == '1') {
                                neighbors.offer((row + 1) * nc + col);
                                grid[row + 1][col] = '0';
                            }
                            //左
                            if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                                neighbors.offer(row * nc + col - 1);
                                grid[row][col - 1] = '0';
                            }
                            //右
                            if (col + 1 < nc && grid[row][col + 1] == '1') {
                                neighbors.offer(row * nc + col + 1);
                                grid[row][col + 1] = '0';
                            }
                        }
                    }
                }
            }

            return num_island;
        }

        void dfs(char[][] grid, int r, int c) {
            int nr = grid.length;
            int nc = grid[0].length;
            if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
                return;
            }
            //访问的格子变为0
            grid[r][c] = '0';
            //四个方向进行深度优先搜索
            dfs(grid, r - 1, c);
            dfs(grid, r, c - 1);
            dfs(grid, r + 1, c);
            dfs(grid, r, c + 1);

        }

        //深度优先搜索
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int nr = grid.length;
            int nc = grid[0].length;
            //用一个变量num_island保存dfs的次数
            int num_island = 0;
            //遍历整个二维数组
            for (int r = 0; r < nr; r++) {
                for (int c = 0; c < nc; c++) {
                    if (grid[r][c] == '1') {
                        ++num_island;
                        dfs(grid, r, c);
                    }
                }
            }
            return num_island;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}