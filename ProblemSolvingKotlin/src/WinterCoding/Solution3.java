package WinterCoding;

import java.util.LinkedList;
import java.util.Queue;


public class Solution3 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] ans = {0, 0, 0};
    static boolean[][] flagsMap;

    public int[] solution(int[][] v) {
        flagsMap = new boolean[v.length][v.length];
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v.length; j++) {
                Queue<Pos> q = new LinkedList<>();
                if (!flagsMap[i][j]) {
                    Pos pos = new Pos(i, j);
                    q.add(pos);
                    int unit = v[i][j];
                    int cnt = 0;
                    while (!q.isEmpty()) {
                        Pos top = q.poll();
                        cnt++;
                        for (int d = 0; d < 4; d++) {
                            int ny = top.y + dy[d];
                            int nx = top.x + dx[d];

                            if (ny >= 0 && nx >= 0 && ny < v.length && nx < v.length) {
                                if (unit == v[ny][nx]) {
                                    flagsMap[ny][nx] = true;
                                    q.add(new Pos(ny, nx));
                                }
                                else break;
                            }
                        }
                    }
                    ans[unit] += cnt;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[][] a = {{0, 0, 1, 1}, {1, 1, 1, 1}, {2, 2, 2, 1}, {0, 0, 0, 2}};
        solution3.solution(a);
    }
}

class Pos {
    int y;
    int x;

    public Pos(int y, int x) {
        this.y = y;
        this.x = x;
    }
}