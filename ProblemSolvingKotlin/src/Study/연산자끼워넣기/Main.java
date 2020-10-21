package Study.연산자끼워넣기;

import java.util.Scanner;

public class Main {
    static int N = 0;
    static int[] nums;
    static int[] sign;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        nums = new int[N];
        sign = new int[4];

        for (int i = 0; i < N; i++) {
            nums[i] = scan.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            sign[i] = scan.nextInt();
        }

        DFS(nums[0], 0);
        System.out.println(max);
        System.out.println(min);

    }

    static void DFS(int num, int cnt) {
        if (cnt == N - 1) {
            if (num > max) max = num;
            if (num < min) min = num;
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (sign[i] != 0) {
                sign[i]--;

                switch (i) {
                    case 0:
                        DFS(num + nums[cnt + 1], cnt + 1);
                        sign[i]++;
                        continue;
                    case 1:
                        DFS(num - nums[cnt + 1], cnt + 1);
                        sign[i]++;
                        continue;
                    case 2:
                        DFS(num * nums[cnt + 1], cnt + 1);
                        sign[i]++;
                        continue;
                    case 3:
                        DFS(num / nums[cnt + 1], cnt + 1);
                        sign[i]++;
                        continue;
                }
            }
        }
    }
}
