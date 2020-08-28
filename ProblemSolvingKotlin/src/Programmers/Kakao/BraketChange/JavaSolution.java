package Programmers.Kakao.BraketChange;

import java.util.Stack;
import java.util.stream.Collectors;

public class JavaSolution {
    private static int index = 0;

    public static String solution(String p) {
        if (p.equals("")) return "";
        boolean check = check(p);
        String U = p.substring(0, index), V = p.substring(index);
        return check ? U + solution(V) : "(" + solution(V) + ")" + reverse(U);
    }

    // U를 판단하는 메소드
    private static boolean check(String str) {
        Stack<Character> stack = new Stack<>();
        int balanced = 0;
        index = 0;

        for (char ch : str.toCharArray()) {
            index++;
            if ('(' == ch) {
                stack.push(ch);
                balanced++;
            } else {
                if (!stack.isEmpty()) stack.pop();
                balanced--;
            }

            if (balanced == 0) break;
        }

        return stack.isEmpty();
    }

    // 올바르지 않은 괄호를 변환하는 메소드
    private static String reverse(String str) {
        return str.substring(1, str.length() - 1)
                .chars()
                .mapToObj(v -> '(' == v ? ")" : "(")
                .collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        JavaSolution solution = new JavaSolution();
        System.out.println(solution.solution(")()()()("));
    }
}
