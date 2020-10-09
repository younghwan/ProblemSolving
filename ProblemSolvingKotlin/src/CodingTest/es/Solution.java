package CodingTest.es;

import java.util.Arrays;

class Solution {
    public int[] solution(String[] S) {

        int[] alpa = new int[26];
        int[] ans = new int[3];
        Arrays.fill(alpa, -1);
        boolean flag = false;
        for (int i = 0; i < S[0].length(); i++) {
            for (int j = 0; j < S.length; j++) {
                if (alpa[S[j].charAt(i) - 97] == -1) {
                    alpa[S[j].charAt(i) - 97] = j;
                } else if (alpa[S[j].charAt(i) - 97] != -1) {
                    ans[0] = alpa[S[j].charAt(i) - 97];
                    ans[1] = j;
                    ans[2] = i;
                    flag = true;
                }
            }
            Arrays.fill(alpa, -1);
        }
        if(!flag){
            return new int[0];
        };
        return ans;
    }

    public static void main(String[] args) {
        String[] s = {"gr", "sd", "rg"};

        Solution solution = new Solution();
        System.out.println(solution.solution(s)[0]);
    }
}
