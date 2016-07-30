// it's hard that made loop for two conditions.

public class e47_Distinctprimesfactors {

    final static int PMAX=10000+1;
    static boolean[] pArray=new boolean[PMAX];
    static int[] pArray_compressed=new int[PMAX/2];

    public static void main(String[] args){
        makePrimeArray();
        //target = 1 제외, 소수 제외
        for(int target=3;target<PMAX;target++){
            if(target%2==0 || pArray[target])
                continue;
            // < start outer while 소수를 관리한다.
            int primeCount=0;
            while (true){
                boolean next=false;

                int squreCount=1; // <start inner while 여기선 스퀘어를 계쏙 증가해준다.
                while (true){
                    int cValue=pArray_compressed[primeCount]+squreCount*squreCount*2;
                    System.out.println(target+"  "+cValue+"="+pArray_compressed[primeCount]+" "+squreCount);
                    if(target==cValue){
                        System.out.println("ok " + target);
                        next=true;
                        break;
                    }
                    if(target<cValue)
                        break;
                    squreCount++;
                }  // >end inner while
                if(next)
                    break;
                primeCount++;
            } // > end outer while
        }
        // 멈춤조건  target < prime + 2*(1^2)

    }


    static void makePrimeArray(){
        //init Array
        for(int i=0;i<pArray.length;i++){
            pArray[i]=true;
        }
        //makePrimeArray()
        final int PMAXSQRT=(int)Math.sqrt((double)PMAX);
        for(int i=2;i<PMAXSQRT;i++){
            if(pArray[i]){
                for(int j=2;i*j<PMAX;j++){
                    pArray[i*j]=false;
                }
            }
        }
        for(int i=0;i<pArray_compressed.length;i++){
            pArray_compressed[i]=0;
        }
        //comp
        int count=0;
        for(int i=2;i<pArray.length;i++){
            if(pArray[i])
                pArray_compressed[count++]=i;
        }
    }

    static void showPArray(){
        for(int i=1;i<pArray.length;i++){
            if(pArray[i])
                System.out.println(i);
        }
    }

    static void showComp(){
        int count=0;
        while(true){
            if(pArray_compressed[count]==0)
                break;
            System.out.println(pArray_compressed[count++]);
        }
    }
}

