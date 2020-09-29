package CodingTest;

public class Solution2 {
    public int solution(String S) {
        if (S.contains("aaa")) return -1;
        if (S.equals("aa")) return 0;

        StringBuilder sb = new StringBuilder();
        if (S.charAt(0) == 'a' && S.charAt(1) != 'a') {
            sb.append('a');
        }

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != 'a') {
                sb.append("aa" + S.charAt(i));
            }
        }
        System.out.println(sb.toString());
        if (S.charAt(S.length() - 1) != 'a') sb.append("aa");
        return sb.toString().length() - S.length();
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        System.out.println(solution2.solution("abb"));
        System.out.println(solution2.solution("dog"));
        System.out.println(solution2.solution("aa"));
    }
}
