package _20260226;
import java.util.*;

public class Participant {
  class Solution {
    public String solution(String[] participant, String[] completion) {
      int count = 0;
      String answer = "";
      Map<String, Integer> map = new HashMap<>();

      for(String complet : completion) map.put(complet, map.getOrDefault(complet, 0) + 1);

      for(int i = 0 ; i < participant.length ; i++){
        count = map.getOrDefault(participant[i], 0);
        if(count == 0){
          answer = participant[i];
          break;
        }else {
          map.put(participant[i], count - 1);
        }
      }


      return answer;

    }
  }

}
