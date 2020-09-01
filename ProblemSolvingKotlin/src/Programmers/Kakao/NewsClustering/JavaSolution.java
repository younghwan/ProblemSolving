package Programmers.Kakao.NewsClustering;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JavaSolution {
    public int solution(String str1, String str2) {
        double answer = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        double sum = 0;
        double inter = 0;

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            if ((96 < str1.charAt(i) && str1.charAt(i) < 123) && (96 < str1.charAt(i + 1) && str1.charAt(i + 1) < 123)) {
                map1.put(str1.substring(i, i + 2), map1.getOrDefault(str1.substring(i, i + 2), 0) + 1);
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            if ((96 < str2.charAt(i) && str2.charAt(i) < 123) && (96 < str2.charAt(i + 1) && str2.charAt(i + 1) < 123)) {
                map2.put(str2.substring(i, i + 2), map2.getOrDefault(str2.substring(i, i + 2), 0) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {

            if (map2.get(entry.getKey()) == null) {
                sum += entry.getValue();
            } else {
                inter += Math.min(map2.get(entry.getKey()), entry.getValue());
                sum += Math.max(map2.get(entry.getKey()), entry.getValue());
                map2.remove(entry.getKey());
            }
        }

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            sum += entry.getValue();
        }


        answer = (inter / sum) * 65536;

        if(inter == 0.0 || sum == 0.0){

            if(inter == 0 && sum != 0){
                answer = 0;
            }
            else answer = 65536;
        }



        return (int) answer;
    }

    public static void main(String[] args) {
        JavaSolution javaSolution = new JavaSolution();
        System.out.println(javaSolution.solution("E=M*C^2", "e=m*c^2"));
    }
}
