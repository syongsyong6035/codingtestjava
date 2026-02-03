package _20260203;

/*문제 설명
지나다니는 길을 'O', 장애물을 'X'로 나타낸 직사각형 격자 모양의 공원에서 로봇 강아지가 산책을 하려합니다. 산책은 로봇 강아지에 미리 입력된 명령에 따라 진행하며, 명령은 다음과 같은 형식으로 주어집니다.

    ["방향 거리", "방향 거리" … ]
예를 들어 "E 5"는 로봇 강아지가 현재 위치에서 동쪽으로 5칸 이동했다는 의미입니다. 로봇 강아지는 명령을 수행하기 전에 다음 두 가지를 먼저 확인합니다.

주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
위 두 가지중 어느 하나라도 해당된다면, 로봇 강아지는 해당 명령을 무시하고 다음 명령을 수행합니다.
공원의 가로 길이가 W, 세로 길이가 H라고 할 때, 공원의 좌측 상단의 좌표는 (0, 0), 우측 하단의 좌표는 (H - 1, W - 1) 입니다.*/
public class Park {
    public int[] solution(String[] park, String[] routes) {
      int[] statusX = {1, -1};
      int counti;
      int currentX = 0;
      int currentY = 0;

      for(int i = 0 ; i < park.length ; i++){
        if(park[i].indexOf("S") != -1){
          currentX = park[i].indexOf("S");
          currentY = i;
          break;
        }
      }


      for(String route : routes){
        String[] direction = route.split(" ");
        counti = Integer.parseInt(direction[1]);

        int tempX = currentX;
        int tempY = currentY;
        boolean isOk = true;


        for(int j = 0; j < counti; j++) {
          if(direction[0].equals("E")) tempX += statusX[0];
          else if(direction[0].equals("S")) tempY += statusX[0];
          else if(direction[0].equals("N")) tempY += statusX[1];
          else if(direction[0].equals("W")) tempX += statusX[1];

          if(tempX < 0 || tempX >= park[0].length() || tempY < 0 || tempY >= park.length || park[tempY].charAt(tempX) == 'X') {
            isOk = false;
            break;
          }
        }
        if(isOk) {
          currentX = tempX;
          currentY = tempY;
        }
      }


      return new int[]{currentY, currentX};
    }

}
