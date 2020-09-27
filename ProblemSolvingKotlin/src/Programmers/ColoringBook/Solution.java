package Programmers.ColoringBook;

import java.util.ArrayList;

class Solution {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean[][] check;
    int[][] mPicture;
    ArrayList<int[]> ar = new ArrayList();
    int cnt = 0;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        mPicture = picture;
        check = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) {
                    DFS(i, j, mPicture[i][j]);
                    int[] t = new int[2];
                    t[0] = mPicture[i][j];
                    t[1] = cnt;
                    ar.add(t);
                }
                cnt = 0;
            }
        }

        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = 0;

        for (int i = 0; i < ar.size(); i++) {
            if (ar.get(i)[0] == 0) continue;
            answer[0]++;
            answer[1] = Math.max(ar.get(i)[1],answer[1]);
        }
        return answer;
    }

    private void DFS(int y, int x, int num) {
        if (mPicture[y][x] != num) return;
        cnt++;
        check[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || ny >= mPicture.length || nx >= mPicture[0].length) continue;

            if (!check[ny][nx]) {
                DFS(ny, nx, num);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1},
                {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        solution.solution(6, 4, arr);
    }
}
