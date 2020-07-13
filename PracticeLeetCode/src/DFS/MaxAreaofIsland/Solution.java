package DFS.MaxAreaofIsland;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};
    int cnt = 0;
    int max = 0;

    public int maxAreaOfIsland(int[][] grid) {

        List<Integer> cnt_list = new ArrayList<>();
        cnt_list.add(0);
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    DFS(grid, col, col);
                    cnt_list.add(cnt);
                    cnt = 0;
                }
            }
        }
        return Collections.max(cnt_list);
    }

    void DFS(int[][] grid, int row, int col) {
        cnt++;
        grid[row][col] = 0;
        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if (ncol >= 0 && nrow >= 0 && ncol < grid[0].length && nrow < grid.length) {
                if (grid[nrow][ncol] == 1) {
                    grid[nrow][ncol] = 0;
                    DFS(grid, nrow, ncol);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int[][] grid2 = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};
        int[][] grid3= {{0}};
        int[][] grid4= {{1,1}};

        Solution solution = new Solution();
        System.out.println(solution.maxAreaOfIsland(grid4));
    }

}
