package Greedy.LastStoneWeight;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones) {
            pq.add(i);
        }
        while (pq.size() != 1) {
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a - b);
        }
        int ans = pq.poll();
        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {2, 7, 4, 1, 8, 1};
        Solution sol = new Solution();
        System.out.println(sol.lastStoneWeight(arr));
    }

}
