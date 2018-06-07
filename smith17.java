import java.util.*;

public class smith17 {

    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int first = scan.nextInt();
      int last = scan.nextInt();
      if(first < last) {
        for (int n = first; n <= last; n++) {
            List<Integer> factors = primeFactors(n);
            if (factors.size() > 1) {
                int sum = sumDigits(n);
                for (int f : factors)
                    sum -= sumDigits(f);
                if (sum == 0)
                    System.out.println(n);
            }
        }
      }else{
        for (int n = last; n <= first; n++) {
            List<Integer> factors = primeFactors(n);
            if (factors.size() > 1) {
                int sum = sumDigits(n);
                for (int f : factors)
                    sum -= sumDigits(f);
                if (sum == 0)
                    System.out.println(n);
            }
        }
      }

    }

    static List<Integer> primeFactors(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; n % i == 0; n /= i)
            result.add(i);

        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                result.add(i);
                n /= i;
            }
        }

        if (n != 1)
            result.add(n);

        return result;
    }

    static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
}
