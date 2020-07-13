package DFS.Minesweeper;


public class Minesweeper {

    public static void main(String[] args) {

        char[][] ans;

        int[] click1 = {3,0};
        int[] click2 = {1,2};

        char[][] arr1 = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };

        char[][] arr2 = {
                {'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}
        };



        Solution solution = new Solution();

//        ans = solution.updateBoard(arr1,click1);
        ans = solution.updateBoard(arr2,click2);

        for(int i=0;i <ans.length; i++)
        {
            for(int j =0; j<ans[i].length; j++)
            {
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
}