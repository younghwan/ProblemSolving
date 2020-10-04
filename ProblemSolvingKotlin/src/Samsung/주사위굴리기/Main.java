package Samsung.주사위굴리기;

import java.util.Scanner;

public class Main {

    static int[][] map = new int[20][20];
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};


    public static void main(String[] args) {
        Dice dice = new Dice();

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int curY = sc.nextInt();
        int curX = sc.nextInt();

        int orderCnt = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }


        for (int i = 0; i < orderCnt; i++) {
            int dir = sc.nextInt();
            if (curY + dy[dir - 1] < 0 || curY + dy[dir - 1] >= N || curX + dx[dir - 1] <0 || curX + dx[dir - 1] >= M) continue;

            curY = curY + dy[dir - 1];
            curX = curX + dx[dir - 1];

            dice.move(dir);

            if (map[curY][curX] == 0) {
                map[curY][curX] = dice.bottom;
            } else {
                dice.bottom = map[curY][curX];
                map[curY][curX] = 0;
            }

            System.out.println(dice.top);
        }
    }
}

class Dice {

    int top, bottom, right, left, front, back;

    Dice() {
        top = 0;
        bottom = 0;
        right = 0;
        left = 0;
        front = 0;
        back = 0;
    }

    void move(int dir) {
        switch (dir) {
            case 1:
                goEast();
                break;
            case 2:
                goWest();
                break;
            case 3:
                goNorth();
                break;
            case 4:
                goSouth();
                break;
        }
    }

    void goEast() {
        int temp1 = right;
        int temp2 = bottom;

        bottom = temp1;
        temp1 = left;

        left = temp2;
        temp2 = top;

        top = temp1;
        right = temp2;
    }

    void goWest() {
        int temp1 = left;
        int temp2 = bottom;

        bottom = temp1;
        temp1 = right;

        right = temp2;
        temp2 = top;

        top = temp1;
        left = temp2;
    }


    void goSouth() {
        int temp1 = bottom;
        int temp2 = front;

        front = temp1;
        temp1 = top;

        top = temp2;
        temp2 = back;

        back = temp1;
        bottom = temp2;
    }

    void goNorth() {
        int temp1 = front;
        int temp2 = bottom;

        bottom = temp1;
        temp1 = back;

        back = temp2;
        temp2 = top;

        top = temp1;
        front = temp2;
    }

    void print() {
        System.out.println(front);
        System.out.println(top);
        System.out.println(back);
        System.out.println(bottom);
        System.out.println(left);
        System.out.println(right);
    }

}
