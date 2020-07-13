package Soma;

import java.util.*;

public class Practice {


    public static void main(String[] args) {


        int[] arr = {0,2,2,5,6,7,8,1,2,4,5,6};

        Map<String,Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);

        //map에서 값있으면 +1 없으면 새로추가(Map 초기화 할때 디폴트 이용하는것)
//        map.put(word,map.getOrDefault(word,0)+1);

//        Map<Character, Integer> map = new HashMap<>();
//        str.chars().forEach(e -> map.put((char) e, map.getOrDefault((char) e, 0) + 1));

        //array 초기화
//        boolean[] flag = new boolean[2];
//        Arrays.fill(flag, false);

        // map의 key, value 접근하는
//        for(Map.Entry<String,Integer> entry : map.entrySet()){
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
//        for(String key : map.keySet()){
//            int value = map.get(key);
//            System.out.println(value);
//        }


        //리스트 sort custom
//        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                int comparision = (o1.getValue() - o2.getValue()) * -1;
//                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
//            }
//        });

        //우선순위큐 커스텀
//        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
////                return o1-o2; //-> 오름차순으로 리턴
////                return o2-o1; //-> 내림차순으로 리턴
//            }
//        });
//
//        PriorityQueue<int[]> pq = new PriorityQueue<>(
//                (a,b) -> b[0] - a[0]
//        );

        //BFS 예시
//        void search(Node root) {
//            Queue queue = new Queue();
//            root.marked = true; // (방문한 노드 체크)
//            queue.enqueue(root); // 1-1. 큐의 끝에 추가
//
//            // 3. 큐가 소진될 때까지 계속한다.
//            while (!queue.isEmpty()) {
//                Node r = queue.dequeue(); // 큐의 앞에서 노드 추출
//                visit(r); // 2-1. 큐에서 추출한 노드 방문
//                // 2-2. 큐에서 꺼낸 노드와 인접한 노드들을 모두 차례로 방문한다.
//                foreach (Node n in r.adjacent) {
//                    if (n.marked == false) {
//                        n.marked = true; // (방문한 노드 체크)
//                        queue.enqueue(n); // 2-3. 큐의 끝에 추가
//                    }
//                }
//            }
//        }

        //DFS 예시
//        void search(Node root) {
//            if (root == null) return;
//            // 1. root 노드 방문
//            visit(root);
//            root.visited = true; // 1-1. 방문한 노드를 표시
//            // 2. root 노드와 인접한 정점을 모두 방문
//            for each (Node n in root.adjacent) {
//                if (n.visited == false) { // 4. 방문하지 않은 정점을 찾는다.
//                    search(n); // 3. root 노드와 인접한 정점 정점을 시작 정점으로 DFS를 시작
//                }
//            }
//        }

        //String DFS 예시
//        private static int DFS(String path, tring tiles) {
//
//            if (!set.contains(path)) {
//                if (path != "") set.add(path);
//                for (int i = 0; i < tiles.length(); i++) {
//
//                    DFS(path.concat(Character.toString(tiles.charAt(i))), tiles.substring(0, i) + tiles.substring(i + 1));
//
//                }
//            }
//            return set.size();
//        }

        //string 합치기
//        StringBuilder sb = new StringBuilder();
//        sb.append("Hello ").append("Java!");

        //String replace
//        String a = "무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세 ";
////replace([기존문자],[바꿀문자])
//        a= a.replace("대한", "민국");
//        System.out.println(a);
//결과값 : 무궁화 삼천리 화려강산 민국사람 민국으로 길이 보전하세


            //String <-> CharArray
//        String temp = "캐릭터 변환하기";
//        char[] array = temp.toCharArray();
//        String.valueOf(array)


//        - char charAt(int index)
//        지정된 인덱스의 한 문자를 반환합니다.
//
//        - int compareTo(String anotherString)
//        두 문자열의 사전적 우선 순위 비교 입니다.

//        - int compareToIgnoreCase(String str)
//        대소문자를 구분하지 않는 사전적 비교 입니다.
//
//        - boolean contains(CharSequence s)
//        문자열을 포함하고 있는지 확인합니다.
//
//        - boolean endsWith(String suffix)
//        문자열의 끝이 인자로 주어진 문자열인지 확인합니다.
//
//        - boolean equals(Object anObject)
//        같은 내용의 문자열인지 비교합니다.

//        - boolean equalsIgnoreCase(String anotherString)
//        대소문자를 구분하지 않고 비교합니다.
//
//        - int indexOf(int ch)
//        인자로 주어진 문자가 있는 위치를 반환합니다. 없으면 음수를 반환합니다.
//
//        - int lastIndexOf(int ch)
//        인자로 주어진 문자가 마지막으로 나타난 위치를 반환합니다. 없으면 음수를 반환합니다.
//
//        - boolean matches(String regex)
//        인자로 주어진 정규식에 매치되는지 확인합니다.
//
//        - String replace(char oldChar, char newChar)
//        문자열에서 첫번째 인자의 문자를 두번째 인자의 문자로 바꿉니다.
//
//        - String[] split(String regex)
//        정규식에 매치되는 부분을 구분자로 문자열을 분할 합니다.
//
//        - String[] split(String regex, int limit)
//        문자열 분할시 두번째 인자로 마지막 빈 요소 처리 및 분할할 갯수를 지정합니다.
//
//        - boolean startsWith(String prefix)
//        인자로 주어진 문자열로 시작하는지 확인합니다.
//
//        - String substring(int beginIndex)
//        문자열에서 인자로 주어인 인덱스 이후의 문자열을 추출합니다.

//         - String substring(int beginIndex, int endIndex)
//        인자로 주어진 인덱스 사이의 문자열을 반환합니다.

//        - static String valueOf(int i)
//        인자로 주어진 타를 타입의 데이터를 문자열로 변경하는 정적 메소드 입니다. 모든 원시 타입에 대해 오버로딩된 메소드가 있습니다


        //SubString 예
        //1. 마지막 3글자 자르기
//        String str = "ABCDEFG";
//        String result = str.substring(str.length()-3, str.length());
//        System.out.println(result)
        //결과값EFG



//2. 특정문자 이후의 문자열 제거
//        String str = "ABCD/DEFGH";
//        String result = str.substring(str.lastIndexOf("/")+1);
//        System.out.println(result);
//결과값 DEFGH



//3. 특정단어(부분)만 자르기
//        String str = "바나나 : 1000원, 사과 : 2000원, 배 : 3000원";
//        String target = "사과";
//        int target_num = str.indexOf(target);
//        String result; result = str.substring(target_num,(str.substring(target_num).indexOf("원")+target_num));
//        System.out.println(result+"원");
//결과값 : 사과 : 2000원


        //Split 예
        //1. 쉼표(,)로 문자열 잘라서 배열에 넣기
//        String str = "A,B,C,D";
//        String[] array = str.split(",");

//출력
//        for(int i=0;i<array.length;i++) {
//            System.out.println(array[i]);
//        }

//결과값
//array[0] = A
//array[1] = B
//array[2] = C
//array[3] = D

//2. 공백(" ")으로 문자열 잘라서 배열에 넣기
//        String str = "동해물과 백두산이 마르고 닳도록 하나님이 보우하사 우리나라 만세";
//        String[] array = str.split(" ");

//출력
//        for(int i=0;i<array.length;i++) {
//            System.out.println(array[i]);
//        }

//결과값
//array[0] = 동해물과
//array[1] = 백두산이
//array[2] = 마르고
//array[3] = 닳도록
//array[4] = 하나님이
//array[5] = 보우하사
//array[6] = 우리나라
//array[7] = 만세

//3. regex 이용
//        //"-1/2+1/2"
//        String[] inputs = expression.split("(?=[-+])"); // split
//        //input[0] =  -1/2 , input[1] = +1/2
    }

}
