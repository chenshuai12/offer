package RegularExpression;

public class Solution {

    public boolean match(String str, String pattern){
        int len1 = str.length(), len2 = pattern.length();
        // 定义dp[i][j]:s的前i个字符，和p的前j个字符可以匹配
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        // 都为空串，符合条件，可以匹配
        dp[0][0] = true;
        // 正则为空，字串不为空，必不能匹配
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = false;
        }
        // 正则不为空，字串为空，需要看情况
        for (int i = 2; i <= len2; i++) {
            dp[0][i] = dp[0][i - 2] && pattern.charAt(i - 1) == '*';
        }
        // 递推
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 如果为*，考虑*前一个字符在s串中能不能匹配
                if(pattern.charAt(j - 1) == '*'){
                    if(j >= 2){
                        // 默认没有出现过，那么*就代表0次，*和前一个字符作废，能否匹配取决于用前j-2个字符和s的前i个字符能否匹配
                        dp[i][j] |= dp[i][j - 2];
                        // 如果上一个字符能够匹配
                        if(str.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.') {
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                }else {
                    if(pattern.charAt(j - 1) == str.charAt(i - 1) || pattern.charAt(j - 1) == '.'){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[len1][len2];
    }
}
