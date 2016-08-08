import java.util.HashSet;
import java.util.Iterator;

// question don't say terms increases by 3330.. but  solution is 3330.. @.@ confuse ...
// if number is over 4digit, i can;t solve problem.
// need parctice make permutation. and this question.

public class e49_Primepermutations {

    final static int PMAX=9999+1;
    static boolean[] pArray=new boolean[PMAX];
    static int count=0;
    static HashSet<Integer> hs=new HashSet<>();

    public static void main(String args[]) {
        //소수 10000이하 자리까지 boolean array 만들기
        makePrimeArray();
//        showPArray();
        for(int i=0;i<1000;i++){
            pArray[i]=false;
        }

        for(int i=1000;i<9999;i++){
            int startNum=i;
            String startStr=String.valueOf(startNum);
            count=0;
            hs.clear();
            permutation(startStr, 0);

            Iterator<Integer> iter=hs.iterator();
            while(iter.hasNext()){
                Iterator<Integer> iter2=hs.iterator();
                int num=iter.next();
                while(iter2.hasNext()){
                    int num2=iter2.next();
                    if(Math.abs(num-num2)==3330) {
                        System.out.println( " "+num+" "+ num2);
                        count++;
                        break;
                    }
                }
            }
            if(count==3)
                System.out.println(startNum);
        }



    }

    static void permutation(String str, int prefix){
        int len=str.length();
        if(prefix==len-1) {
            int num=Integer.valueOf(str);
            if(pArray[num]) {

                hs.add(num);
            }
            return;
        }
        permutation(str, prefix + 1);
        for(int i=0;i<str.length()-prefix-1;i++){
            String newStr=str.substring(0,prefix)+str.substring(prefix+1,len)+str.substring(prefix,prefix+1);
//            System.out.println(newStr);
            str=newStr;
            permutation(newStr, prefix+1);
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
    }

    static void showPArray(){
        for(int i=1;i<pArray.length;i++){
            if(pArray[i])
                System.out.println(i);
        }
    }


}
