import java.math.BigDecimal;

// 만약 d가 10000이였으면 못풀었음.
// 현재는 길이 2부터 ~ 끝까지 돌리는데, 010101  013013013 이런식으로 반복되는 숫자를 판단하고
//       길이 max부터 젠다면 훨씬 빨라질 수 있음.

/**
 * Created by sun on 2016-04-29.
 */
public class e26 {
    public static void main(String args[]){
        final int TH=1000;
        final int SCALE=2000;
        BigDecimal one=new BigDecimal("1");
        BigDecimal divider=null;

        int i=1;
        int max=1;
        int maxI=0;
        //i-7 일때, 142857  6개.
        while (i++ < 1000){
            if(i%2==0 || i%5==0)
                continue;
            divider=new BigDecimal(String.valueOf(i));
            BigDecimal result=one.divide(divider, SCALE, BigDecimal.ROUND_HALF_UP);
            String sub=result.toString().substring(2,result.toString().length());

            //이 예외가 필요한지는 확실히 모르겠다.
            if(i<10){
                if(sub.charAt(0)==sub.charAt(1))
                    continue;
            }else if(i<100){
                if(sub.charAt(0)==sub.charAt(2) && sub.charAt(1)==sub.charAt(3))
                    continue;
            }
            String f=null;
            String l=null;
            int hMax=2;

            System.out.println(i+" "+sub);
            while(hMax++<SCALE/2){
                boolean b=false;
                int a=0;
                while (hMax+a+1+hMax+1 <= SCALE){
                    f=sub.substring(a,hMax+a+1);
                    l=sub.substring(hMax+a+1,hMax+a+1+hMax+1);

                    a++;

                    if(f.equals(l)) {
                        String f2=f.substring(0,f.length()/2);
                        String l2=f.substring(f.length()/2,f.length());
                        if(f2.equals(l2))
                            continue;
                        System.out.println("맞네"+ hMax+"길이");
                        System.out.println(f+" "+l);
                        if(max < hMax) {
                            max = hMax;
                            maxI=i;
                        }
                        b=true;
                        break;
                    }
                }
                if(b)
                    break;
            }
        }
        System.out.println(maxI+" "+max);
    }
}
