package TranslateNumbersIntoStrings;

public class Solution {

    public int getTranslationCount(int number) {
        if(number<0){
            return 0;
        }
        String sNumber=String.valueOf(number);
        int len=sNumber.length();
        int[] counts=new int[len];
        for(int i=len-1;i>=0;i--) {
            if(i==len-1) {
                counts[i]=1;
            }else {
                counts[i]=counts[i+1];
                if(canBeTrans(sNumber,i)) {
                    if(i==len-2)
                        counts[i]+=1;
                    else
                        counts[i]+=counts[i+2];
                }
            }
        }
        return counts[0];
    }

    private boolean canBeTrans(String sNumber, int i) {
        int a=sNumber.charAt(i)-'0';
        int b=sNumber.charAt(i+1)-'0';
        int convert=a*10+b;
        if(convert>=10 && convert<=25)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Solution demo= new Solution();
        System.out.println(demo.getTranslationCount(0)==1);
        System.out.println(demo.getTranslationCount(10)==2);
        System.out.println(demo.getTranslationCount(12258)==5);
        System.out.println(demo.getTranslationCount(-100)==0);
    }

}
