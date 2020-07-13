package Line;
/*
군데군데 손상된 도로가 있습니다. 이 도로를 적절하게 보수하여, 자동차 경주 대회를 열려고 합니다. 자동차 경주 대회가 열리려면, 손상되지 않은 최대한 긴 구간이 필요합니다. 아래는 도로의 손상된 부분을 0, 정상적인 부분을 1로 나타낸 예시입니다.

111011110011111011111100011111
만약 도로의 손상된 부분을 최대 3곳까지만 보수할 수 있는 재료가 있다면, 아래와 같이 도로를 보수하여 길이가 18인 정상 도로 구간을 만들 수 있습니다.

1110(111111111111111111)00011111
도로를 보수해서 만들 수 있는 가장 긴 정상 도로 구간의 길이를 구해주세요.

제한 사항
road는 도로의 상태를 나타냅니다.
road는 길이 1 이상 300,000 이하인 문자열입니다.
road는 0과 1로만 이루어져 있습니다.
도로의 손상된 부분을 0, 정상 부분은 1로 나타냅니다.
n은 보수 가능한 최대 횟수를 의미합니다.
n은 0 이상 300,000 이하인 자연수입니다.
만들 수 있는 가장 긴 정상 도로 구간의 길이를 return 하면 됩니다.
입출력 예
road	n	result
"111011110011111011111100011111"	3	18
"001100"	5	6
 */
public class Solution3 {
    public int solution(String road, int n) {
        int answer = -1;


        for(int i =0; i<road.length();i++)
        {
            int zero = n;
            int cnt = 0;
            for(int j =i; j<road.length();j++)
            {
                if(road.charAt(j) == '1')
                {
                    cnt++;
                }
                if(zero == 0 && road.charAt(j) == '0') break;
                if(road.charAt(j) == '0' && zero > 0){
                    zero--;
                    cnt++;
                }

            }
            answer = Math.max(answer,cnt);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        System.out.println(solution.solution(	"00001110001110101", 3));
    }
}
