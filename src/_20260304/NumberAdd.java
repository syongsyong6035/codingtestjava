package _20260304;
import java.util.*;

/*문제 설명
정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers의 길이는 2 이상 100 이하입니다.
numbers의 모든 수는 0 이상 100 이하입니다.*/

public class NumberAdd {

  class Solution {
    public int[] solution(int[] numbers) {
      int[] answer = {};
      List<Integer> list = new ArrayList<>();
      for(int i = 0 ; i < numbers.length ; i++){
        for(int j = i+1 ; j < numbers.length ; j++){
          if(!list.contains(numbers[i]+numbers[j])){
            list.add(numbers[i]+numbers[j]);
          }

        }
      }
      list.sort(null);
      answer = new int[list.size()];
      for(int i = 0 ; i < list.size() ; i++){
        answer[i] = list.get(i);
      }
      return answer;
    }
  }

}
