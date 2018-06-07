import java.io.*;
import java.util.*;

class triangles2
{
    static int findNumberOfTriangles(int arr[])
    {
        int n = arr.length;
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < n-2; ++i)
        {
            int k = i + 2;

            for (int j = i+1; j < n; ++j)
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
      int arr[] = new int[scan.nextInt()];
      for(int i = 1; i <= arr.length; i++) {
        arr[i-1]=i;
      }
      System.out.println(Arrays.toString(arr));
      System.out.println(possibleTriangles(arr, arr.length));
    }

    static int possibleTriangles(int []arr, int N){

      // first sort the array
      Arrays.sort(arr);
      int count = 0;
      // loop for all 3
      // consecutive triplets
      for (int i = 0; i < N - 2; i++)
          // If triplet satisfies
          // triangle condition, break
          if (arr[i] + arr[i + 1] > arr[i + 2])
              count++;

      return count;
  }

}
