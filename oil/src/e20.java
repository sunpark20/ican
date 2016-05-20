import java.math.BigInteger;

/**
 * Created by soy on 2016-03-16.
 */
public class e20 {
    public static void main(String[] args) {
        BigInteger sum=new BigInteger("1");
        BigInteger one=new BigInteger("1");
        BigInteger bi=new BigInteger("100");
        int fff=0;
        while (true){
            sum=sum.multiply(bi);
            bi=bi.subtract(one);
            if(bi.compareTo(one)==0)
                break;
        }
        for(int i=0;i<sum.toString().length();i++){

            int temp=(int)sum.toString().charAt(i)-48;
            fff+=temp;
        }
        System.out.println(sum);
        System.out.println(fff);
    }
}
