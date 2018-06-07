import java.lang.*;
import java.util.*;
import java.util.ArrayList;
import java.io.*;

class boggle16{
  public static int N;
  public static Object[][][] mem;
  public static <T> void p(T arr)
  {
    // System.out.print(arr);
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    p(N+"\n");
    String[][] box = new String[N][N];
    mem = new Object[N][N][1];
    for(int i = 0; i < N; i++) {
      String in = scan.next();
      for(int j = 0; j < N; j++) {
        box[i][j]=in.substring(j, j+1);
        HashMap<String, ArrayList<String>> tmp = new HashMap<String, ArrayList<String>>();
        tmp.put(in.substring(j, j+1), new ArrayList<String>());
        mem[i][j][0]=tmp;
      }
    }

    print2DStringArr(box);
    p("\n==========================\n");
    ArrayList<String>words = new ArrayList<String>();
    //create a copy of box with marking for "locked" places so we never traverse them
    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
        ArrayList<String> toAdd = new ArrayList<String>();
        toAdd = findWords(box, i, j, "", 1, new ArrayList<String>());
        toAdd.removeAll(words);
        words.addAll(toAdd);
        p(words+"\n\n");
      }
    }

    String[]sorted = (String[])words.toArray(new String[words.size()]);
    Arrays.sort(sorted);
    sort(sorted, sorted.length);
    // p("Final:\n");
    // p(Arrays.toString(sorted)+"\n");
    // for(int i = 0; i < sorted.length; i++){
    //   System.out.println(sorted[i]);
    // }
    ArrayList<String> noReps = new ArrayList<String>();
    for(int i = 0; i < sorted.length; i++){
      if(!noReps.contains(sorted[i])) {
        noReps.add(sorted[i]);
      }
    }
    for(int i = 0; i < noReps.size(); i++){
      System.out.println(noReps.get(i));
    }
  }

  static ArrayList<String> findWords(String[][]mat, int x, int y, String prev, int rounds, ArrayList<String>prevSeen)
  {

    ArrayList<String> fromChild = new ArrayList<String>();
    ArrayList<int[]> next = findNext(x, y, mat);
    next = filterList(next, mat, prevSeen, (int)(mat[x][y].charAt(0)));
    // p("Next: " + next.size());
    printTabs(rounds-1);
    p(mat[x][y]+": ("+x+", "+y+")\n");
    printCoordinates(rounds, next);

    if(next.size()==0) {
      printTabs(rounds-1);
      p("Dead End\n");
      if((rounds>=3)) {
        fromChild.add(mat[x][y]);
      }
      return fromChild;
    }

    int size = next.size();
    ArrayList<String> newSeen = cloneArrayList(prevSeen);
    newSeen.add(mat[x][y]);

    for(int i = 0; i < size; i++) {
      int childX = next.get(i)[0];
      int childY = next.get(i)[1];
      ArrayList<String> childOld = (ArrayList<String>)(((HashMap<String, ArrayList<String>>) (mem[childX][childY][0])).get(mat[childX][childY])); //next child's saved data
      ArrayList<String> thisOld = (ArrayList<String>)(((HashMap<String, ArrayList<String>>) (mem[x][y][0])).get(mat[x][y])); //this node's saved data

      if(childOld.size() != 0) {
        p("HAS STUFF\n");
        for(int j = 0; j < childOld.size(); j++) {
          String tmp = mat[x][y]+childOld.get(j);
          if(((prev+tmp).length()) >=3){
            fromChild.add(tmp);
            thisOld.add(tmp);
          }
        }
      }else{
        ArrayList<String> child = findWords(mat, childX, childY, prev+mat[x][y], rounds+1, newSeen);

        for(int j = 0; j < child.size(); j++) {
          String tmp = mat[x][y]+child.get(j);
          thisOld.add(tmp);
        }

        // child.removeAll(fromChild);
        for(int j = 0; j < child.size(); j++) {
          String tmp = mat[x][y]+child.get(j);
          fromChild.add(tmp);
        }
        // if(child.size()!=output.size()){
        //   output=child;
        // }
        if((prev+mat[x][y]).length() >= 3) {
          fromChild.add(mat[x][y]);
          }
        }
      }
    }
    return fromChild;
  }

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

  static ArrayList<int[]> filterList(ArrayList<int[]>list, String[][]mat, ArrayList<String>prevSeen, int thresh) {
    int size = list.size();
    ArrayList<int[]> toReturn = new ArrayList<int[]>();
    for(int i = 0; i < size; i++) {
      // p("Checking: ");
      // p(prevSeen.contains(mat[list.get(i)[0]][list.get(i)[1]])+"\n");
      if(!prevSeen.contains(mat[list.get(i)[0]][list.get(i)[1]]) && (int)((mat[list.get(i)[0]] [list.get(i)[1]]).charAt(0)) > thresh) {
        // list.remove(i);
        int[]temp = new int[2];
        temp[0]=list.get(i)[0];
        temp[1]=list.get(i)[1];
        toReturn.add(temp);
      }
    }
    return toReturn;
  }

  static void print2DStringArr(String[][]arr) {
    for(int i= 0; i < arr.length; i++) {
      for(int j = 0;j < arr.length; j++) {
        p(arr[i][j]+" ");
      }
      p("\n");
    }
  }

  static void printCoordinates(int tabs, ArrayList<int[]>arr){
    for(int i = 0; i < arr.size(); i++){
      printTabs(tabs);
      p("("+arr.get(i)[0]+", "+arr.get(i)[1]+")\n");
    }
  }

  static void printTabs(int tabs){
    for(int i = 0; i < tabs; i++){
      p("\t");
    }
  }

  static void sort(String s[], int n)
  {
      for (int i=1 ;i<n; i++)
      {
          String temp = s[i];

          // Insert s[j] at its correct position
          int j = i - 1;
          while (j >= 0 && temp.length() < s[j].length())
          {
              s[j+1] = s[j];
              j--;
          }
          s[j+1] = temp;
      }
  }

  static ArrayList<String> cloneArrayList(ArrayList<String>arr){
    ArrayList<String> output = new ArrayList<String>();
    output.addAll(arr);
    return output;
  }

  static String cropString(String init, String param){
    p("Cropping: " + init +"; Found: "+init.indexOf(param.charAt(0))+"\n");
    return init.substring(init.indexOf(param.charAt(0)), init.length());
  }
}
