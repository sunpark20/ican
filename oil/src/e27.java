//need optimise isPrime
//it consume long time

/**
 * Created by sun on 2016-04-29.
 */
public class e27 {
    public static void main(String args[]){
        final int MAX=300;
        int n,a,b,result,L,count;
        L=0;

        for(a=-999;a<1000;a++){
            for(b=-999;b<1000;b++){
                count=0;
                for(n=0;n<MAX;n++) {
                    result=n*n + a*n + b;
                    if(isPrime(result))
                        count++;
                }
                if(L<count) {
                    L = count;
                    System.out.println("bingo!!  "+L +" "+ a+" "+b+" "+n);
                }
            }
        }


//        for(int u=2;u<100;u++) {
//            if(isPrime(u))
//                System.out.println(u + " " + isPrime(u));
//        }

    }

    static int sqrt(int target){
        double d=target;
        return (int)Math.sqrt(d);
    }
    static boolean isPrime(int t){
        final int MAX=sqrt(t);
        if(t<=0)
            return false;
        if(t==2 || t==3 || t==5 || t==7)
            return true;
        if(t%2==0 || t%3==0)
            return false;


        for(int i=2;i<=MAX;i++){
            if(t%i==0)
                return false;
        }
        return true;
    }
}
