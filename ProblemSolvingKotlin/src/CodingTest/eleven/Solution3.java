package CodingTest.eleven;

import java.util.Arrays;

public class Solution3 {

    boolean[] check;

    public int solution(int[] A) {
        check = new boolean[10];
        Arrays.sort(A);

        int ans = 0;

        for (int i = 0; i < A.length; i++) {
            if (!check[A[i]]) check[A[i]] = true;
            else {
                int num = A[i];
                while (check[num]) {
                    num++;
                    ans++;
                    if(num>100000000) return -1;
                }
                check[num] = true;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] a = {6,2,3,5,6,3};
        System.out.println(solution3.solution(a));
    }
}
