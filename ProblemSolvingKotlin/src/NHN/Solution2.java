package NHN;

import java.util.Stack;

public class Solution2 {
    String ans ="";
    private static void solution(int numOfOrder, String[] orderArr) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.


        for (int i = 0; i < orderArr.length; i++) {
            DFS(orderArr[i]);
        }
    }

    static void DFS(String str) {
        int startIdx = str.indexOf('(');
        int endIdx = str.lastIndexOf(')');

        if (startIdx < 0) {

            for(int i = 0; i<Character.getNumericValue(str.charAt(startIdx-1)); i++){
            }
        }

        String sub = str.substring(startIdx + 1, endIdx);

    }

    public static void main(String[] args) {

    }
}
