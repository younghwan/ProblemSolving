package Naver;

import java.util.*;
/*
네이버 페이를 이용해서 물품을 구매한 고객들에게 10% 할인 쿠폰을 지급하려 합니다. 쿠폰을 지급하는 방법은 다음과 같습니다.

물품을 구매한 고객은 하루에 최대 1장씩 할인 쿠폰을 받습니다.
고객 한 명당 최대 k장까지 할인 쿠폰을 받을 수 있습니다.
예를 들어 고객 한 명당 k = 2장까지 할인 쿠폰을 받을 수 있고, A 고객이 3일 동안 매일 물건을 구매했다면, 이 고객은 할인 쿠폰을 두 장 받습니다.

각 날짜별로 네이버 페이를 이용해 물품을 구매한 고객들의 ID가 문자열 형태로 담긴 배열 id_list, 고객 한 명당 받을 수 있는 최대 쿠폰 수 k가 매개변수로 주어질 때, 고객들에게 지급된 쿠폰은 모두 몇 장인지 return 하도록 solution 함수를 완성해주세요.

제한사항
id_list의 길이는 1 이상 1,000 이하입니다.
id_list의 원소는 각 날짜별로 물품을 구매한 고객 ID가 담긴 문자열입니다.
각 문자열의 길이는 1 이상 10,000 이하입니다.
문자열에서 고객 ID는 공백으로 구분되어 있습니다.
고객 ID의 길이는 1 이상 10 이하이며, 알파벳 대문자로만 되어있습니다.
하루에 물품을 여러 번 구매한 고객이 있을 수 있습니다.
k는 1 이상 id_list의 길이 이하인 자연수입니다.
입출력 예
id_list	k	result
["A B C D", "A D", "A B D", "B D"]	2	7
["JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"]	3	8
입출력 예 설명
입출력 예 #1

날짜	쿠폰을 받은 고객
첫째 날	A, B, C, D
둘째 날	A, D
셋째 날	B
넷째 날	없음
A 고객은 첫째, 둘째 날 쿠폰을 받고, 셋째 날에는 쿠폰을 받지 않습니다.
B 고객은 첫째, 셋째 날 쿠폰을 받고, 넷째 날에는 쿠폰을 받지 않습니다.
C 고객의 경우 첫째 날만 쿠폰을 받습니다.
D 고객은 첫째, 둘째 날 쿠폰을 받고, 셋째, 넷째 날에는 쿠폰을 받지 않습니다.
따라서 쿠폰이 총 7장 지급됐습니다.
 */
public class Solution2 {
    public int solution(String[] id_list, int k) {

        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i<id_list.length; i++) {
            String[] id = id_list[i].split(" ");

            set.addAll(Arrays.asList(id));
            Iterator<String> iter = set.iterator();

            while (iter.hasNext()){
                String str = iter.next();
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
            set.clear();
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > k) res += k;
            else res += entry.getValue();
        }
        return res;
    }

    public static void main(String[] args) {
        String[] id_list = {"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"};
        int k = 3;
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.solution(id_list,k));
    }
}
