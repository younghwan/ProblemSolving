package Soma.test2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int maxStatus = 0;
        int N, M;//참가자수,관계
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        int[][] position = new int[N][2];

        for (int i = 0; i < N; i++) {
            position[i][0] = scanner.nextInt();
            position[i][1] = scanner.nextInt();
        }

        List<Set<Integer>> teamList = new ArrayList<>();
        for (int i = 1; i < M; i++) {
            int r1 = scanner.nextInt();
            int r2 = scanner.nextInt();
            boolean flag = false;
            if(teamList.isEmpty()){
                HashSet<Integer> team = new HashSet<>();
                team.add(r1);
                team.add(r2);
                teamList.add(team);
            }
            else {
                for (int j = 0; j < teamList.size(); j++) {
                    if (teamList.get(j).contains(r1) || teamList.get(j).contains(r2)) {
                        teamList.get(j).add(r1);
                        teamList.get(j).add(r2);
                        flag = true;
                        break;
                    }
                }

                if(!flag){
                    HashSet<Integer> team = new HashSet<>();
                    team.add(r1);
                    team.add(r2);
                    teamList.add(team);
                }

            }
        }

        for (int j = 0; j < teamList.size(); j++) {
            int maxX = 0;
            int maxY = 0;
            int minX = 1000000001;
            int minY = 1000000001;
            Iterator<Integer> iter = teamList.get(j).iterator();
            while (iter.hasNext()){
                int user = iter.next();
                if(position[user][0] >maxX){
                    maxX = position[user][0];
                }
                if(position[user][1] >maxY){
                    maxY = position[user][0];
                }

                if(position[user][0] <minX){
                    minX = position[user][0];
                }
                if(position[user][1] <minY){
                    minY = position[user][0];
                }
            }
            int status = 2*((maxX-minX)+(maxY-minY));
            if(status>maxStatus){
                maxStatus = status;
            }
        }
        System.out.println(maxStatus);
    }
}
