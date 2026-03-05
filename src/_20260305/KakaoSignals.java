package _20260305;

/*

문제 설명
어떤 도로에 차량 신호등이 n개 있습니다. 모든 신호등은 항상 초록불 → 노란불 → 빨간불 순서로 반복되며, 각 신호의 지속 시간은 신호등마다 다릅니다. 시간은 1초부터 시작하며, 각 신호등은 처음에는 초록불 상태로 시작합니다.

이 도로에서는 가끔 정전이 일어나는데, 모든 신호등이 모두 노란불이 되면 정전이 발생한다는 사실이 밝혀졌습니다.

예를 들어 신호등이 2개이고, 각 신호등의 주기가 다음과 같다고 가정해 보겠습니다.

신호등	초록불	노란불	빨간불
1번	2초	1초	2초
2번	5초	1초	1초
신호등-1.drawio.png

위 그림과 같이 13초에 처음으로 두 신호등이 모두 노란불이 됩니다.

신호등 n개의 신호 주기를 담은 2차원 정수 배열 signals가 매개변수로 주어집니다. 모든 신호등이 노란불이 되는 가장 빠른 시각(초)을 return 하도록 solution 함수를 완성해 주세요. 만약 모든 신호등이 노란불이 되는 경우가 존재하지 않는다면 -1을 return 해주세요.
*/
public class KakaoSignals {

  class Solution {
    public int solution(int[][] signals) {
      int answer = 0;
      int currentCount = 0;
      Boolean isYellow = true;
      int t;
      while(true){

        for(int i = 0 ; i < signals.length ; i++){
          t = currentCount % (signals[i][0]+signals[i][1] + signals[i][2]);
          if(!(t > signals[i][0] && t <= (signals[i][1] + signals[i][0]))){
            isYellow = false;
            break;
          }
        }
        if(isYellow){
          return currentCount;

        }
        isYellow = true;
        currentCount++;
        if(currentCount > 100000000){
          return -1;

        }
      }
    }
  }

}
