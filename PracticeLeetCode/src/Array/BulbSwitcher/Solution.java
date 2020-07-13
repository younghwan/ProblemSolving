package Array.BulbSwitcher;

class Solution {
    public int numTimesAllBlue(int[] light) {
        int res = 0 , max = 0;
        int[] arr = new int[light.length + 1];
        for (int i = 0; i < light.length; i++) {
            arr[light[i]] = 1;
            max = Math.max(max, light[i]); // (0, 2) = 2
            int index = max - 1; // index == 1

            System.out.println(arr[index]);
            while (index > 0 && arr[index] != index) {
                if (arr[index] == 0) {
                    break;
                }
                index--;
            }

            if (index != 0 && arr[index] == 0) {
                continue;
            }

            res++;
            arr[max] = max;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr ={2,1,3,5,4};

        System.out.println(solution.numTimesAllBlue(arr));
    }
}
