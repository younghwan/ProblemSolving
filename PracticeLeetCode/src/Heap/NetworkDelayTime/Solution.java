package Heap.NetworkDelayTime;

import java.util.*;

//Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
//Output: 2
public class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
        int len = times.length;
        int[] array;
        for(int i = 0; i < len; i ++) {
            array = times[i];
            Map<Integer, Integer> map = cache.getOrDefault(array[0], new HashMap<>());
            map.put(array[1], array[2]);
            cache.put(array[0], map);
        }
        int[] delay = new int[N+1];
        Arrays.fill(delay, Integer.MAX_VALUE);
        delay[K] = 0;
        Set<Integer> travel = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(K);
        while(!queue.isEmpty()) {
            travel.clear();
            Integer u = queue.poll();
            Map<Integer, Integer> result = cache.get(u);
            if (result != null) {
                for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
                    Integer k = entry.getKey();
                    int v = entry.getValue();
                    if (delay[u] + v < delay[k]) {
                        if (!travel.contains(k)) {
                            queue.offer(k);
                            travel.add(k);
                        }
                        delay[k] = delay[u] + v;
                    }
                }
            }
        }
        int maxDelay = 0;
        for (int i = 1; i <= N; i++) {
            maxDelay = Math.max(maxDelay, delay[i]);
        }
        return maxDelay == Integer.MAX_VALUE ? -1 : maxDelay;
    }
}