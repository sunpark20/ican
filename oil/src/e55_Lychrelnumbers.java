//startNum Palindorium don't assume laychelNum.. fuck my 1hour...

import java.math.BigInteger;

public class e55_Lychrelnumbers {
    private static int count=0;
    public static void main(String[] args){
        final int MAX=10000;
//        int iTarget=998;
        for(int iTarget=1;iTarget<=MAX;iTarget++){
            System.out.println(iTarget);
            String target=String.valueOf(iTarget);
            Counting(target);
        }

        System.out.println(count);

    }
    static boolean Counting(String target){
        String m=target;
        //fifty Cal
        for(int i=0;i<49;i++){ //
            //add reverse num
            StringBuilder sb=new StringBuilder(target);
            String reverseNum=sb.reverse().toString();
            BigInteger b1=new BigInteger(target);
            BigInteger b2=new BigInteger(reverseNum);
            b1=b1.add(b2);
            target=b1.toString();
            if(isPalindrome(target))
                return false;
        }
        count++;
        System.out.println(count + " "+m+" "+target);
        return true;
    }

    static boolean isPalindrome(String num){
        StringBuilder sb=new StringBuilder(num);
        String reverseNum=sb.reverse().toString();
        if(num.equals(reverseNum))
            return true;
        else
            return false;
    }
}

