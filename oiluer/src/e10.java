/**
 * Created by soy on 2016-03-01.
 */
public class e10 {
    public static void main(String[] args) {
        final int MAX=100000000;
        long sum=0;

        int prime=1;

        long s=System.currentTimeMillis();

        while(prime++<MAX){
            if(prime==2 || prime==3 || prime==5 || prime==7) {
                //System.out.println(prime);
                //sum += prime;
                continue;
            }
            else if(prime%2==0 || prime%3==0 || prime%5==0 || prime%7==0 || prime%12==0 )
                continue;
            else{
                double d = Math.sqrt(prime);
                int maxI=(int)d;
                //System.out.println(prime+" "+d+" "+maxI);
                int count=0;
                for(int i=2;i<=maxI;i++){
                    if(prime%i==0){
                        //System.out.println("나눠지네요"+ prime +" "+count);
                        count++;
                    }
                }
                if(count==0){
                    sum=prime;
                    System.out.println(prime+"은 소수입니다.");
                }
            }
        }
        long e=System.currentTimeMillis();
        long time=(e-s)/1000;
        System.out.println(sum+" 걸린시간: "+time);
    }
}
