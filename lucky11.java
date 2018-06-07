import java.lang.*;
import java.util.*;
import java.io.*;

class lucky11{

  public static <T> void p(T arr)
  {
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int init = scan.nextInt();
    init++;
    while(!equal(init))
    {
      init++;
    }
    System.out.println(init);
  }

  public static boolean equal(int n)
  {
    String str = Integer.toString(n);
    int f = i(str.charAt(0))+i(str.charAt(1))+i(str.charAt(2));
    int s = i(str.charAt(3))+i(str.charAt(4))+i(str.charAt(5));
    return (f==s);
  }

  public static int i(char s)
  {
    return Integer.parseInt(Character.toString(s));
  }

}
