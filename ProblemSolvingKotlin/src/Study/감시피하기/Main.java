package Study.감시피하기;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int N = 0;
    static int[][] map;
    static ArrayList<POS> posT = new ArrayList<>();
    static Boolean ans = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String str = scanner.next();
                if (str.equals("X")) map[i][j] = 0;
                if (str.equals("S")) {
                    map[i][j] = 1;
                }
                if (str.equals("T")) {
                    map[i][j] = 2;
                    posT.add(new POS(i, j));
                }
            }
        }
        DFS(0);
        if (ans) System.out.println("YES");
        else System.out.println("NO");
    }

    static void DFS(int cnt) {
        if (cnt == 3) {
            if (check()) ans = true;
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ans) return;
                if (map[i][j] == 0) {
                    map[i][j] = 3;
                    DFS(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    //체크가 틀린듯
    static Boolean check() {
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};

        for (int j = 0; j < posT.size(); j++) {
            int curX = posT.get(j).x;
            int curY = posT.get(j).y;
            for (int i = 0; i < 4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];
                while (ny >= 0 && nx >= 0 && ny < N && nx < N) {
                    if (map[ny][nx] == 1) {
                        return false;
                    }
                    if (map[ny][nx] == 3) break;
                    ny += curY + dy[i];
                    nx += curX + dx[i];
                }
            }
        }
        return true;
    }
}

class POS {
    int y, x;

    public POS(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

/*
5
X S X X T
T X S X X
X X X X X
X T X X X
X X T X X

3
X S X
S X S
X X X

0 1 0 3 2
2 0 1 3 0
0 0 0 0 0
0 2 0 3 0
0 0 2 0 0
 */