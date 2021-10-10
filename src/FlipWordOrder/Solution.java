package FlipWordOrder;

public class Solution {

    public String ReverseSentence(char[] chars) {
        if(chars==null || chars.length<=0)
            return String.valueOf(chars);
        //翻转整个句子
        reverseSb(chars,0,chars.length-1);
        //翻转单词（指针指向单词的第一个和最后一个）
        int start=0;
        int end=0;
        while(start<chars.length){
            while(end<chars.length && chars[end]!=' ')
                end++;
            reverseSb(chars,start,end-1);
            start=++end;
        }
        /*翻转单词的另一种写法（指针指向blank位置）
        int blank = -1;
        for(int i = 0;i < chars.length;i++){
            if(chars[i] == ' '){
                int nextBlank = i;
                reverse(chars,blank + 1,nextBlank - 1);
                blank = nextBlank;
            }
        }
        reverse(chars,blank + 1,chars.length - 1);//最后一个单词单独进行反转
        */
        return String.valueOf(chars);
    }

    private void reverseSb(char[] chars,int start,int end){
        while(start<end){
            char temp=chars[start];
            chars[start]=chars[end];
            chars[end]=temp;
            start++;
            end--;
        }
    }

}
