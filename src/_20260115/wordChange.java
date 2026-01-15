package _20260115;
import java.util.*;
/*문제 설명
두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.

1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
    2. words에 있는 단어로만 변환할 수 있습니다.
예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.

두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.*/
public class wordChange {
    boolean[] visited;
    String word;
    int wordIndex;
    class Node{
      String after;
      int su;
      int index;

      public Node(String after, int su, int index){
        this.after = after;
        this.su = su;
        this.index = index;
      }
    }
    public boolean isDiff(String str1, String str2){
      int diffCount = 0;
      for(int i = 0 ; i<str1.length() ; i++){

        if(str1.charAt(i) != str2.charAt(i)){
          diffCount++;
        }
      }
      if(diffCount == 1){
        return true;
      }
      return false;
    }
    public int solution(String begin, String target, String[] words) {
      int answer = 0;
      visited = new boolean[words.length];
      Queue<Node> queue = new LinkedList<>();
      queue.offer(new Node(begin, 0, -1));
      while(!queue.isEmpty()){
        Node node = queue.poll();
        word = node.after;
        answer = node.su;
        wordIndex = node.index;
        if (word.equals(target)) {
          return answer;
        }

        for(int i = 0 ; i<words.length ; i++){
          if(!visited[i] && isDiff(word, words[i])){
            queue.offer(new Node(words[i], answer+1, i));
            visited[i] = true;
          }
        }

      }
      return 0;

    }


}
