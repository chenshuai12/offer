package ReplacesSpacesInStrings;

import java.util.Objects;

public class Solution {
    private static String string = "hello new world";

    //计算字符串中空格个数
    public static int getBlankNum(String string){
        int count = 0;
        for (int i = 0; i < string.length(); i++){
            String tempSting = String.valueOf(string.charAt(i));
            if (Objects.equals(tempSting," ")){
                count ++;
            }
        }
        return count;
    }
    //打印char[]数组
    public static void printString(char[] testArray){
        for (char i : testArray){
            System.out.print(i);
        }
        System.out.println();
    }

    //将字符串中的空格替换为20%

    public static void replaceAllBlack(String testString){
        if (testString == null || testString.length() <= 0){
            return;
        }
        //字符数组的初始长度、
        int originalLength = testString.length();
        //字符串数组空格替换为20%后的长度
        int newLength = getBlankNum(testString) * 2 + originalLength;
        char[] tempArray = new char[newLength];
        System.arraycopy(testString.toCharArray(),0,tempArray,0,testString.toCharArray().length);
        //从数组最后一位开始2
        int indexofOriginal = originalLength - 1;
        int indexofNew = newLength - 1;
        System.out.println("未替换空格时的字符串:");
        printString(tempArray);

        while (indexofOriginal >= 0 && indexofOriginal != indexofNew){
            if (tempArray[indexofOriginal] == ' '){
                tempArray[indexofNew--] = '%';
                tempArray[indexofNew--] = '0';
                tempArray[indexofNew--] = '2';
            }else{
                tempArray[indexofNew--] = tempArray[indexofOriginal];
            }
            indexofOriginal--;
        }
        System.out.println("替换空格后的字符串");
        printString(tempArray);
    }

    public static void main(String[] args) {
        replaceAllBlack(string);
    }
}
