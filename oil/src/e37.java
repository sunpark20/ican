
// dToB method is not smart

import java.util.HashSet;
import java.util.Iterator;

public class e37 {
    static final int MAX=999999;
    static boolean[] prime=new boolean[MAX];

    public static void main(String[] args){
        HashSet<Integer> hs=new HashSet<>();
        int count=0;
        int s=0;

        for(int i=2;i<MAX;i++){
            prime[i]=isPrime(i);
        }
        for(int i=10;i<MAX;i++){
            hs.clear();
            boolean isOk=true;
            if(prime[i]){
                if(endSidePrime(i)){
                    String intToString=String.valueOf(i);
                    String copy=intToString;
                    while(copy.length()>0) {
                        hs.add(Integer.valueOf(copy));
                        if(!prime[Integer.valueOf(copy)]) {
                            isOk=false;
                            break;
                        }
                        copy=copy.substring(1, copy.length());
                    }
                    copy=intToString;
                    while(copy.length()>0) {
                        hs.add(Integer.valueOf(copy));
                        if(!prime[Integer.valueOf(copy)]) {
                            isOk=false;
                            break;
                        }
                        copy=copy.substring(0, copy.length()-1);
                    }
                    if(isOk){
                        s+=i;
                        System.out.println(i);
                        count++;
                        if(count==11) {
                            break;
                        }
                    }
                }
            }
        }
        Iterator<Integer> iterator=hs.iterator();

        int sum=0;
        System.out.println("----------");

        while(iterator.hasNext()){
            int x=iterator.next();
            sum+=x;
            System.out.println(x);
        }
        sum=sum-7;
        System.out.println(sum);
        System.out.println(s);
    }
    static boolean endSidePrime(int num){
        //(걸러내기)양끝자리에 한자리 소수가 있는지 검사한다.
        char[] onePrime={'2','3','5','7'};
        String intToString=String.valueOf(num);

        boolean isOk1=false;
        for(int j=0;j<onePrime.length;j++){
            if(intToString.charAt(0)==onePrime[j]){
                isOk1=true;
            }
        }
        boolean isOk2=false;
        int lastIndex=intToString.length()-1;
        for(int j=0;j<onePrime.length;j++){
            if(intToString.charAt(lastIndex)==onePrime[j]){
                isOk2=true;
            }
        }

        if(isOk1 && isOk2)
            return true;
        else
            return false;
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

