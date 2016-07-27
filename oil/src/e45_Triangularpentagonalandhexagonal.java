import java.util.HashSet;
import java.util.Iterator;

//just find brute-force solution,
// is there any fomular?? good idea??
public class e45_Triangularpentagonalandhexagonal {
    static HashSet<Long> tri=new HashSet<>();
    static HashSet<Long> pen=new HashSet<>();
    static HashSet<Long> hex=new HashSet<>();
    static final int MAX=100000;
    public static void main(String[] args){
        make();
        show();
    }
    static void make(){
        for(int i=1;i<MAX;i++) {
            Long r1 = i * (i + 1L) / 2L;
            tri.add(r1);
            Long r2 = i * (3L * i - 1L) / 2L;
            pen.add(r2);
            Long r3 = i * (2L * i - 1L);
            hex.add(r3);
            System.out.println( r1+ " "+r2+" "+r3);
        }
    }
    static void show(){
        Iterator<Long> ti=tri.iterator();

        while (ti.hasNext()){
            Long tNnum=ti.next();
            if(pen.contains(tNnum)){
                if(hex.contains(tNnum)) {
                    System.out.println(tNnum);
                }
            }
        }
    }
}

