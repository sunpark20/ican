//describe

import java.math.BigInteger;

public class e56_Powerfuldigitsum {
    public static void main(String args[]){
        common.CalTime.mStart();
        int lastSum=0;
        // < num 2~99
        for(int num=2;num<100;num++) {
            BigInteger bi = new BigInteger(String.valueOf(num));
            // < pow 2~99까지
            for(int pow=2;pow<100;pow++){
                int sum = 0;
                String hundred = bi.pow(pow).toString();
                for (int i = 0; i < hundred.length(); i++) {
                    sum += (int) hundred.charAt(i) - 48;
                }
                if (lastSum < sum)
                    lastSum = sum;
                System.out.printf("%d의 %d승: %d\n", num, pow, sum);
            }
            // > pow

        }
        // > num
        System.out.println(lastSum);
        common.CalTime.mTime();
    }
}
