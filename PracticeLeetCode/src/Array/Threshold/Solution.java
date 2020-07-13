package Array.Threshold;

/*
Given an array of integers arr and two integers k and threshold.
Return the number of sub-arrays of size k and average greater than or equal to threshold.


Example 1:

Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
Output: 3
Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively.
All other sub-arrays of size 3 have averages less than 4 (the threshold).
 */

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int sol = 0;
        int cnt = 0;

        for(int i = 0; i < k; i++) sol += arr[i];
        if(sol / k >= threshold) cnt++;
        for(int i = k; i < arr.length; i++) {
            sol += arr[i];
            sol -= arr[i - k];
            if(sol / k >= threshold) cnt++;

        }

        return cnt;
    }
}