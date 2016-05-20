import java.math.BigInteger;

public class e25 {
    public static void main(String args[]) {
        BigInteger a,b,c;
        a=new BigInteger("1");
        b=new BigInteger("1");

        int i=1;
        int xxx=9999;
        while (xxx-->0){
            c=a.add(b);
            a=b;
            b=c;
            i++;
            System.out.println(a+" "+b+" "+c+"   "+i+" 자리수 "+ a.toString().length() );
            if(a.toString().length()>=1000) {
                System.out.println("this!! "+i);
                break;
            }

        }






    }
}