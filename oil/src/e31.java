//Big integer fast rather than I thought.
//need change ambicious variable. It is very confuse.

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sun on 2016-04-29.
 */
public class e31 {
    static long sTime=0,eTime=0;
    static int count=0;
    static int temp=0;
    static int max=1;
    public static void main(String args[]) {
        sTime=System.currentTimeMillis();
        gaji(200);
        eTime=System.currentTimeMillis();
        System.out.println("걸린시간: " + (eTime-sTime));


    }
    static long gaji(int mm){
        max=mm;
        count=0;
        List<Integer> fCoin = new ArrayList<Integer>();
        fCoin.add(1);
        fCoin.add(2);
        fCoin.add(5);
        fCoin.add(10);
        fCoin.add(20);
        fCoin.add(50);
        fCoin.add(100);
        fCoin.add(200);
        r(fCoin, 0);
        System.out.println(count);
        return count;
    }

    static void r(List<Integer> coin,int sum){

        for(int each: coin){
            List<Integer> nCoin=new ArrayList<>(coin);
            Object o=each; //첨 보는거임1
            nCoin.remove(o);//첨 보는거임2
            int i=0;
            while (true){
                temp++;
                if(sum + each*i > max) {  // 다음수를 더했는데 200이 넘을 때는 break;
                    return;
                }
                else if(sum + each*i==max) {
                    count++;
                    return;
                }
//                System.out.println(sum + " " +"("+ each+" "+ i+") " +" "+ temp);
                r(nCoin, sum + i * each);
                i++;
            }
        }
    }

}