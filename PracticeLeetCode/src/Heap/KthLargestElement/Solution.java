package Heap.KthLargestElement;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
//    public int findKthLargest(int[] nums, int k) {
//
//        int sol = 0;
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//        for(int i=0 ;i<nums.length; i++)
//        {
//            pq.add(nums[i]);
//        }
//        for(int i =0 ;i<k; i++)
//        {
//            sol = pq.poll();
//        }
//        return sol;
//    }

    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
