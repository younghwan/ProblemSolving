package Heap.TopKfrequent;

import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if(map.containsKey(nums[i]))
            {
                Integer value = map.get(nums[i]);
                map.put(nums[i],++value);
            }
            else map.put(nums[i],1);
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());

        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });

        for(int i=0 ; i<k; i++) ans.add(list.get(i).getKey());

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        Solution solution = new Solution();

        List<Integer> list = solution.topKFrequent(nums, k);

        for(int i : list)
        {
            System.out.println(i);
        }

    }

}


