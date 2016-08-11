// need condition
// ex) 166 possible   but  over 166,  impossible because 166*6= under1000 and another is over1000
// so if apply upper condition, it's solution have more performance

import java.util.HashSet;

public class e52_Permutedmultiples {

    static HashSet<String> hs=new HashSet<>();
    static String target;
    public static void main(String[] args){
        final int MAX=1000000;

        for(int i=1;i<MAX;i++){
            //init
            hs.clear();

            String str=String.valueOf(i);
            target=str;
            permulation(str, 0);
            if(hs.size()==6) {
                System.out.println(hs);
                break;
            }
        }

    }

    static void permulation(String str, int prefix){
        if(prefix==str.length()-1) { //종료조건
            int t=Integer.valueOf(target);
            int s=Integer.valueOf(str);
            if(s%t==0)
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
}