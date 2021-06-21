package OneToNNumber;

public class Solution {
    StringBuilder res;
    int count = 0, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public String printNumbers(int n) {
        this.n = n;
        // 数字字符串集
        res = new StringBuilder();
        // 定义长度为n的字符列表
        num = new char[n];
        // 开启全排列递归
        dfs(0);
        // 删除最后多余的逗号
        res.deleteCharAt(res.length() - 1);
        // 转化为字符串并返回
        return res.toString();
    }

    private void dfs(int x) {
        if (x == n) {
            // 终止条件:已固定完所有位
            // 拼接num并添加至res尾部，使用逗号隔开
            res.append(String.valueOf(num) + ",");
            return;
        }
        for (char i : loop) {
            // 遍历‘0’-‘9’

            // 固定第x位为i
            num[x] = i;
            // 开启固定第x+1位
            dfs(x + 1);
        }
    }
    public void print(String str) {
        String[] strings = str.split(",");
        for (String s : strings){
            int index = 0;
            char[] res = s.toCharArray();
            while (index < res.length - 1 && res[index] == '0'){
                index++;
            }
            for (int i = index; i < res.length; i++){
                System.out.print(res[i]);
            }
            System.out.print(",");
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.printNumbers(5);
        solution.print(res);
    }
}
