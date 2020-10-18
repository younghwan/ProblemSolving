package Study.경쟁적전염;

import java.io.*;
import java.util.*;
public class Main {
    static int n,k,s,x,y;
    static int map[][];
    static boolean visited[][];
    static int dx[]= {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    // 우선순위 큐란? : 큐에서 pop 할 때 자기가 정한 기준으로 뺄 수 있는 것.
    // 우선순위 큐를 쓰는 이유?
    // 1. 제일 먼저 고려해야 할 것 : 시간대가 작은 것 부터 뺴야한다  큐에 2초  /1초  이렇게 2개 있을경우 1초 부터 빼야함
    // 2. 시간대가 같을시 작은 바이러스 숫자를 빼야 함.
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        k = Integer.parseInt(t[1]);

        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++) {
            String[] map_input = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(map_input[j]);
                if(map[i][j]!=0) {
                    visited[i][j]=true;
                    pq.add(new Node(i,j,0,map[i][j]));
                }
            }
        }

        String[] tt = br.readLine().split(" ");
        s = Integer.parseInt(tt[0]);
        x = Integer.parseInt(tt[1]);
        y = Integer.parseInt(tt[2]);

        bfs();

    }
    public static void bfs() {
        while(!pq.isEmpty()) {
            Node a= pq.poll();
            if(a.time>s) {
                //문제 조건중 주어진 시간대가 넘어가면 0을 출력하게 했습니다
                //어차피 밑에 class에서 구현해준것 덕분에 큐에서 시간이 작은것 부터 나오게 되죠
                System.out.println(0);
                return;
            }
            if(a.x==x-1 && a.y==y-1 && map[a.x][a.y]!=0) {
                //x-1이라고 한 이유는 맵이 1,1부터 시작하는데 문제 제대로 안보고해서
                //0,0 부터 시작했습니다 바뀌기 귀찮아서 그냥 이렇게 했어요
                // 그리고 맵이 0이면 바이러스가 들어있지 않은거니까 0이 아닐때만 출력하게 했어요
                System.out.println(a.virus_num);
                return;
            }
            for(int i=0; i<4; i++) {
                int nx = a.x+dx[i];
                int ny =a.y+dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<n) {
                    if(!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        map[nx][ny]=a.virus_num;
                        pq.add(new Node(nx,ny,a.time+1,a.virus_num));
                    }
                }
            }
        }
    }
}
class Node implements Comparable<Node>{
    int x,y,time,virus_num;
    //x,y는 그냥 좌표
    //time은 바이러스가 퍼질때 걸리는 시간
    //virus_num은 그 칸에 해당하는 바이러스번호
    Node(int x, int y, int time, int virus_num){
        this.x=x;
        this.y=y;
        this.time=time;
        this.virus_num = virus_num;
    }
    // 밑에 compareTo 함수 모르면 구글에 자바 Comparable, Comparator 쳐보세요
    public int compareTo(Node o) {
        if(this.time<o.time || this.time>o.time) {
            return this.time-o.time;
            // 우리가 고려해줘야 할 건 시간이 같을때만 바이러스 번호를 빼야하는겁니다
            // 보통 this.time-o.time을 하면 작은 숫자가 큐에서 반환됩니다
            // 자세한 동작과정은 구글에 Comparable, Comparator 쳐보세요
        }
        else {
            // 시간이 같을때 바이러스번호가 작은것부터 빼줍니다
            return this.virus_num - o.virus_num;
        }
    }
}
