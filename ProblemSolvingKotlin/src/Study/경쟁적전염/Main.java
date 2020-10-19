package Study.경쟁적전염;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    int y, x, num;

    public Node(int y, int x, int num) {
        this.y = y;
        this.x = x;
        this.num = num;
    }

    @Override
    public int compareTo(Node o) {
        if (this.num > o.num) return 1;
        else return -1;
    }
}

public class Main {
    static int N = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        int K = scanner.nextInt();
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        int S = scanner.nextInt();
        int Y = scanner.nextInt();
        int X = scanner.nextInt();
        ArrayList<Node> nodes = new ArrayList<>();
        ArrayList<Node> nodes2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    nodes.add(new Node(i, j, map[i][j]));
                }
            }
        }
        Collections.sort(nodes);

//        for (int i = 0; i < nodes.size(); i++) {
//            System.out.println(nodes.get(i).num);
//        }
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        for (int s = 0; s < S; s++) {
            while (!nodes.isEmpty()) {
                Node cur = nodes.get(0);
                nodes.remove(0);
                int curX = cur.x;
                int curY = cur.y;
                for (int i = 0; i < 4; i++) {
                    int nx = dx[i] + curX;
                    int ny = dy[i] + curY;

                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        if (map[ny][nx] == 0) {
                            map[ny][nx] = cur.num;
                            nodes2.add(new Node(ny, nx, cur.num));
                        }
                    }
                }
            }
            nodes = nodes2;
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(map[Y - 1][X - 1]);
    }


}
