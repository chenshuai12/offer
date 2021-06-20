package PathInMatrix;

public class HasPath {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(matrix==null || matrix.length==0 || str==null || str.length==0 || matrix.length!=rows*cols || rows<=0 || cols<=0 || rows*cols < str.length) {
            return false ;
        }
        // 标志位，初始化为false
        boolean[] visited = new boolean[matrix.length];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                // 循环遍历二维数组，找到起点等于str第一个元素的值，再递归判断四周是否有符合条件的----回溯法
                if(hasPath(matrix,i,j,rows,cols,visited,str,0)){
                    return true;
                }
            }
        }
        return false;
    }

    // judge(初始矩阵，索引行坐标i，索引纵坐标j，矩阵行数，矩阵列数，待判断的字符串，字符串索引初始为0即先判断字符串的第一位)
    private boolean hasPath(char[] matrix,int i,int j,int rows,int cols,boolean[] flag,char[] str,int k){
        // 先根据i和j计算匹配的第一个元素转为一维数组的位置
        int index = i*cols+j;
        // 递归终止条件
        if(i<0 || j<0 || i>=rows || j>=cols || matrix[index] != str[k] || flag[index] == true)
            return false;
        // 若k已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可
        if(k == str.length-1)
            return true;
        // 要走的第一个位置置为true，表示已经走过了
        flag[index] = true;

        // 回溯，递归寻找，每次找到了就给k加一，找不到，还原
        if(hasPath(matrix,i-1,j,rows,cols,flag,str,k+1) ||
                hasPath(matrix,i+1,j,rows,cols,flag,str,k+1) ||
                hasPath(matrix,i,j-1,rows,cols,flag,str,k+1) ||
                hasPath(matrix,i,j+1,rows,cols,flag,str,k+1))
        {
            return true;
        }
        // 走到这，说明这一条路不通，还原，再试其他的路径
        flag[index] = false;
        return false;
    }


    public static void main(String[] args) {
        char[] matrix =  {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        int rows = 3;
        int cols = 4;
        char[] str1 = {'b','c','c','e','d'};
        char[] str2 = {'a','b','c','b'};
        System.out.println(new HasPath().hasPath(matrix, rows, cols, str1));
        System.out.println(new HasPath().hasPath(matrix, rows, cols, str2));
    }

}
