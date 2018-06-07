class cell {
  int x;
  int y;
  int dis;
  cell(int x, int y, int dis) {
    this.x = x;
    this.y = y;
    this.dis = dis;
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

  Queue<Object> q = new Queue<cell>();
  q.add(new cell(knightPos[0], knightPos[1], 0));

  cell t;
  int x;
  int y;
  boolean visit[N+1][N+1];

  for (int i = 1; i <= N; i++) {
    for (int j; j <= N; j++) {
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
}
