//I need training make permulation
//hard recursive function..

public class e43_Substringdivisibility {
    static long sum=0L;
    public static void main(String args[]) {

        permutation("", "0123456789", true);
        System.out.println(sum);

    }
   static boolean subExamin(String num){
        int[] prime={2,3,5,7,11,13,17};
       for(int i=0;i<7;i++){
           String sub=num.substring(i+1,i+4);
//           System.out.println(sub);
           if(!((Integer.valueOf(sub)%prime[i])==0))
               return false;
       }
       return true;
    }

    static void permutation(String prefix, String str, boolean zeroX) {
        if(str.length()==1) {
            prefix+=str;
//            System.out.println(prefix);
            if(subExamin(prefix)){
                System.out.println(prefix);
                sum+=Long.valueOf(prefix);
            }
            return;
        }
        int startNum;
        if(zeroX)
            startNum=1;
        else
            startNum=0;

        for(int i=startNum;i<str.length();i++){
            String nextStr;
            String nextPrefix=""+prefix+str.charAt(i);
            nextStr=str.substring(0,i)+str.substring(i+1,str.length());
//            System.out.println(nextPrefix + " " + nextStr);

            permutation(nextPrefix, nextStr, false);
        }
    }
}

