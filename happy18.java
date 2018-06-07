import java.util.*;

class happy18 {

  public static <T> void p(T arr)
  {
    System.out.print(arr);
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int first = scan.nextInt();
    int last = scan.nextInt();
    // p("First: " + first + "\n");
    // p("Last: " + last + "\n");
    if(first < last) {
      while(first!=last+1) {
        if(isHappy(first)) {
          System.out.println(first);
        }
        first++;
      }

    }else{
      while(last!=first+1) {
        if(isHappy(last)) {
          System.out.println(last);
        }
        last++;
      }
    }
  }

  public static int getSum(int i){
    int sum = 0;
    while(i>0){
      sum+=(i%10)*(i%10);
      i = i/10;
    }
    return sum;
  }

  public static boolean isHappy(int i){
    List<Integer> arr = new ArrayList<Integer>();
    while(!arr.contains(i)){
      if(i == 1){
        return true;
      }
      arr.add(i);
      i = getSum(i);
    }
    return false;
  }
}
