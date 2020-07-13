package Array.CountServers;

public class Solution {
    public int countServers(int[][] grid) {

        int[][] map = grid;
        int tempCnt = 0;
        int sol = 0;
        int tx = 0, ty = 0;
        boolean check = false;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != 0) {
                    tempCnt++;

                    if (!check) {
                        tx = i;
                        ty = j;
                        check = true;
                    }

                }
                if (map[i][j] != 0 && tempCnt > 1) {
                    map[i][j] = 2;
                    map[tx][ty] = 2;
                }
            }
            tempCnt = 0;
            check = false;
        }
        // l -> r

        for (int i = 0; i < map[0].length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[j][i] != 0) {
                    tempCnt++;
                    if (!check) {
                        tx = j;
                        ty = i;
                        check = true;
                    }

                }
                if (map[j][i] != 0 && tempCnt > 1) {
                    map[j][i] = 2;
                    map[tx][ty] = 2;
                }
            }
            tempCnt = 0;
            check = false;
        }

        // u -> d

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 2) {
                    sol++;
                }
            }
        }


        return sol;
    }
}



