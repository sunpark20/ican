import java.math.BigInteger;

/**
 * Created by soy on 2016-02-22.
 */
public class e48_Selfpowers {
    public static void main(String args[]){
        final int MAX=1000;
        BigInteger num=new BigInteger("1");
        BigInteger sum=new BigInteger("0");
        for(int i=1;i<=MAX;i++){
            sum=sum.add(selfPower(num));
            //1증가시키기
            int iNum=Integer.parseInt(num.toString())+1;
            String sNum=String.valueOf(iNum);
            num=new BigInteger(sNum);
        }
        System.out.println(sum);
    }
    private static BigInteger selfPower(BigInteger num){
        BigInteger sum=new BigInteger("1");
        System.out.println(num);
        final int MAX=Integer.parseInt(num.toString());
        for(int i=0;i<MAX;i++){
            sum=sum.multiply(num);
        }
        System.out.println(sum+"제곱 ");
        return sum;
    }
}
