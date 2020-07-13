package Math.FindAllNum;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        //4 3 2 7 8 2 3 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                if (nums[nums[i] * -1 - 1] > 0)
                    nums[nums[i] * -1 - 1] *= -1;
            } else {
                if (nums[nums[i] - 1] > 0)
                    nums[nums[i] - 1] *= -1;
            } //abs
        }
        for (int i : nums) System.out.print(i + " ");
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                ans.add(i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};

        Solution solution = new Solution();
        solution.findDisappearedNumbers(arr);
    }
}
