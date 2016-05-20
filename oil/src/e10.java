/**
 * Created by soy on 2016-03-01.
 */
public class e10 {
    public static void main(String[] args) {
        for(int u=2;u<100;u++) {
            if(isPrime(u))
                System.out.println(u + " " + isPrime(u));
        }
    }
    static int sqrt(int target){
        double d=target;
        return (int)Math.sqrt(d);
    }
    static boolean isPrime(int t){
        final int MAX=sqrt(t);
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
