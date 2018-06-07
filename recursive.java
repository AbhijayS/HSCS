import java.lang.*;
import java.util.*;
import java.io.*;

class recursive{

  public static <T> void p(T arr)
  {
    System.out.print(arr);
  }

  public static void main(String[] args) {
    p("Hello World!\n");
    p(factorial(0)+"\n");
  }

  static int factorial(int start){
    int out = 1;
    for(int i = start; i>=1; i--){
      out*=i;
    }
    return out;
  }
}
