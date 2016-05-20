/**
 * Created by soy on 2016-03-16.
 */
public class e15 {
    public static void main(String[] args) {
        long[] a=new long[200];
        a[0]=3;
        a[1]=6;
        int chase=2;
        while(chase!=21){
            for(int i=0;i<20;i++){
                if(i==0)
                    a[i]=a[i]+1;
                else{
                    a[i]=a[i-1]+a[i];
                }
                System.out.println("i, chase"+i+" "+chase+" "+a[i]);

                if(i==chase-1){
                    System.out.println(chase+"chase  "+a[i]*2 );
                    a[i+1]=a[i]*2;
                    break;
                }
            }
            chase++;
        }//end of while

    }
}
