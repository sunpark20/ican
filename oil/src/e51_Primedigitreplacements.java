import java.util.HashSet;
import java.util.Iterator;

//it's solution incomplete. it need set x menually. also never stop.

public class e51_Primedigitreplacements {

    static final int NUM_MAX=10000;
    static final int PMAX=10000000+1;
    static boolean[] pArray=new boolean[PMAX];
    static int count;
    static HashSet<String> hs=new HashSet<>();
    static HashSet<Integer> hsInt=new HashSet<>();

    public static void main(String[] args){
        makePrimeArray();

        for(int target=0;target<NUM_MAX;target++) {

            String num = "xxx" + String.valueOf(target);

            hs.clear();
            permulation(num, 0);
            Iterator<String> iter = hs.iterator();
            while (iter.hasNext()) {
                count = 0;
                hsInt.clear();
                String hsStr = iter.next();
                for (int i = 0; i < 10; i++) {
                    String newStr = hsStr.replaceAll("x", String.valueOf(i));
                    if (newStr.charAt(0) != (char) 0 + 48) {
                        hsInt.add(Integer.valueOf(newStr));
                    }
                }
                Iterator<Integer> iterInt = hsInt.iterator();
                while (iterInt.hasNext()) {
                    Integer hsInt = iterInt.next();
                    if (pArray[hsInt]) {
                        //                    System.out.println(" "+hsInt);
                        count++;
                    }
                }
                if (count == 8) {
                    System.out.println(hsStr + " "+hsInt+" " + count);
                }

            }
        }
    }

    static void permulation(String str, int prefix){
        if(prefix==str.length()-1) { //종료조건
            hs.add(str);
            return;
        }
        permulation(str, prefix+1);

        for(int i=0;i<str.length()-prefix-1;i++){
            String last=str.substring(prefix, prefix+1);
            String first=str.substring(0,prefix);
            String middle=str.substring(prefix+1, str.length());
            String c=first+middle+last;
            str=c;
//            System.out.println(" "+c);
            permulation(c, prefix + 1);
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