package Heap.KthSmallistInMatrix;

import java.util.PriorityQueue;

public class Solution {
//    public int kthSmallest(int[][] matrix, int k) {
//        PriorityQueue<int[]> pq = new PriorityQueue<>(
//                (a, b) -> a[0] - b[0]
//        );
//
//        pq.addAll(Arrays.asList(matrix));
//
//        int pos = (k % matrix.length) - 1;
//        int div = k / matrix.length;
//        if(pos < 0 ) pos = matrix[0].length-1;
//
//        if(div != 1) for (int i = 0; i < k / matrix.length; i++) pq.poll();
//
//        return pq.poll()[pos];
//
//    }

//    public int kthSmallest(int[][] matrix, int k) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//
//        for(int[] arr : matrix){
//            for(int i : arr) pq.add(i);
//        }
//
//        for (int i = 0; i < k-1; i++) pq.poll();
//
//        return pq.poll();
//
//    }

//    public int kthSmallest(int[][] matrix, int k) {
//        int[] high_arr = new int[matrix.length];
//        int[] low_arr = new int[matrix.length];
//
//        for(int i = 0; i < matrix.length; i++) low_arr[i] = matrix[i][0];
//        for(int i = 0; i < matrix.length; i++) high_arr[i] = matrix[i][matrix.length-1];
//
//        int n = k/matrix.length; //2
//        if(low_arr[n]<high_arr[n-1]){
//            if(k<(n+1)*matrix.length){
//
//            }
//        }
//
//        return 0;
//
//    }

    // binary search 답안
//       public int kthSmallest(int[][] matrix, int k) {
//            int n = matrix.length;
//            int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
//            while (lo <= hi) {
//                int mid = lo + (hi - lo) / 2;
//                int count = getLessEqual(matrix, mid);
//                if (count < k) lo = mid + 1;
//                else hi = mid - 1;
//            }
//            return lo;
//        }
//
//        private int getLessEqual(int[][] matrix, int val) {
//            int res = 0;
//            int n = matrix.length, i = n - 1, j = 0;
//            while (i >= 0 && j < n) {
//                if (matrix[i][j] > val) i--;
//                else {
//                    res += i + 1;
//                    j++;
//                }
//            }
//            return res;
//        }


    // heap 풀이
    class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    public int findKthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);

        // put the 1st element of each row in the min heap
        // we don't need to push more than 'k' elements in the heap
        for (int i = 0; i < matrix.length && i < k; i++)
            minHeap.add(new Node(i, 0));

        // take the smallest (top) element form the min heap, if the running count is equal to k return the number
        // if the row of the top element has more elements, add the next element to the heap
        int numberCount = 0, result = 0;
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            result = matrix[node.row][node.col];
            if (++numberCount == k)
                break;
            node.col++;
            if (matrix[0].length > node.col)
                minHeap.add(node);
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 14},
                {12, 13, 15}
        };
//        int[][] matrix = {
//                {-5,2},
//                {-1,5}
//        };
        int k = 8;

        Solution solution = new Solution();
        System.out.println(solution.findKthSmallest(matrix, k));
    }

}
