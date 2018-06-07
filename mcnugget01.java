import java.lang.*;
import java.util.*;
import java.io.*;

class mcnugget01{

  static int order[] = {20, 9, 6, 4};
  public static <T> void p(T arr)
  {
    System.out.print(arr);
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int input = scan.nextInt();
    if(input == 0) {
      System.out.println(0);
    }else{
      int boxes = findSum(0, input, 0);
      if(boxes == -1) {
        System.out.println("No McNuggets!");
      }else{
        System.out.println(boxes);
      }
    }
  }

  public static int findSum(int orderNum, int nuggets, int boxes) {
    for (int i = orderNum; i < order.length; i++) {

      if(nuggets < order[i]) {
        continue;
      }

      int mod = nuggets%order[i];
      int factor = (nuggets-mod)/order[i];

      for (int j = factor; j >= 1; j--) {
        mod = nuggets-(order[i]*j);
        if(mod == 0) {
          // p(j + " Boxes of " + order[i] + "\n");
          return boxes+j;
        }

        if(mod >= order[order.length-1]) {
          int temp = findSum(i+1, mod, boxes+j);
          if(temp != -1) {
            // p(j + " Boxes of " + order[i] + "\n");
            return temp;
          }
        }
      }
    }
    return -1;
  }
}
