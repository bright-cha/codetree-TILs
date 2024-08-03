import java.util.Scanner;

public class Main {
    public static final int DIR_NUM = 4;
    public static final int MAX_N = 50;
    
    public static int n;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int[][] nextGrid = new int[MAX_N][MAX_N];
    public static int[][] temp = new int[MAX_N][MAX_N];
    
    public static boolean inBombRange(int x, int y, int centerX, int centerY, int bombRange) {
        return (x == centerX || y == centerY) && 
               Math.abs(x - centerX) + Math.abs(y - centerY) < bombRange;
    }
    
    public static void bomb(int centerX, int centerY) {
        // Step1. nextGrid 값을 0으로 초기화합니다.
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                nextGrid[i][j] = 0;
    
        // Step2. 폭탄이 터질 위치는 0으로 채워줍니다.
        int bombRange = grid[centerX][centerY];
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(inBombRange(i, j, centerX, centerY, bombRange))
                    grid[i][j] = 0;
        
        // Step3. 폭탄이 터진 이후의 결과를 nextGrid에 저장합니다.
        for(int j = 0; j < n; j++) {
            int nextRow = n - 1;
            for(int i = n - 1; i >= 0; i--) {
                if(grid[i][j] > 0)
                    nextGrid[nextRow--][j] = grid[i][j];
            }
        }
        
        // Step4. grid로 다시 값을 옮겨줍니다.
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = nextGrid[i][j];
    }
    
    
    public static void saveGrid() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                temp[i][j] = grid[i][j];
    }
    
    public static void loadGrid() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = temp[i][j];
    }
    
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    
    public static boolean meetTheCondition(int x, int y, int nx, int ny) {
        return inRange(nx, ny) && (grid[x][y] > 0) && grid[x][y] == grid[nx][ny];
    }
    
    public static int calc() {
        int cnt = 0;
        for(int x = 0; x < n; x++)
            for(int y = 0; y < n; y++) {
                int[] dx = new int[]{-1, 1, 0, 0};
                int[] dy = new int[]{0, 0, 1, -1};
                
                for(int k = 0; k < 4; k++) {
                    int nx = x + dx[k], ny = y + dy[k];
                    if(meetTheCondition(x, y, nx, ny))
                        cnt++;
                }
            }
        
        // 중복되어 2번씩 count되므로
        // 2로 나누어줍니다.
        return cnt / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int ans = 0;
        
        // 각 위치에 대해 진행해보고
        // 그 중 최대 만족 횟수를 구합니다.
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) {
                saveGrid();
                bomb(i, j);
                ans = Math.max(ans, calc());
                loadGrid();
            }
        
        System.out.print(ans);
    }
}