package Array.Subset;

import java.util.ArrayList;
import java.util.List;

public class Solution {

//    public List<List<Integer>> subsets(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> ans_list = new ArrayList<>();
//        List<Integer> ans = new ArrayList<>();
//        //1 2 3
//        //1 -> 1, [1,2] [1,3] [1,2,3] 1개 , 2개 3
//        //2-> 2, 2 ,3
//        dfs(nums, 0, ans, ans_list);
//        return ans_list;
//    }

    public void dfs(int[] nums, int index, List<Integer> ans, List<List<Integer>> result){
        result.add(new ArrayList<>(ans));
        for(int i = index; i < nums.length; i++){
            ans.add(nums[i]);
            System.out.println(ans);
            dfs(nums, i+1, ans, result);
            ans.remove(ans.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {1,2,3};
        System.out.println(solution.subsets(arr));
    }

    //bitmask로 풀기
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> output = new ArrayList();
            int n = nums.length;

            for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
                // generate bitmask, from 0..00 to 1..11
                String bitmask = Integer.toBinaryString(i).substring(1);
                System.out.println(bitmask);

                // append subset corresponding to that bitmask
                List<Integer> curr = new ArrayList();
                for (int j = 0; j < n; ++j) {
                    if (bitmask.charAt(j) == '1') curr.add(nums[j]);
                }
                output.add(curr);
            }
            return output;
        }

}
