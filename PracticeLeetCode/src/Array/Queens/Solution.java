package Array.Queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

        int dx[] = {0, 0, 1, 1, 1, -1, -1, -1};
        int dy[] = {1, -1, 0, 1, -1, 1, 0, -1};

        List<List<Integer>> sol = new ArrayList<>();

        int[][] map = new int[8][8];

        for (int i = 0; i < queens.length; i++) {
            int x = queens[i][0];
            int y = queens[i][1];

            map[x][y] = 2;
        }
        int k_x = king[0];
        int k_y = king[1];

        for (int i = 0; i < 8; i++) {
            k_x = k_x + dx[i];
            k_y = k_y + dy[i];


            while (k_x < 8 && k_y < 8 && k_y >= 0 && k_x >= 0) {
                if (map[k_x][k_y] == 2) {
                    sol.add(Arrays.asList(k_x, k_y));
                    continue;
                }

                k_x = k_x + dx[i];
                k_y = k_y + dy[i];

            }

        }

        return sol;

    }
}

//class Solution {
//    public static String COLON = ":";
//    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
//        List<List<Integer>> rslt = new ArrayList<>();
//
//        Set<String> qset = new HashSet<>();
//        for(int[] qpos:queens){
//            String str = qpos[0] + COLON + qpos[1];
//            qset.add(str);
//        }
//        for(int i = -1; i <= 1; i++){
//            for(int j = -1; j <= 1; j++){
//                for(int k = 1; k <= 8; k++){
//                    int xpos = king[0] + i*k;
//                    int ypos = king[1] + j*k;
//                    String ts = xpos + COLON + ypos;
//                    if (qset.contains(ts)){
//                        rslt.add(Arrays.asList(xpos,ypos));
//                        break;
//                    }
//                }
//            }
//        }
//        return rslt;
//    }
//}


//class Solution {
//    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
//        List<List<Integer>> result = new ArrayList<>();
//        boolean[][] seen = new boolean[8][8];
//        for (int[] queen : queens) seen[queen[0]][queen[1]] = true;
//        int[] dirs = {-1, 0, 1};
//        for (int dx : dirs) {
//            for (int dy : dirs) {
//                if (dx == 0 && dy == 0) continue;
//                int x = king[0], y = king[1];
//                while (x + dx >= 0 && x + dx < 8 && y + dy >= 0 && y + dy < 8) {
//                    x += dx;
//                    y += dy;
//                    if (seen[x][y]) {
//                        result.add(Arrays.asList(x, y));
//                        break;
//                    }
//                }
//            }
//        }
//        return result;
//    }
//}