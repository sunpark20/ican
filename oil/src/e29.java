//Big integer fast rather than I thought.
//need change ambicious variable. It is very confuse.

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sun on 2016-04-29.
 */
public class e29 {
    public static void main(String args[]) {
        String a="2";
        BigInteger bigA=new BigInteger(a);
        int b;
        Set<String> set=new HashSet<>();

        int max=100;
        max+=1;

        String[][] str=new String[max][max];

        while (true) {
            int a_index=Integer.valueOf(a);
            if(a_index==max)
                break;
            b=2;
            str[a_index][b]=String.valueOf(a_index*a_index);
            set.add(str[a_index][b]);
            b++;
            while (true){
                if(b==max)
                    break;
                BigInteger str_M_I=new BigInteger( str[a_index][b-1] );
                BigInteger a_I=new BigInteger( a );
                str[a_index][b]=str_M_I.multiply(a_I).toString();
                set.add(str[a_index][b]);
                b++;
            }//end of inner loop
            a=plusS(a);
            System.out.println(a);
        }//end of outter loop

        for(int i=2;i<max;i++){
            for(int j=2;j<max;j++){
                System.out.println(i+" "+j+" //"+str[i][j]);
            }
        }

        System.out.println(set.size());
        for(String s:set){
            System.out.print(s+" ");
        }
    }
    static String plusS(String a){
        int c=Integer.valueOf(a);
        c+=1;
        a=String.valueOf(c);
        return a;
    }
}
