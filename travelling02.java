import java.lang.*;
import java.util.*;
import java.io.*;

class cell {
  int x;
  int y;
  int dis;
  public cell(int x, int y, int dis) {
    this.x = x;
    this.y = y;
    this.dis = dis;
  }
}

class travelling02{

  public static <T> void p(T arr)
  {
    System.out.print(arr);
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int knightPos[] = {1, 1};
    int targetPos[] = {N, N};
    int steps = minStepToReachTarget(knightPos, targetPos, N);
    if(steps!=-1) {
      System.out.println(steps);
    }
  }
  public static boolean isInside(int x, int y, int N) {
    if (x >= 1 && x <= N && y >= 1 && y <= N) {
      return true;
    }
    return false;
  }

  public static int minStepToReachTarget(int knightPos[], int targetPos[], int N) {
    int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
    int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};

    Queue<cell> q = new LinkedList<cell>();
    q.add(new cell(knightPos[0], knightPos[1], 0));

    // cell t;
    int x;
    int y;
    boolean visit[][] = new boolean[N+1][N+1];

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        visit[i][j] = false;
      }
    }
    visit[knightPos[0]][knightPos[1]] = true;

    while(!q.isEmpty()) {
      cell t = q.peek();
      q.poll();

      if(t.x == targetPos[0] && t.y == targetPos[1]) {
        return t.dis;
      }

      for(int i = 0; i < 8; i++) {
        x = t.x + dx[i];
        y = t.y + dy[i];

        if(isInside(x, y, N) && !visit[x][y]) {
          visit[x][y] = true;
          q.add(new cell(x, y, t.dis+1));
        }
      }
    }
    return -1;
  }

}


// // C++ program to find minimum steps to reach to
// // specific cell in minimum moves by Knight
// #include <bits/stdc++.h>
// using namespace std;
//
// // structure for storing a cell's data
// struct cell
// {
//     int x, y;
//     int dis;
//     cell() {}
//     cell(int x, int y, int dis) : x(x), y(y), dis(dis) {}
// };
//
//
// public static boolean isInside(int x, int y, int N) {
//   if (x >= 1 && x <= N && y >= 1 && y <= N) {
//     return true;
//   }
//   return false;
// }
//
// // Utility method returns true if (x, y) lies
// // inside Board
// bool isInside(int x, int y, int N)
// {
//     if (x >= 1 && x <= N && y >= 1 && y <= N)
//         return true;
//     return false;
// }
//
// // Method returns minimum step to reach target position
// int minStepToReachTarget(int knightPos[], int targetPos[],
//                                                 int N)
// {
//     // x and y direction, where a knight can move
//     int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
//     int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};
//
//     // queue for storing states of knight in board
//     queue<cell> q;
//
//     // push starting position of knight with 0 distance
//     q.push(cell(knightPos[0], knightPos[1], 0));
//
//     cell t;
//     int x, y;
//     bool visit[N + 1][N + 1];
//
//     // make all cell unvisited
//     for (int i = 1; i <= N; i++)
//         for (int j = 1; j <= N; j++)
//             visit[i][j] = false;
//
//     // visit starting state
//     visit[knightPos[0]][knightPos[1]] = true;
//
//     // loop untill we have one element in queue
//     while (!q.empty())
//     {
//         t = q.front();
//         q.pop();
//
//         // if current cell is equal to target cell,
//         // return its distance
//         if (t.x == targetPos[0] && t.y == targetPos[1])
//             return t.dis;
//
//         // loop for all reachable states
//         for (int i = 0; i < 8; i++)
//         {
//             x = t.x + dx[i];
//             y = t.y + dy[i];
//
//             // If reachable state is not yet visited and
//             // inside board, push that state into queue
//             if (isInside(x, y, N) && !visit[x][y]) {
//                 visit[x][y] = true;
//                 q.push(cell(x, y, t.dis + 1));
//             }
//         }
//     }
// }
//
// // Driver code to test above methods
// int main()
// {
//     int N = 30;
//     int knightPos[] = {1, 1};
//     int targetPos[] = {30, 30};
//     cout << minStepToReachTarget(knightPos, targetPos, N);
//     return 0;
// }
