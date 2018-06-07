import java.util.*;

class dinner04 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int d = scan.nextInt();
    int s = scan.nextInt();
    List<Integer> arr = new ArrayList<Integer>();
    double average = 0;
    // int count = 0;
    for(int i = 0; i<n; i++){
      int num = scan.nextInt();
      average += num;
      arr.add(num);
      // count++;
    }
    average = average/n;
    double min = Double.MAX_VALUE;
    int d1 = 0;
    for(int i = 0; i<d; i++){
      //System.out.println(arr.get(i));
      if(Math.abs(average - arr.get(i))<min){
        d1 = arr.get(i);
        min = Math.abs(average - arr.get(i));
      }else if (Math.abs(average-arr.get(i)) == min)
      {
        if(arr.get(i) < d1)
        {
          d1 = arr.get(i);
        }
      }
    }

    min = Integer.MAX_VALUE;
    int s1 = 0;
    for(int a = d; a<d+s ;a++){
      //System.out.println(arr.get(a));
      if(Math.abs(average - arr.get(a))<min){
        s1 = arr.get(a);
        min = Math.abs(average - arr.get(a));
      }else if(Math.abs(average - arr.get(a)) == min) {

        if(arr.get(a) < s1) {
          s1 = arr.get(a);
        }
      }
    }
    System.out.println(d1);
    System.out.println(s1);
  }
}
