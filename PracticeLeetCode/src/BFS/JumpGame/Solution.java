package BFS.JumpGame;

import java.util.LinkedList;
import java.util.Queue;

/*
Given an array of non-negative integers arr, you are initially positioned at start index of the array.
When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
Notice that you can not jump outside of the array at any time.

Example 1:
Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation:
All possible ways to reach at index 3 with value 0 are:
index 5 -> index 4 -> index 1 -> index 3
index 5 -> index 6 -> index 4 -> index 1 -> index 3
Example 2:

Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true
Explanation:
One possible way to reach at index 3 with value 0 is:
index 0 -> index 4 -> index 1 -> index 3
 */
public class Solution {
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }
        boolean[] flag = new boolean[arr.length];
        boolean res = false;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int index = queue.poll();

            if(index >= arr.length || index <0) continue;

            if(flag[index]) continue;

            if(arr[index] == 0) return true;

            flag[index] = true;
            queue.add(index + arr[index]);
            queue.add(index - arr[index]);

        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,3,0,3,1,2};
        int start = 5;

        Solution solution = new Solution();
        System.out.println(solution.canReach(arr,start));
    }
}
