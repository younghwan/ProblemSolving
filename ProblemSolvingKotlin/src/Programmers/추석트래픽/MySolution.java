package Programmers.추석트래픽;

public class MySolution {

    public int solution(String[] lines) {

        int ans = 0;
        int[] startTime = new int[lines.length];
        int[] endTime = new int[lines.length];

        getTimes(lines, startTime, endTime);

        for (int i = 0; i < lines.length; i++) {
            int cnt = 0;
            int startSection = startTime[i];
            int endSection = startSection + 1000;

            for (int j = 0; j < lines.length; j++) {
                if (startSection <= startTime[j] && endSection > startTime[j]) cnt++;
                else if (startSection <= endTime[j] && endSection > endTime[j]) cnt++;
                else if (startSection >= startTime[j] && endSection <= endTime[j]) cnt++;
            }
            ans = Math.max(cnt, ans);
        }

        for (int i = 0; i < lines.length; i++) {
            int cnt = 0;
            int startSection = endTime[i];
            int endSection = startSection + 1000;

            for (int j = 0; j < lines.length; j++) {
                if (startSection <= startTime[j] && endSection > startTime[j]) cnt++;
                else if (startSection <= endTime[j] && endSection > endTime[j]) cnt++;
                else if (startSection >= startTime[j] && endSection <= endTime[j]) cnt++;
            }
            ans = Math.max(cnt, ans);
        }

        return ans;
    }

    private void getTimes(String[] lines, int[] startTime, int[] endTime) {
        for (int i = 0; i < lines.length; i++) {
            int end = 0;
            String[] log = lines[i].split(" ");
            int process = (int) Double.parseDouble(log[2].substring(0, log[2].length() - 1)) * 1000;
            String[] startLog = log[1].split(":");
            end += Integer.parseInt(startLog[0]) * 60 * 60 * 1000;
            end += Integer.parseInt(startLog[1]) * 60 * 1000;
            end += (int) Double.parseDouble(startLog[2]) * 1000;

            startTime[i] = end - process + 1;
            endTime[i] = end;
        }
    }

    public static void main(String[] args) {
        String[] strings = {
                "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"
        };
        Solution solution = new Solution();

        System.out.println(solution.solution(strings));
    }
}
/*
75597071
75597053
75597500
75597648
75598180
75598999
75599161
75598439
75600586
75599447
 */
