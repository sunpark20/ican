import java.math.BigInteger;

/**
 * Created by soy on 2016-03-16.
 */
public class e16 {
    public static void main(String[] args) {
        BigInteger sum=new BigInteger("2");
        BigInteger two=new BigInteger("2");
        int k=2;
        while (k!=1001) {
            sum=sum.multiply(two);
            System.out.println("2, "+k+" : "+sum);
            k++;
        }
        String target=sum.toString();
        int sum2=0;

        for(int i=0;i<target.length();i++){
            sum2+=target.charAt(i)-48;
        }
        System.out.println(sum2);
    }
}
