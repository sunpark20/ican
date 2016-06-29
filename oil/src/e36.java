
// dToB method is not smart

public class e36 {
    public static void main(String[] args){
        final int MAX=1000000;
        long sum=0;
        for(int i=1;i<MAX;i++){
            if(isPalindrome(String.valueOf(i)) && isPalindrome(dToB(i))) {
                System.out.println(i+" "+dToB(i));
                sum += i;
            }
        }
        System.out.println("\n"+sum);
    }
    static String dToB(int d){
        String result="";
        //2 to the n
//        2 to the power of n
//        2 power n
        int two=1;
        int powerOfTwo=0;
        while(two<=d) {
            powerOfTwo++;
            two *= 2;
        }
        int length=powerOfTwo;
        result+=1;
        powerOfTwo-=2;
        d-=(two/2);


        while ( (length-1) > 0){ //2진수의 마지막비트는 위에서 채워서 -1 해줌.
            two=(int)Math.pow(2, powerOfTwo);
            if(two<=d) {
                result += 1;
                d -= two;
            } else {
                result += 0;
            }
            powerOfTwo--;

            length--;
        }
        return result;
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

