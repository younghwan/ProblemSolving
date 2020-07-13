package Array.FindAllDuplicate;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        //4 -3 -2 -7 8 2 3 1
        for (int i = 0; i < nums.length; ++i) {
                if (nums[Math.abs(nums[i]) - 1] < 0) {
                    ans.add(Math.abs(nums[i]));
                } else {
                    nums[Math.abs(nums[i]) - 1] *= -1;
                }
        }
        return ans;
    }
    //5,4,6,7,9,3,10,9,5,6
    //5,4,-6,-7,-9,-3,-10,9,-5,-6
    // 9
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = {5,4,6,7,9,3,10,9,5,6};

        System.out.println(solution.findDuplicates(arr));
    }
}
