package String.CustomSortString;

import java.util.Arrays;

public class Solution {
    public String customSortString(String S, String T) {

        StringBuffer sol = new StringBuffer();
        boolean[] flag = new boolean[T.length()];
        Arrays.fill(flag, false);

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int idx_t = T.indexOf(ch);
            int idx_s = S.indexOf(ch);
            if (idx_t > -1) {
                sol.append(S.charAt(idx_s));
                flag[idx_t] = true;
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (!flag[i]) {
                if (S.indexOf(T.charAt(i)) > -1) {
                    sol.insert(sol.toString().lastIndexOf(T.charAt(i)), T.charAt(i));
                } else {
                    sol.append(T.charAt(i));
                }
            }

        }

        return sol.toString();
    }

    public static void main(String[] args) {
        String s = "exv";
        String t = "xwvee";

//        System.out.println(t.lastIndexOf("z"));
        Solution solution = new Solution();
        System.out.println(solution.customSortString(s, t));
//        char ss = s.charAt(0);
//        System.out.println(s.charAt(0));
//        System.out.println(s.indexOf("d"));

    }
}
