package DFS.Minesweeper;

class Solution {
    int dx[] = {0, 0, 1, 1, 1, -1, -1, -1};
    int dy[] = {1, -1, 0, 1, -1, 1, 0, -1};

    public char[][] updateBoard(char[][] board, int[] click) {

        char[][] map = board;
        int x = click[0];
        int y = click[1];

        if (map[x][y] == 'M') {
            map[x][y] = 'X';
        } else if (findMine(map, x, y) == 0) {
            map[x][y] = 'B';
            DFS(board, x, y);
        } else if (findMine(map, x, y) > 0) {
            map[x][y] = (char) (findMine(map, x, y) + '0');
        }

        return map;
    }

    char[][] DFS(char[][] board, int x, int y) {
        char[][] map = board;
        int x_lim = map.length;
        int y_lim = map[0].length;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < x_lim && ny < y_lim && nx > -1 && ny > -1 && map[nx][ny] == 'E') {

                if (findMine(map, nx, ny) == 0) {
                    map[nx][ny] = 'B';
                }
                if (findMine(map, nx, ny) > 0) {
                    map[nx][ny] = (char) (findMine(map, nx, ny) + '0');
                    continue;
                }
                DFS(map, nx, ny);
            }

        }
        return map;
    }

    int findMine(char[][] map, int x, int y) {
        int cntMine = 0;
        int x_lim = map.length;
        int y_lim = map[0].length;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < x_lim && ny < y_lim && nx > -1 && ny > -1 && map[nx][ny] == 'M') {
                cntMine++;
            }

        }
        return cntMine;
    }

}

