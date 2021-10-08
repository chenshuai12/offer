package StringArrangement;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public ArrayList<String> permutation(String str){
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0){
            return list;
        }
        permutationCore(str.toCharArray(),0,list);
        // 将list中的字符串排序
        Collections.sort(list);
        return list;
    }

    private void permutationCore(char[] strArray, int index, ArrayList<String> list) {
        if (index == strArray.length - 1){
            // 判断是否有重复字符串
            if (!list.contains(String.valueOf(strArray))){
                list.add(String.valueOf(strArray));
            }
        }else {
            for (int i = index; i < strArray.length; i++){
                char tmp = strArray[index];
                strArray[index] = strArray[i];
                strArray[i] = tmp;
                permutationCore(strArray,index + 1,list);
                strArray[i] = strArray[index];
                strArray[index] = tmp;
            }
        }
    }
}
