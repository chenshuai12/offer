package NumInArray;

import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        int[][] array = {{1,2,3,4,5},{2,3,4,5,6},{3,4,5,6,7},{4,5,6,7,8},{5,6,7,8,9}};
        int target = 10;
        Test test = new Test();
        boolean result = test.find(array,target);
        System.out.println(result);

    }

    public boolean find(int[][] array, int target){
        if (Objects.isNull(array)){
            return false;
        }

        int row = 0;
        int col = array[0].length - 1;

        while (row < array.length && col >=0){
            if (array[row][col] == target){
                return true;
            }
            if (array[row][col]  > target){
                col--;
            }else {
                row++;
            }
        }
        return false;
    }
}
