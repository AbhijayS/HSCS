import java.lang.*;
import java.util.*;
import java.io.*;

class remaining06{

  public static <T> void p(T arr)
  {
    System.out.print(arr);
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for(int i = 1; i < N; i++){
      numbers.add(i);
    }
    ArrayList<Integer> board = new ArrayList<Integer>();
    for(int a = 0; a < numbers.size(); a++){
      for(int b = 0; b < numbers.size(); b++){
        if(a!=b){
          int remaining = Math.abs(a-b);
          if(!board.contains(remaining)){
            p(remaining+"\n");
            board.add(remaining);
          }
        }
      }
    }
    long result = 0;
    for(int i = 0; i < board.size(); i++){
      result+=board.get(i);
    }
    p("Result: "+result+"\n");
  }
}
