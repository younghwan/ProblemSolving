package Fasoo;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        String[] nums = {"4514--234495-1", "305-44-291501", "1-2-34-495-8623", "492134545151", "623-421523-67-341", "-5439-59639921", "6235-7X3+47-7456", "98-76-543-210", "512-73-634901", "000-999999-22-555", "064-82-792561"};
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            boolean isContainNotNums = false;
            String str = nums[i];
            if (str.contains("--")) continue;
            if (str.charAt(0) == '-' || str.charAt(str.length() - 1) == '-') continue;
            String[] pureNums = str.split("-");
            StringBuilder comb = new StringBuilder();
            if (pureNums.length > 4) continue;
            int cnt = 0;
            for (int s = 0; s < pureNums.length; s++) {
                cnt += pureNums[s].length();
                try {
                    Double.parseDouble(pureNums[s]);
                } catch (NumberFormatException e) {
                    isContainNotNums = true;
                }
                if (!isContainNotNums) {
                    comb.append((pureNums[s].length()));
                }
            }
            if (isContainNotNums) continue;
            if (cnt < 11 || cnt > 14) continue;
            System.out.println(comb);
            arr.add(comb.toString());
        }
        Map<String,Integer> map = new HashMap();
        for (int i = 0; i < arr.size(); i++) {
            String word = arr.get(i);
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        Integer[] ans = new Integer[map.size()];
        int i = 0;
        for(String key : map.keySet()){
            int value = map.get(key);
            ans[i] = value;
            i++;
        }
        Arrays.sort(ans,Collections.reverseOrder());

    }

}
