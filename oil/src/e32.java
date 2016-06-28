import java.util.HashSet;
import java.util.Set;

/**
 * Created by soy on 2016-02-22.
 */
public class e32 {
    static boolean[] check=new boolean[9];
    static int count=0;
    static int nine=9;
    static int[] L=new int[9];
    static int[] F=new int[9];

    static final int MAX=9999;

    static Set<Integer> set=new HashSet<>();

    public static void main(String args[]){
        int multiplicant;
        int multiplier;
        initNum();

        int cantNum=1;
        int plierNum=8-cantNum;
        int productNum=9-cantNum-plierNum;
        System.out.printf("cant: %d, plier: %d, plier: %d\n", cantNum, plierNum, productNum);
        System.out.println(F[cantNum] + "~" + L[cantNum] + ", " + F[plierNum] + "~" + L[plierNum]);
        for(int i=1;i<L[4];i++){
            for(int j=1;j<L[4];j++){
                int product=i*j;
                if(product%10==0)
                    continue;
                if(MAX<product)
                    break;
                panda(i, j, product);
            }
        }
        int sum=0;
        for(int s:set)
            sum+=s;


        System.out.println(sum);
    }
    static void panda(int cant,int plier, int product){
        for(int i=0;i<check.length;i++)
            check[i]=false;
        String s_cant=String.valueOf(cant);
        if(checkSubF(s_cant))
            return;
        String s_plier=String.valueOf(plier);
        if(checkSubF(s_plier))
            return;
        String s_product=String.valueOf(product);
        if(checkSubF(s_product))
            return;
        for(int i=0;i<check.length;i++){
            if(check[i]==false)
                return;
        }
        System.out.println(cant+" "+plier+" "+product);
        set.add(product);
    }
    static boolean checkSubF(String s){
        for(int i=0;i<s.length();i++){
            int x=s.charAt(i)-48;
            if(x==0)
                return true;
            check[x-1]=true;
        }
        return false;
    }
    static void initNum(){
        L[1]=nine;
        for(int i=2;i<9;i++){
            nine*=10;
            L[i]=L[i-1]+ nine;
        }
        F[1]=1;
        for(int i=2;i<9;i++){
            F[i]=F[i-1]*10;
        }
    }
}
