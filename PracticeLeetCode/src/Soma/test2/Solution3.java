package Soma.test2;

import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args) {
        int N;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            time[i][0] = scanner.nextInt();
            time[i][1] = scanner.nextInt();
        }
        for(int i=0; i<N; i++)
        {
            int start = time[i][0];
            int end = time[i][1];
            int cnt =0;

            for(int j =0;j<N;j++)
            {
                if(i==j) continue;

                if(start>time[j][0] && time[j][1] >start){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }


}
