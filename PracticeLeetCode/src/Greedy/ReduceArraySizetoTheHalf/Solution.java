package Greedy.ReduceArraySizetoTheHalf;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int minSetSize(int[] arr) {

        int half = arr.length/2;
        int cnt = 0 , add = 0;
        Map<Integer, Integer> map = new HashMap();

        for (int i : arr) map.put(i, map.getOrDefault(i, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue(
                (o1, o2) -> map.get(o2) - map.get(o1)
        );

        for(int i: map.keySet()) pq.offer(i);

        System.out.println();
        while (add<half){
            add +=map.get(pq.poll());
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {

        int[] arr = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        Solution solution = new Solution();
        System.out.println(solution.minSetSize(arr));

    }
}
