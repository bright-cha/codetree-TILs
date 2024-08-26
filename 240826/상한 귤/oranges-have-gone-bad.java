import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Pair { 
    int x, y;
    public Pair(int x, int y) { 
        this.x = x; 
        this.y = y; 
    } 
}

public class Main {
    public static final int DIR_NUM = 4;
    public static final int MAX_N = 100;
    
    // 전역 변수 선언:
    public static int n, k;
    
    public static int[][] a = new int[MAX_N][MAX_N];
    
    public static ArrayList<Pair> sPos = new ArrayList<>();
    
    // bfs에 필요한 변수들 입니다.
    public static Queue<Pair> q = new LinkedList<>();
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    public static int[][] step = new int[MAX_N][MAX_N]; // step[i][j] : 
                            // (i, j) 지점에 있는 귤이 
                            // 최초로 상하게 되는 시간을 기록합니다.
    
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    
    // 격자를 벗어나지 않으면서, 해당 위치에 귤이 놓여있고, 아직 방문한 적이 없는 곳이라면
    // 지금 이동하는 것이 최초로 해당 귤을 상하게 하는 것이므로 가야만 합니다. 
    public static boolean canGo(int x, int y) {
        return inRange(x, y) && a[x][y] > 0 && !visited[x][y];
    }
    
    // queue에 새로운 위치를 추가하고
    // 방문 여부를 표시해줍니다.
    // 상하게 되는 시간 값도 갱신해줍니다.
    public static void push(int nx, int ny, int newStep) {
        q.add(new Pair(nx, ny));
        visited[nx][ny] = true;
        step[nx][ny] = newStep;
    }
    
    // bfs를 통해 각 칸마다 최초로 상하게 되는 시간을 구합니다.
    public static void BFS() {
        // queue에 남은 것이 없을때까지 반복합니다.
        while(!q.isEmpty()) {
            // queue에서 가장 먼저 들어온 원소를 뺍니다.
            Pair currPos = q.poll();
            int x = currPos.x, y = currPos.y;
    
            int[] dx = new int[]{-1, 1, 0, 0};
            int[] dy = new int[]{0, 0, -1, 1};
    
            // queue에서 뺀 원소의 위치를 기준으로 4방향을 확인해봅니다.
            for(int dir = 0; dir < DIR_NUM; dir++) {
                int nx = x + dx[dir], ny = y + dy[dir];
    
                // 아직 방문한 적이 없으면서 갈 수 있는 곳이라면
                // 새로 queue에 넣어줍니다.
                if(canGo(nx, ny))
                    // 시간은 이전 시간에 1이 더해지게 됩니다. 
                    push(nx, ny, step[x][y] + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        k = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] == 2)
                    sPos.add(new Pair(i, j));
            }
        
        // 처음 상해있던 귤들을
        // 전부 queue에 넣어놓고 시작합니다.
        // 이는 각 칸에 있는 신선한 귤에 대해
        // 가장 가까이에 있던 상한 귤로부터
        // 최초로 상하게 되는 시간을
        // 단 한번의 BFS로 가능하게끔 합니다.
        for(int i = 0; i < (int) sPos.size(); i++)
            push(sPos.get(i).x, sPos.get(i).y, 0);
        
        BFS();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(a[i][j] == 0)
                    System.out.print(-1 + " ");
                else {
                    if(!visited[i][j])
                        System.out.print(-2 + " ");
                    else
                        System.out.print(step[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}