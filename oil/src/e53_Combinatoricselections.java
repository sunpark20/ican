import java.math.BigInteger;

public class e53_Combinatoricselections {
    public static void main(String[] args){
        int count=0;
        for(int i=1;i<=100;i++){
            int j=i;
            while (j!=0){
                String str=combi(i,j);
                if(str.length()>6)
                    count++;
                j--;
            }
        }
        System.out.println(count);
    }
    static String combi(int in,int ir){
        BigInteger sum=new BigInteger("1");
        BigInteger n=new BigInteger(String.valueOf(in));
        BigInteger r=new BigInteger(String.valueOf(ir));
        BigInteger nr=n.subtract(r);

        BigInteger one=new BigInteger("1");

        while (Integer.valueOf(n.toString())!=0){
            sum=sum.multiply(n);
            n=n.subtract(one);
        }
        while (Integer.valueOf(r.toString())!=0){
            sum=sum.divide(r);
            r=r.subtract(one);
        }
        while (Integer.valueOf(nr.toString())!=0){
            sum=sum.divide(nr);
            nr=nr.subtract(one);
        }
       return sum.toString();
    }
}