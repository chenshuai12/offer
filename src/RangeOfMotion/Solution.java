package RangeOfMotion;

public class Solution {

    // 记录可以到达的点的个数

    // public static int count = 0;

    public int count= 0;

    public int movingCount(int m, int n, int k){
        if (m <= 0 || n <= 0 || k < 0){
            return 0;
        }

        int row = 0;
        int col = 0;

        boolean visited[][] = new boolean[m][n];

        for (int i = 0; i < visited.length; i++){
            for (int j = 0; j < visited[0].length; j++){
                visited[i][j] = false;
            }
        }
        CalculateCount(row, col, k, m, n, visited);
        return count;
    }

    /**
     * 计算有多少可到达点。
     * @param row   当前行号
     * @param col   当前列号
     * @param k     k的设置
     * @param m     行号上限
     * @param n     列号上限
     */
    private void CalculateCount(int row, int col, int k, int m, int n, boolean[][] visited) {
        if (row >= 0 && col >= 0 && row <= m - 1 && col <= n - 1 && check(row,col,k) && !visited[row][col]) {
            this.count++;
            System.out.println("row: " + row + ",col:" + col);
            System.out.println("count is:" + count);
            visited[row][col] = true;
            CalculateCount(row + 1,col,k,m,n,visited);
            CalculateCount(row - 1,col,k,m,n,visited);
            CalculateCount(row,col + 1,k,m,n,visited);
            CalculateCount(row,col - 1,k,m,n,visited);
        }
    }

    private boolean check(int row, int col, int k) {
        int result = 0;
        while (row > 0){
            result += row % 10;
            row /= 10;
        }
        while (col > 0){
            result += col % 10;
            col /= 10;
        }

        if (result <= k){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(8,7 ,3));
    }
}
