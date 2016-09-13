import java.math.BigInteger;

//틀린 버전 _2가 정답.
//분수 계산 쓸 일이 있을까바 놔둠.

public class e57_Squarerootconvergents_1 {
    final static int MAX=100;
    private static int count=1;
    private static Frac savedVar;


    public static void main(String[] args){
        savedVar=new Frac("1","2");
        for(int i=2;i<MAX;i++) {
            System.out.println(i+" "+run().show());
        }
    }

    public static Frac run(){
        savedVar=savedVar.plus("2");
//        System.out.println(savedVar.show());
        savedVar=new Frac("1").divide(savedVar);
//        System.out.println(savedVar.show());
        return savedVar.plus("1");
    }
}

class Frac {
    BigInteger n;
    BigInteger dn;

    public Frac(String n) {
        BigInteger a=new BigInteger(n);
        this.n = a.multiply(a);
        this.dn = a;
    }

    public Frac(String n, String dn) {
        BigInteger a=new BigInteger(n);
        BigInteger b=new BigInteger(dn);
        this.n = a;
        this.dn = b;
    }
    public String show(){
       return n.toString()+" / "+dn.toString();
    }
    Frac swap(){
        return new Frac(dn.toString(), n.toString());
    }
    Frac multi(Frac f){
        BigInteger a=n.multiply(f.n);
        BigInteger b=dn.multiply(f.dn);
        return new Frac(a.toString(), b.toString());
    }
    Frac plus(String str){
        BigInteger s=new BigInteger(str);
        //1부터 정의
        BigInteger a=n.add(dn.multiply(s));
        return new Frac(a.toString(), dn.toString());
    }
    Frac divide(Frac f){
        f=f.swap();
        return this.multi(f); //결과
    }
}
