package _20260115;
import java.util.*;

/*문제 설명
주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.

항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
모든 공항은 알파벳 대문자 3글자로 이루어집니다.
주어진 공항 수는 3개 이상 10,000개 이하입니다.
tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
주어진 항공권은 모두 사용해야 합니다.
만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.*/
public class TravelRoute {
    boolean isFinished = false;
    List<String> list = new ArrayList<>();
    public String[] solution(String[][] tickets) {
      String[] answer = {};
      boolean[] visited = new boolean[tickets.length];
      Arrays.sort(tickets, (o1,o2) -> {
        if (o1[0].equals(o2[0])) {
          return o1[1].compareTo(o2[1]);
        } else {
          return o1[0].compareTo(o2[0]);
        }
      });
      list.add("ICN");

      dfs(list, tickets, visited);
      answer = list.toArray(new String[0]);

      return answer;
    }
    void dfs(List<String> list, String[][] tickets, boolean[] visited){
      if(tickets.length == list.size()-1){

        isFinished = true;
        return;
      }
      for(int i = 0 ; i<tickets.length ; i++){
        if(!visited[i] && list.get(list.size()-1).equals(tickets[i][0])){
          list.add(tickets[i][1]);
          visited[i] = true;
          dfs(list, tickets, visited);
          if (isFinished) return;

          if (!isFinished) {
            list.remove(list.size() - 1);
            visited[i] = false;
          }
        }

    }
  }

}
