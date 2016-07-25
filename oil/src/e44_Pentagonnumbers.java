// what is pentagon numbers
// why pentagon numbers????  go find wiki now,
//p_n = \tfrac{3n^2-n}{2}   i don;t know... just it is  figurate number that extends the concept of triangular and square numbers to the pentagon,

import java.util.HashSet;
import java.util.Iterator;

public class e44_Pentagonnumbers {
    static HashSet<Integer> hs=new HashSet();

    public static void main(String args[]) {
        final int MAX=10000;
        for(int i=1;i<MAX;i++){
            hs.add(makePantaNumbers(i));
        }
        Iterator<Integer> jIter=hs.iterator();

        int count=0;
        // first = pJ,  second = pK;
        while (jIter.hasNext()){
            int pJ=jIter.next();
            Iterator<Integer> kIter=hs.iterator();
            while (kIter.hasNext()){
                count++;
                int pK=kIter.next();
                if(pJ==pK)
                    continue;
                if(hs.contains(pJ+pK)){
                    System.out.println("sum 빙고");
                    int diff;
                    if(pJ>pK)
                        diff=pJ-pK;
                    else
                        diff=pK-pJ;
                    if(hs.contains(diff)){
                        System.out.println("diff 빙고"+ pJ+" "+pK);
                    }
                }
            }
        }
        System.out.println(count);
    }

    static int makePantaNumbers(int index){
        return index*(3*index-1)/2;
    }

}

