import java.lang.*;
import java.util.*;
import java.io.*;

class trail05{

  public static <T> void p(T arr)
  {
    System.out.print(arr);
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    if(n==3) {
      p(1+"\n");
    }else if(n%3 == 0) {
      p(n/3+"\n");
    }else{
      p(n+"\n");
    }

  }
}
