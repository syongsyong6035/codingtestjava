package _20260218;
import java.util.*;

public class Schedules {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
      int answer = 0;

      for(int i = 0; i < schedules.length ; i++){
        int targetHour = schedules[i] / 100;
        int targetMinute = schedules[i] % 100;
        int limitTime = (targetHour * 60) + targetMinute + 10;

        boolean isSuccess = true;
        for(int j = 0 ; j < 7 ; j++){
          int currentDay = (startday + j - 1) % 7 + 1;
          if(currentDay == 6 || currentDay == 7){
            continue;
          }
          int logHour = timelogs[i][j] / 100;
          int logMinute = timelogs[i][j] % 100;
          int logTime = (logHour * 60) + logMinute;
          if (logTime > limitTime) {
            isSuccess = false;
            break;
          }

        }
        if (isSuccess) answer++;
      }
      return answer;

  }

}
