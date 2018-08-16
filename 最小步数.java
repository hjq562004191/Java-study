package ACM;

import java.util.Scanner;

public class 最小步数 {

    static int x1;
    static int y1;
    static int min = 999;
    static int[][] map = {
            {1,1,1,1,1,1,1,1,1},
            {1,0,0,1,0,0,1,0,1},
            {1,0,0,1,1,0,0,0,1},
            {1,0,1,0,1,1,0,1,1},
            {1,0,0,0,0,1,0,0,1},
            {1,1,0,1,0,1,0,0,1},
            {1,1,0,1,0,1,0,0,1},
            {1,1,0,1,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1}
    };
    static int[][] map1 = {
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
    };

    public static void dfs(int x,int y,int step){

        if (x1 == x && y1 == y ){
            if (step < min){
                min = step;
            }
        }
        if (map[x][y] == 1){
            return;
        }
        if (map1[x][y] == 0){
            map1[x][y] = 1;
            dfs(x+1,y,step+1);
            dfs(x-1,y,step+1);
            dfs(x,y+1,step+1);
            dfs(x,y+1,step+1);
            map1[x][y] = 0;
        }

    }

    public static void main(String[] args) {
        int x0,y0;
        int step;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n--!=0) {
            step = 0;
            x0 = scanner.nextInt();
            y0 = scanner.nextInt();
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            if (x0 == x1 && y0 == y1){
                System.out.println(step);
                return;
            }
            dfs(x0,y0,step);
            System.out.println(min);
        }

    }
}
