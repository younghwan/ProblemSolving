package DFS.LetterCasePermutation;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        int i = 0;
        DFS(S, list);
        return list;
    }

//    void DFS(String str, List<String> list, int i) {
//        if (i == str.length()) {
//            list.add(str);
//            return;
//        }
//        char[] s = str.toCharArray();
//        if (Character.isLetter(s[i])) {
//            s[i] = Character.toUpperCase(s[i]);
//            DFS(String.valueOf(s), list, i+1);
//            s[i] = Character.toLowerCase(s[i]);
//            DFS(String.valueOf(s), list, i+1);
//        } else DFS(str, list, ++i);
//    }

    void DFS(String str, List<String> list) {
        if (!list.contains(str)) {
            list.add(str);
        } else return;

        char[] s = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(s[i])) {
                if (Character.isUpperCase(s[i])) {
                    s[i] = Character.toLowerCase(s[i]);
                    DFS(String.valueOf(s), list);
                }
                if (Character.isLowerCase(s[i])) {
                    s[i] = Character.toUpperCase(s[i]);
                    DFS(String.valueOf(s), list);
                }
            } else DFS(str, list);
        }
    }


    public static void main(String[] args) {
        String str = "mQe";
        Solution solution = new Solution();
        List<String> l = solution.letterCasePermutation(str);
        for (String s : l) {
            System.out.println(s);
        }

    }
}
