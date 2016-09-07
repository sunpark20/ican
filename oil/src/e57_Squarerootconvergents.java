import java.math.BigDecimal;
import java.math.BigInteger;

//이 방법으로는 죽어도 못함. N과 N-1의 분모가 겹치는듯하다. @.@ 수알못

public class e57_Squarerootconvergents {
    public static int count=1;
    final static int MAX=10000000;
    static int num=MAX;
    public static void main(String[] args){
//        for(int num=5;num<MAX;num++){
            run();
//        }
    }

    public static void run(){
        frac f1=new frac("1");
        frac f2=new frac("5","2");
        for(int i=0;i<num;i++) {
            //2 + 1
            //이 부분
            f1 = f1.divide(f2);
            System.out.println(count++ + " 결과" + f1.show());
            f1 = f1.plus("2");
            System.out.println(count++ + " 결과" + f1.show());
            //요까지.
            if( i!=MAX-1) {
                f2 = f1;
                f1 = new frac("1");
            }
        }
        f2=new frac("1");
        f2=f2.divide(f1);
        System.out.println(count++ +" 결과"+f2.show());
        f2=f2.plus("1"); //결과
        System.out.println(count++ +" 결과"+f2.show());
    }

    public static BigDecimal essence(BigDecimal a){
        return a;
    }
    public static BigDecimal frac(BigDecimal a, BigDecimal b){
        return a.divide(b);
    }
}

class frac{
    BigInteger n;
    BigInteger dn;

    public frac(String n) {
        BigInteger a=new BigInteger(n);
        this.n = a.multiply(a);
        this.dn = a;
    }

    public frac(String n, String dn) {
        BigInteger a=new BigInteger(n);
        BigInteger b=new BigInteger(dn);
        this.n = a;
        this.dn = b;
    }
    public String show(){
       return n.toString()+"/"+dn.toString();
    }
    frac swap(){
        return new frac(dn.toString(), n.toString());
    }
    frac multi(frac f){
        BigInteger a=n.multiply(f.n);
        BigInteger b=dn.multiply(f.dn);
        return new frac(a.toString(), b.toString());
    }
    frac plus(String str){
        BigInteger s=new BigInteger(str);
        //1부터 정의
        BigInteger a=n.add(dn.multiply(s));
        return new frac(a.toString(), dn.toString());
    }
    frac divide(frac f){
        f=f.swap();
        return this.multi(f); //결과
    }
}
