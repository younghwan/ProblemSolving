package Heap.Kcloset;

import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1])
        );
        for (int i = 0; i < points.length; i++) {
            pq.add(points[i]);
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++)
            res[i] = pq.poll();
        return res;
    }


    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int K = 3;

        Solution solution = new Solution();
        int[][] ans = solution.kClosest(points,K);

        for(int i = 0; i<ans.length; i++)
        {
            System.out.println("("+ans[i][0] +","+ ans[i][1]+")");
        }

    }
}

//    public int[][] kClosest(int[][] p, int k) {
//        int[][] res = new int[k][2];
//        PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>(){
//            // @override
//            public int compare(int[] k, int[] l){
//                return l[0] * l[0] + l[1] * l[1] - k[0] * k[0] - k[1] * k[1];
//            }
//        });
//
//        int l = p.length;
//        if (l < k || k == 0) return res;
//        for (int i = 0; i < l; i++){
//            q.offer(p[i]);
//            if (i >= k) {
//                q.poll();
//            }
//        }
//        while(k > 0){
//            res[--k] = q.poll();
//        }
//
//        return res;
//    }