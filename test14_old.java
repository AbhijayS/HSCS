import java.lang.*;
import java.util.*;
import java.io.*;
//.*.-./41.268-.814+55.+.106/40.449/0.2*139.54*64.
class test14{

  public static <T> void p(T arr)
  {
    System.out.print(arr);
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();
    // Scanner forIn = new Scanner(input);
    // p(forIn.nextDouble()+"\n");
    System.out.printf("%.3f\n", solve(input));
  }

  static double solve(String equation) {
    double result = 0.0;
    String noMinus = equation.replace("-", "+-");
    String[] byPluses = noMinus.split("\\+");

    for (String multipl : byPluses) {
      String[] byMultipl = multipl.split("\\*");
      double multiplResult = 1.0;
      for (String operand : byMultipl) {
          if (operand.contains("/")) {
              String[] division = operand.split("\\/");
              double divident = Double.parseDouble(division[0]);
              for (int i = 1; i < division.length; i++) {
                  divident /= Double.parseDouble(division[i]);
              }
              multiplResult *= divident;
          } else {
              multiplResult *= Double.parseDouble(operand);
          }
      }
      result += multiplResult;
    }
    return result;
  }
}
