/**
 * Created by soy on 2016-03-01.
 */
public class e9 {
    public static void main(String[] args)
    {
        int MAX=1000;
        int a=1;
        int b=1;
        int c=MAX-a-b;

        for(int i=0;i<1000;i++){
            for(int j=0;j<1000;j++){

                //System.out.println(a+" "+b+" "+c+" "+"----"+((a*a)+(b*b))+" : "+(c*c));
                if(((a*a)+(b*b))==(c*c)) {
                    System.out.println("찾았다");
                    System.out.println(a*b*c);
                }

                b++;
                c=MAX-a-b;
            }
            a++;
            b=1;
        }

    }

}
