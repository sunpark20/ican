/**
 * Created by soy on 2016-02-22.
 */
public class e2 {
    public static void main(String args[]){
        final int MAXNUM=4000000;
        int sum=0;
        int[] terms=new int[MAXNUM];

        terms[0]=1;
        terms[1]=2;

        for(int i=0;i<MAXNUM;i++){
            if(i>1)
                terms[i]=terms[i-2]+terms[i-1];
            if(terms[i]>MAXNUM)
                break;
            System.out.println(terms[i]+" "+i);
            if(terms[i]%2==0)
                sum+=terms[i];
        }

        System.out.println(sum);
    }
}
