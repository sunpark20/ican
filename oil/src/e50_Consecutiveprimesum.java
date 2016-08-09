//excution time about 1m .. need optimization
public class e50_Consecutiveprimesum {

    final static int PMAX=1000000+1;
    static boolean[] pArray=new boolean[PMAX];
    static int[] pArray_compressed=new int[PMAX/2];

    public static void main(String args[]){
        makePrimeArray();
//        showComp();
        int a_c=0;
        int a_n=0;

        for(int i=0;i<pArray_compressed.length;i++){
            int target=pArray_compressed[i];
            int sum;
            int startNum=0;
            int count;

            boolean find=false;
            find=false;
            while (true){
                sum=0;
                count=0;
//                System.out.println(" "+target+" "+ pArray_compressed[startNum]+" "+startNum);
                if(find ||  target <= pArray_compressed[startNum])
                    break;
                for(int j=startNum;j<pArray_compressed.length;j++){
                    if(sum==target) {
                        if( a_c < count){
                            a_c=count;
                            a_n=target;
                            System.out.println("빙고"+a_c+" "+a_n);
                            find=true;
                        }

                        break;
                    }
                    if(target < sum)
                        break;
                    sum+=pArray_compressed[j];
//                    System.out.println(target + " "+sum);
                    count++;
                } //end for-j
                startNum++;
            } //end while

        } //end for-i
        System.out.println("최종정답"+a_c+" "+a_n);

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
