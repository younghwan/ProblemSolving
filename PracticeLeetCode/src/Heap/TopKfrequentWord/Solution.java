package Heap.TopKfrequentWord;

import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for (String word : words) map.put(word,map.getOrDefault(word,0)+1);


        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return map.get(s2) - map.get(s1);
            }
        });
        pq.addAll(map.keySet());
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) {
                ans.add(pq.poll());
            }
        }
        return ans;
    }
}
