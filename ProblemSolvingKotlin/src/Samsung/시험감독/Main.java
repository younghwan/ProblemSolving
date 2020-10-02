package Samsung.시험감독;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int roomCnt = sc.nextInt();
        int[] participants = new int[roomCnt];
        for (int i = 0; i < roomCnt; i++) {
            participants[i] = sc.nextInt();
        }

        int major = sc.nextInt();
        int minor = sc.nextInt();
        long ans = 0;
        for (int i = 0; i < roomCnt; i++) {
            if (participants[i] <= major) {
                ans++;
                continue;
            }
            participants[i] -= major;
            ans++;

            if (participants[i] <= minor) {
                ans++;
                continue;
            }

            if (participants[i] % minor == 0) {
                ans += participants[i] / minor;
            } else {
                ans += (participants[i] / minor) + 1;
            }
        }
        System.out.println(ans);
    }
}
