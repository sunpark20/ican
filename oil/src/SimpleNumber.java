import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by soy on 2016-06-23.
 */
public class SimpleNumber {
   int num;

    public SimpleNumber(int num) {
        this.num = num;
    }
    public String toString(){
        return String.valueOf(num);
    }
    public int hashCode(){
        return num%3;
    }
    public boolean equals(Object obj){
        SimpleNumber comp=(SimpleNumber)obj;
        if(comp.num==num)
            return true;
        else
            return false;
    }
}
class HashSetEqualityTwo{
    public static void main(String args[]){
        HashSet<SimpleNumber> hs=new HashSet<SimpleNumber>();
        hs.add(new SimpleNumber(5));
        hs.add(new SimpleNumber(4));
        hs.add(new SimpleNumber(7));
        hs.add(new SimpleNumber(57));
        hs.add(new SimpleNumber(52));
        hs.add(new SimpleNumber(53));
        System.out.println(hs.size());

        Iterator<SimpleNumber> itr=hs.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}



