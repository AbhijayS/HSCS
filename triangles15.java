import java.io.*;
import java.util.*;

class triangles15
{
    static long findNumberOfTriangles(int arr[])
    {
        int n = arr.length;
        Arrays.sort(arr);
        long count = 0;
        for (int i = n-3; i >= 0; --i)
        {
            int k = i + 2;

            for (int j = n-1; j >= i+1; --j)
            {
                while (k < n && arr[i] + arr[j] > arr[k])
                    ++k;
                count += k - j - 1;
            }
        }
        return count;
    }
    public static void main (String[] args)
    {
      Scanner scan = new Scanner(System.in);
      int N = scan.nextInt();
      int arr[] = new int[N];
      for(int i = 1; i <= arr.length; i++) {
        arr[i-1]=i;
      }
      System.out.println(findNumberOfTriangles(arr));
      // System.out.println(N);
    }
}
