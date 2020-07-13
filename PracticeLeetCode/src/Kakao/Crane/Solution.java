package Kakao.Crane;

import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(pick(moves[0]-1,board));
        for (int i = 1; i < moves.length; i++) {
            int pick_val = pick(moves[i]-1, board);
            if(pick_val != 0) {
                arr.add(pick_val);
            }

            if(arr.size()>=2 && arr.get(arr.size()-1)==arr.get(arr.size()-2)) {
                answer+=2;
                arr.remove(arr.size()-2);
                arr.remove(arr.size()-1);
            }
        }
        return answer;

    }
    public static int pick(int x, int[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            if(board[i][x]!=0) {
                int temp = board[i][x];
                board[i][x]=0;
                return temp;
            }
        }
        return 0;
    }
}