/**
 * Created by soy on 2016-02-22.
 */
public class e35 {
    static final int MAX=1000000;
    static boolean[] prime=new boolean[MAX];
    public static void main(String args[]){

        int count=0;
        for(int i=2;i<MAX;i++){
            prime[i]=isPrime(i);
        }
        //2,3,5,7
        for(int i=0;i<MAX;i++){
            if(prime[i])
                if(circleTest(i))
                    count++;
        }
        System.out.println( count );
    }
    static boolean circleTest(int primeNum){
        String s=String.valueOf(primeNum);
        int l=s.length();
        if(l==1)
            return true;
        l-=1;

        for(int i=0;i<l;i++){
            char first=s.charAt(0);
            s=s.substring(1,s.length());
            s=s+first;
            if(!prime[Integer.valueOf(s)]) {
                return false;
            }
        }

        return true;
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
