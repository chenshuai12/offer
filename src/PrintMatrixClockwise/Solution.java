package PrintMatrixClockwise;

public class Solution {

    public void printMatrix(int[][] matrix){
        if(matrix == null || matrix.length <= 0){
            return;
        }
        printMatrixInCricle(matrix,0);
    }

    private void printMatrixInCricle(int[][] matrix, int start) {
        int row = matrix.length;
        int col = matrix[0].length;

        int endX = col - 1 - start;
        int endY = row - 1 - start;

        // 仅一行
        if (endY == start){
            for (int i = start; i <= endX; i++){
                System.out.println(matrix[start][i] + " ");
            }
            return;
        }

        // 仅一列
        if (endX == start){
            for (int i = start; i <= endY; i++){
                System.out.println(matrix[i][start] + " ");
            }
            return;
        }

        // 打印边界
        for (int i = start; i <= endX; i++){
            System.out.println(matrix[start][i] + " ");
        }
        for (int i = start + 1; i <= endY; i++){
            System.out.println(matrix[i][endX] + " ");
        }
        for (int i = endX -1;i >= start; i--){
            System.out.println(matrix[endY][i] +  " ");
        }
        for (int i = endY - 1; i >= start + 1; i--){
            System.out.println(matrix[i][start] + " ");
        }

        // 继续打印更内部的矩阵，令start+1
        printMatrixInCricle(matrix,start + 1);
    }

    public static void main(String[] args) {
        Solution demo = new Solution();
        int[][] a= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        demo.printMatrix(a);
    }
}
