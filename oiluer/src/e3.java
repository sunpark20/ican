/**
 * Created by soy on 2016-02-22.
 */
public class e3 {
    public static void main(String args[]){
        long MAXNUM=600851475143L;

        double d = Math.sqrt(MAXNUM);
        int maxI=(int)d;
        System.out.println(d+" "+maxI);
        int bigPrimeFactors=0;

        for(int i=1;i<maxI;i++){
            int count=0;
            if(MAXNUM%i==0) { //나누어 떨어진 수중  이게 소수인지 찾는다.
                for(int j=2;j<i;j++){            //이게 소수인지 찾는다.
                    if(i%j==0){
                        count++;
                    }
                }
                if(count==0){
                    bigPrimeFactors = i;
                    System.out.println(i);
                }else
                    count = 0;
            }
        }
        System.out.println(bigPrimeFactors);
    }

}
