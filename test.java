import java.lang.*;
import java.util.*;
import java.io.*;

class test{

  public static <T> void p(T arr)
  {
    System.out.print(arr);
  }

  public static void main(String[] args) {
    ArrayList<String> a = new ArrayList<String>();
    ArrayList<String> b = new ArrayList<String>();

    b.add("a");
    b.add("b");
    b.add("c");
    System.out.println("A Before: "+a.toString());
    System.out.println("B Before: "+b.toString());
    b.removeAll(a);
    a.addAll(b);
    System.out.println("A After: "+a.toString());
    System.out.println("B After: "+b.toString());
  }
}
