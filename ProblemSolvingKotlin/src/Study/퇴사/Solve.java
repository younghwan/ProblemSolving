package Study.퇴사;

import java.util.Scanner;

public class Solve {
    private void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] dp = new int[n + 1];

        // http://mygumi.tistory.com/151

        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();

            dp[i] = p[i];
        }

        // dp[n] = n일때까지 얻은 수익

        for (int i = 2; i <= n; i++) {

            for (int j = 1; j < i; j++) {

                if (i - j >= t[j]) {
                    dp[i] = Math.max(p[i] + dp[j], dp[i]);
                }

            }

        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            if (i + t[i] <= n + 1) {
                if (max < dp[i]) {
                    max = dp[i];
                }
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        Solve solve = new Solve();
        solve.solve();
    }
}
