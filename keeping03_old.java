import java.lang.*;
import java.util.*;
import java.io.*;

class keeping03{

  public static <T> void p(T arr)
  {
    System.out.print(arr);
  }

  public static void main(String[] args) {
    // p("Hello World!\n");
    Scanner scan = new Scanner(System.in);
    int n1 = scan.nextInt();
    int n2 = scan.nextInt();
    p("1: " + n1 + "; 2: " + n2+"\n");
    int turn = 1;
    boolean v = false;
    // p("Highest: " + getHighestMultipleLessThanNum(n1, n2)+"\n");
    while(n1!=0 && n2!=0) {
      // p("Turn: " + turn+"\n");
      v = true;
      if(n1>n2) {
        n1 -= getHighestMultipleLessThanNum(n2, n1);
      }else{
        n2-= getHighestMultipleLessThanNum(n1, n2);
      }
      p(n1 + "; " + n2+"\n");
      turn*=-1;
    }
    if(v) {
      turn*=-1;
    }
    // p("Won: " + turn +"\n");
    if(turn == 1) {
      System.out.println("Crow Wins!");
    }else{
      System.out.println("Laughead Wins!");
    }

  }

  public static int getHighestMultipleLessThanNum(int f, int l) {
    int count = 2;
    int temp = f;
    while(temp <= l) {
      temp = f*count;
      count+=1;
    }
    return f*(count-2);
  }
}
