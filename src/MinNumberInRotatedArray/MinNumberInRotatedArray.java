package MinNumberInRotatedArray;

public class MinNumberInRotatedArray {
    public static void main(String[] args) {
        int[] array = { 6, 6, 8, 9, 10, 1, 2, 2, 3, 3, 4, 5, 6 };
        System.out.println("test:" + minNumberInRotateArray(array));
    }

    public static int minNumberInRotateArray(int[] array){
        // 空数组或null时返回0
        if (array == null || array.length <= 0){
            return 0;
        }

        int low = 0;
        int high = array.length - 1;
        int mid  = (low + high) / 2;

        // 升序数组
        if (array[low] < array[high]){
            return array[low];
        }

        // 中间数字与首位数字相等  穷举
        if (array[mid] == array[high] && array[mid] == array[low]){
            for (int i = 0; i <= high; i++){
                if (array[i] < array[i -1]){
                    return array[i];
                }
            }
            return array[low];
        }

        // 正常情况
        while (low < high){
            if (high - low == 1){
                break;
            }
            mid = (low + high) / 2;
            if (array[mid] <= array[high]){
                high = mid;
            }
            if (array[mid] > array[high]){
                low = mid;
            }
        }
        return array[high];
    }
}
