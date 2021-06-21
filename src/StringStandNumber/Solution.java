package StringStandNumber;

public class Solution {
    /**
     * 思路：
     * 1、使用正则表达式
     */
    public boolean isNumeric(char[] str) {
        if (str == null || str.length <= 0) {
            return false;
        }
        return new String(str).matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }

    /**
     * 思路：
     * 1、遍历字符串，逐个情况判断
     */
    public boolean isNumericII(char[] str){
        if (str == null || str.length <= 0) {
            return false;
        }
        // 标记符号、小时、e是否出现过
        boolean symbol = false,decimal = false, hasE = false;
        int len = str.length;

        for (int i = 0; i < len; i++){
            if (str[i] == 'e' || str[i] == 'E'){
                if (i == len - 1){
                    // E后面一定要接数字
                    return false;
                }
                if (hasE){
                    // 不能存在两个E
                    return false;
                }
                hasE = true;
            }else if (str[i] == '+' || str[i] == '-'){
                // 第二次出现+-符号，则必须出现在e之后
                if (symbol && str[i - 1] != 'e' && str[i - 1] != 'E'){
                    return false;
                }
                // 第一次出现+-符号，且不是在字符串开头，则也也必须紧跟在e之后
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!symbol && i > 0 && str[i-1] != 'e' && str[i-1] != 'E') {
                    return false;
                }
                symbol = true;
            }else if (str[i] == '.'){
                // e后面不能接小数点，小数点不能出现两次
                if (hasE || decimal){
                    return false;
                }
                decimal = true;
            }else if (str[i] < '0' || str[i] > '9'){
                // 非法字符
                return false;
            }
        }
        return true;
    }
}
