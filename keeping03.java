import java.lang.*;
import java.util.*;
import java.io.*;

class keeping03{

  public static <T> void p(T arr)
  {
    // System.out.print(arr);
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    int b = scan.nextInt();
    p("Inputs: " + a + " " + b + "\n");
    if(isWinning(a, b, 1, 0)==1) {
      System.out.println("Crow Wins!");
    }else{
      System.out.println("Laughead Wins!");
    }
  }

  // c = 1 -> Crow
  // c = -1 -> Laughead
  public static int isWinning(int a, int b, int c, int l) {
    for(int z = 0; z < l; z++) {
      p("\t");
    }
    p(a+" "+b+": "+c+"\n");
    if(a==b || a==0 || b==0) {
      return c;
    }

    if(a>b) {
      if(a%b == 0) {
        return c;
      }

      int factors[] = new int[(a-(a%b))/b];
      for (int i = factors.length; i >= 1; i--) {
        factors[i-1] = isWinning((a-(b*i)), b, c*-1, l+1);
        if(c==1 && factors[i-1]==1) {
          for(int z = 0; z < l; z++) {
            p("\t");
          }
          p(1+"\n");
          return 1;
        }

      }
      if(c==-1&&!contains(factors, -1)) {
        for(int z = 0; z < l; z++) {
          p("\t");
        }
        p(1+"\n");
        return 1;
      }

      for(int z = 0; z < l; z++) {
        p("\t");
      }
      p(-1+"\n");
      return -1;
    }

    if(a<b) {
      if(b%a == 0) {
        return c;
      }

      int factors[] = new int[(b-(b%a))/a];
      // for(int z = 0; z < l; z++) {
      //   p("\t");
      // }
      // p(b+" "+a+": "+c+"\n");
      for (int i = factors.length; i >= 1; i--) {
        factors[i-1] = isWinning((b-(a*i)), a, c*-1, l+1);
        if(c==1 && factors[i-1]==1) {
          for(int z = 0; z < l; z++) {
            p("\t");
          }
          p(1+"\n");
          return 1;
        }
      }
      if(c==-1&&!contains(factors, -1)) {
        for(int z = 0; z < l; z++) {
          p("\t");
        }
        p(1+"\n");
        return 1;
      }
      for(int z = 0; z < l; z++) {
        p("\t");
      }
      p(-1+"\n");
      return -1;
    }

    return -1;
  }

  public static boolean contains(int arr[], int val) {
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] == val) {
        return true;
      }
    }
    return false;
  }
}
