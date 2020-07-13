package Soma;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    static int N, M;
    static int[][] arr;

    public static void main(String[] args) {

        //init
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int tc;
        boolean ans;

        tc = scanner.nextInt();
        while (tc > 0) {
            ans = true;
            N = scanner.nextInt();
            M = scanner.nextInt();
            arr = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            //sol
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 0) {

                        if(!main.FindOne(i,j)){
                            ans = false;
                            break;
                        }
                    }
                }
                if(!ans) break;
            }

            if(!ans)System.out.println("NO");
            else System.out.println("YES");
            tc--;
        }

    }
    boolean FindOne(int x, int y) {
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int one_cnt = 0;
            while (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 1) {
                    one_cnt++;
                }
                nx = nx + dx[i];
                ny = ny + dy[i];
            }
            if (one_cnt % 2 == 1) {
                flag = false;
                break;
            }
        }
        return flag;
    }

//    1
//            3 3
//            1 1 1
//            1 0 1
//            1 1 1

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder ans = new StringBuilder();
//        int n, cnt, mod;
//        n = scanner.nextInt();
//
//        mod = n;
//        if (n >= 7) {
//            cnt = n / 7;
//            mod = n % 7;
//
//
//            for (int i = 0; i < cnt; i++) {
//                ans.append("11");
//            }
//        }
//
//        if (mod > 3) ans.append("11");
//        else if (mod == 3) ans.append("7");
//        else if (mod == 2) ans.append("1");
//        System.out.println(ans);
//
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N,K;
//        N = scanner.nextInt();
//        K = scanner.nextInt();
//        int[] arr = new int[N];
//
//        for(int i= 0; i<N; i++)
//        {
//            arr[i] = scanner.nextInt();
//        }
//
//        System.out.println(arr[arr.length-K]-arr[0]);
//
//    }
}

//6 3
//        4 8 15 16 23 42
//12
