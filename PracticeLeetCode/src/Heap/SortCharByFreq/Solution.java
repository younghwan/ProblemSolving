package Heap.SortCharByFreq;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public String frequencySort(String str) {
        Map<Character, Integer> map = new HashMap<>();
        str.chars().forEach(e -> map.put((char) e, map.getOrDefault((char) e, 0) + 1));

        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            public int compare(Character a, Character b) {
                if(map.get(a) == map.get(b)) return 0;
                if(map.get(b) - map.get(a)<0) return -1;
                else return 1;
            }
        });


        for (char c : map.keySet()) {
            pq.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            System.out.println(c);
            int n = map.get(c);

            for (int i = 0; i < n; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "tree";
        String c = "abbBAAAAAA";

        Solution solution = new Solution();

        System.out.println(solution.frequencySort(c));
    }
}
