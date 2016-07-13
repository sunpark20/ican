import java.util.HashSet;

//3개의 double 이 한세트임. 이 세트가 같은걸 판별해야함.
public class e40 {
    public static void main(String[] args) {

        int sides=120;
        int MAX=sides+1;
        HashSet<Double> hs=new HashSet<>();

        for(int i=1;i<MAX;i++){
            double a=i;
            for(int j=1;j<MAX-i;j++){
                double b=j;
                double c=sides-a-b;
                if(isTri(a,b,c)) {
                    hs.add(a);
                    hs.add(b);
                    hs.add(c);
                }
            }
        }
        System.out.println(hs.size());
    }
    static boolean isTri(double a, double b,double c){

//        System.out.println(a+" "+b+" "+c);

        a=Math.pow(a, 2);
        b=Math.pow(b, 2);
        c=Math.pow(c, 2);

//        System.out.println(" "+a+" "+b+" "+c);



        if(c==(a+b))
            return true;
        else
            return false;
    }
}

