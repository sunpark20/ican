//한숫자만 소수판별할때

public class e41_1 {
    static final int PRIMEMAX=100000000;
    static int num=0;
    static int[] primeArray;
    public static void main(String args[]){

        long start=System.currentTimeMillis();

//        e.primeArray=new int[e.PRIMEMAX];
        for(int i=2;i<PRIMEMAX;i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }

        long end=System.currentTimeMillis();
        System.out.println("걸린시간"+(end-start));
    }
    static boolean isPrime(int num){
        if(num==2)//는 2 mod 예외로 바로 true;
            return true;
        if(num%2==0)
            return false;
        double dNum=num;
        int sqrt=(int)Math.sqrt(dNum);
        for(int i=3;i<sqrt+1;i++){  //2 mod는 위에서 판별하니까 3부터 시작
            if(num%i==0)
                return false;
        }
        return true;
    }
}

