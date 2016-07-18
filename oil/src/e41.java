//find BigO
//prime is connect integer factorization(소인수 분해).

public class e41 {
    static final int PRIMEMAX=100000000;
    static int num=0;
    static boolean[] primeArray;

    public static void main(String args[]){
        long start=System.currentTimeMillis();

        // <<< init primeArray
        primeArray=new boolean[PRIMEMAX];
        for(int i=0;i<primeArray.length;i++){
            primeArray[i]=true;
        }
        // >>> end init primeArray

        // sqrt까지만 해보면 된다.
        double dp=PRIMEMAX;
        int sqrtPrimeMax=(int)Math.sqrt(dp);

        for(int i=2;i<sqrtPrimeMax+1;i++){
            if(primeArray[i]){
                    checkPrime(i);
            }
        }

        for(int i=PRIMEMAX-1;0<i;i--){
            if(primeArray[i]) {
                System.out.println(i);
                if (isPandigital(i)) {
                    System.out.println(" "+i);
                    break;
                }
            }
        }

        long end=System.currentTimeMillis();
        System.out.println("걸린시간"+(end-start));
    }

    static boolean isPandigital(int prime){
        String sPrime=String.valueOf(prime);
        if(sPrime.contains("0")) //0이 있다면 스킵
            return false;

        int primeLength=sPrime.length();

        // <<< init panArray
        boolean[] panArray=new boolean[primeLength];
        for(int i=0;i<primeLength;i++)
            panArray[i]=false;
        // >>> end init panArray

        for(int i=0;i<primeLength;i++){
            int eachNum=sPrime.charAt(i)-48-1; //인덱스에 맞추기 위해서 -1 더해줌
            if(eachNum>primeLength-1) //eachNum에 -1해준것과 마찬가지로 primeLength에도 -1
                return false;
            if(panArray[eachNum])
                return false;
            else
                panArray[eachNum]=true;
        }
        return true;
    }

    static void checkPrime(int prime){
        primeArray[prime]=true;

        int muledPrime=prime+prime;

        while (muledPrime<PRIMEMAX){
            primeArray[muledPrime]=false;
            muledPrime+=prime;
        }
        return;
    }

    static void showPrime(){
        for(int i=2;i<primeArray.length;i++){
            if(primeArray[i])
                System.out.println(i);
        }
    }
}

