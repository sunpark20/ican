//T.T... IT IS TRASH...
// x.x sleep mode coding

public class e46_Goldbachsotherconjecture {
    final static int NUMMAX=1000000;
    final static int PMAX=NUMMAX+1;
    final static int DSMAX=4;
    static boolean[] pArray=new boolean[PMAX];
    static int[] pArray_compressed=new int[PMAX/2];


    public static void main(String[] args){
        makePrimeArray();
        int num=1;

        int temp=-1;
        int rCount=0;
        for(int j=num;j<NUMMAX;j++){
            int cNum=j;
            int i=0;
            int pNum=0;
            int memory=-1;

            while (true){
//                System.out.println(cNum+ " "+pArray_compressed[i]);
                if(cNum%pArray_compressed[i]==0) {
                    if(memory!=i) {
                        memory = i;
                        pNum++;
                    }
                    cNum = cNum / pArray_compressed[i];
                } else {
                    i++;
                }
                if(cNum==1 && pNum==DSMAX) {
                    if(temp==-1) {
                        temp = j;
                    }else{
                        if(j-temp==1){
                            temp=j;
                            rCount++;
                        }else{
                            temp=-1;
                            rCount=0;
                        }
                    }
                    if(rCount==DSMAX-1){
                        System.out.println("빙고");
                        System.exit(1);
                    }

                    System.out.println(j+" "+DSMAX+"번 나눴어요");
                    break;
                }
                if(cNum < pArray_compressed[i] || DSMAX < pNum ){
                    temp=-1;
                    rCount=0;
                    break;
                }
            }
        }

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
}

