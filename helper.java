import java.util.*;
import java.io.*;

class helper{
  /*
    Finds the next location of movement on a 2D matrix in 8 directions.
    Returns all possible locations to move to in an ArrayList
  */
  static ArrayList<int[]> findNext(int x, int y, String[][]arr) {
    ArrayList<int[]> moves = new ArrayList<int[]>();
    for(int i = -1; i < 2; i++) {
      for(int j = -1; j < 2; j++) {
        // p((x+i)+" "+(y+j)+"\n");
        if(!(i==0&&j==0) && x+i >= 0 && y+j >=0 && x+i < arr.length && y+j < arr[0].length) {
          // p("Valid\n\n");
          int[]temp = new int[2];
          temp[0]=(x+i);
          temp[1]=(y+j);
          moves.add(temp);
        }else{
          // p("InValid\n\n");
        }
      }
    }
    return moves;
  }

}
