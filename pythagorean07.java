import java.util.*;
public class pythagorean07 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		for (int b = 2; b <= Integer.MAX_VALUE; b+=2) {
			double cDouble = Math.sqrt(a*a+b*b);
			if (cDouble % 1.0 == 0) {
				int c = (int) cDouble;
				if(areCoprime(a, b, c)) {
					System.out.println(a + " " + b + " " + c);
				}				
			}
		}
	}

	public static boolean areCoprime(int a, int b, int c) {
		ArrayList<Integer> aFactors = getFactors(a);
		ArrayList<Integer> bFactors = getFactors(b);
		ArrayList<Integer> cFactors = getFactors(c);
		for (int i = 0; i < aFactors.size(); i++) {
			if (bFactors.contains(aFactors.get(i)) && cFactors.contains(aFactors.get(i)))
				return false;
		}
		return true;
	}

	public static ArrayList<Integer> getFactors(int num) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for(int i = 2; i <= num; i++) {
			if(num % i == 0) {
				factors.add(i);
			}
		}
		return factors;
	}
}