package Study.연구소;

import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[][] originMap;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        DFS(0, 0, 0);
        System.out.println(ans);
    }

    static void spread(int y, int x, int[][] copyMap) {
        copyMap[y][x] = 2;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && nx >= 0 && ny < copyMap.length && nx < copyMap[0].length) {
                if (copyMap[ny][nx] == 0) {
                    spread(ny, nx, copyMap);
                }
            }
        }
    }

    static void DFS(int y, int x, int cnt) {
        if (cnt == 3) {
            int[][] copyMap = new int[map.length][map[0].length];

            for (int i = 0; i < copyMap.length; i++) {
                for (int j = 0; j < copyMap[i].length; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < copyMap.length; i++) {
                for (int j = 0; j < copyMap[i].length; j++) {
                    if (copyMap[i][j] == 2) {
                        spread(i, j, copyMap);
                    }
                }
            }
            int safeZone = 0;
            for (int i = 0; i < copyMap.length; i++) {
                for (int j = 0; j < copyMap[i].length; j++) {
                    if (copyMap[i][j] == 0) {
                        safeZone++;
                    }
                }
            }
            if (safeZone > ans) ans = safeZone;
//            for (int i = 0; i < copyMap.length; i++) {
//                for (int j = 0; j < copyMap[i].length; j++) {
//                    System.out.print(copyMap[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
                return;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    DFS(i, j, cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
}
/* 27
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
 */
/* 4
4 6
0 1 0 0 0 0
0 1 0 0 0 2
1 1 1 0 0 2
0 0 0 0 0 2
 */
/* 4
4 6
0 0 0 0 0 0
0 0 0 0 0 2
0 0 0 0 0 2
0 0 0 0 0 2
 */