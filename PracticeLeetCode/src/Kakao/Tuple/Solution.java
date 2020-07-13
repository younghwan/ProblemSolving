package Kakao.Tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2).replace("},{", "-");
        String[] arr = s.split("-");
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        ArrayList<Integer> list = new ArrayList<>();
        for (String temp : arr) {
            String[] str_arr = temp.split(",");

            for (int i = 0; i < str_arr.length; i++) {
                int num = Integer.parseInt(str_arr[i]);

                if (!list.contains(num)) {
                    list.add(num);
                }
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
