/**
 * Created by soy on 2016-02-22.
 */
public class e1 {
    public static void main(String args[]){
        final int MAXNUM=1000;
        int sum=0;
        for(int i=0;i<MAXNUM;i++){
            if(i%3==0 || i%5==0)
                sum+=i;
        }
        System.out.println(sum);
    }
}
